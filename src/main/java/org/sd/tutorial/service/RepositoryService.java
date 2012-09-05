package org.sd.tutorial.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.sd.tutorial.model.FileStream;

public interface RepositoryService {
	public void putAsset(String path, String assetName, InputStream asset);

	public List<String> getAssetList(String path);

	public FileStream getAssetByName(String path, String name)
			throws FileNotFoundException;

	public void deleteAsset(String path, String assetName);
}
