package org.krams.tutorial.service.impl;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.krams.tutorial.model.FileStream;
import org.krams.tutorial.service.RepositoryService;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class RepositoryAmazonS3Impl implements RepositoryService {

	protected static Logger logger = Logger.getLogger("service");

	private static final String FOLDER_SUFFIX = "/";

	private final AmazonS3 s3;
	private String bucket;

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public RepositoryAmazonS3Impl(AmazonS3 client) {
		s3 = client;
	}

	@Override
	public FileStream getAssetByName(String path, String name)
			throws FileNotFoundException {
		logger.debug(" ** getAssetByName method of RepositoryAmazonS3Impl class Invoked ** ");
		S3Object obj = s3.getObject(new GetObjectRequest(bucket,
				getS3Path(path) + name));
		FileStream result = new FileStream(obj.getObjectContent(), obj
				.getObjectMetadata().getContentLength());
		logger.debug(" ** getAssetByName method of RepositoryAmazonS3Impl class Revoked ** ");
		return result;
	}

	@Override
	public List<String> getAssetList(String path) {
		logger.debug(" ** getAssetList method of RepositoryAmazonS3Impl class Invoked ** ");
		List<String> result = new ArrayList<String>();
		ObjectListing objList = s3.listObjects(bucket, getS3Path(path));
		for (S3ObjectSummary summary : objList.getObjectSummaries()) {
			// ignore folders
			if (!summary.getKey().endsWith(FOLDER_SUFFIX)) {
				result.add(summary.getKey().substring(path.length()));
			}
		}
		logger.debug(" ** getAssetList method of RepositoryAmazonS3Impl class Revoked ** ");
		return result;
	}

	@Override
	public void putAsset(String path, String assetName, InputStream asset) {

		// debug
		logger.debug(" ** putAsset method of RepositoryAmazonS3Impl Class Invoked ** ");

		ObjectMetadata meta = new ObjectMetadata();
		meta.setContentLength(((ByteArrayInputStream) asset).available());
		PutObjectRequest ObjRequest = new PutObjectRequest(bucket,
				getS3Path(path) + assetName, asset, meta);
		ObjRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		s3.putObject(ObjRequest);
		// debug
		logger.debug(" ** putAsset method of RepositoryAmazonS3Impl class Revoked ** ");

	}

	@Override
	public void deleteAsset(String path, String assetName) {
		DeleteObjectRequest ObjRequest = new DeleteObjectRequest(bucket,
				getS3Path(path) + assetName);
		s3.deleteObject(ObjRequest);
	}

	private String getS3Path(String path) {
		// remove root path: /
		if (path.startsWith(FOLDER_SUFFIX)) {
			path = path.substring(1);
		}

		return path + FOLDER_SUFFIX;
	}
}
