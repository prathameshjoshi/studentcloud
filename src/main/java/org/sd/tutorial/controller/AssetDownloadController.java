// This controller handle file browse and download component.
package org.sd.tutorial.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.krams.tutorial.model.FileStream;
import org.krams.tutorial.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

@Controller
public class AssetDownloadController {

	protected static Logger logger = Logger.getLogger("controller");
	
	private String ASSET_PATH;

	@Autowired
	private RepositoryService repositoryService;

  //Download Asset
	@RequestMapping("/assets/{assetName}")
	public void getAsset(@PathVariable("assetName") String assetName,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
			
		logger.debug(" ** getAsset method of AssetDownloadController Invoked ** ");
		
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		ASSET_PATH = user.getUsername();
		String mimetype = request.getSession().getServletContext()
				.getMimeType(assetName);
		FileStream file = repositoryService.getAssetByName(ASSET_PATH,
				assetName);
		response.setContentType(mimetype);
		response.setContentLength((int) file.getSize());
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ assetName + "\"");
		FileCopyUtils.copy(file.getInputStream(), response.getOutputStream());
		
		logger.debug(" ** getAsset method of AssetDownloadController Revoked");

	}

  //Download Asset List
	@RequestMapping("/assets")
	public String getAssetList(Model model) {
		logger.debug(" ** getAssetList method of AssetDownloadController Invoked ** ");
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		ASSET_PATH = "/" + user.getUsername();
		List<String> assets = repositoryService.getAssetList(ASSET_PATH);
		Gson gson = new Gson();
		String jsonNames = gson.toJson(assets);
		String username = user.getUsername();
		// String[] strarray = assets.toArray(new String[assets.size()]);
		model.addAttribute("assets", jsonNames);
		model.addAttribute("url",
				"https://s3.amazonaws.com/elasticbeanstalk-us-east-1-513927294074"
						+ ASSET_PATH);
		logger.debug(" ** getAssetList method of AssetDownloadController Revoked ** ");
		model.addAttribute("username", username);
		return "assetList";
	}

  //Delete Asset
	@RequestMapping(method = RequestMethod.POST)
	public String deleteAsset(@RequestParam("assetname") String assetname) {

		logger.debug(" ** Request to show assetuploadcomplete **");
		repositoryService.deleteAsset(ASSET_PATH, assetname);

		return "deletecomplete";
	}
}
