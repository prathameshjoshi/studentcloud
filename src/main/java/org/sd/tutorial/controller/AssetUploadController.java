// This file handle upload component
package org.sd.tutorial.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.krams.tutorial.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/main")
public class AssetUploadController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private RepositoryService repositoryService;

	private String ASSET_PATH;

  //upload form
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
	
		logger.debug(" ** Request to show assetupload ** ");
	
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		ASSET_PATH = user.getUsername();
		String username = user.getUsername();
		RequestContextHolder.currentRequestAttributes().getAttribute(
				"usersession", RequestAttributes.SCOPE_SESSION);
		model.addAttribute("username", username);
		return "uploadForm";
	}

  //upload file to amazon
	@RequestMapping(method = RequestMethod.POST)
	public String handleUpload(
			@RequestParam("assetFile") MultipartFile assetFile)
			throws IOException {
			
		logger.debug(" ** Request to show assetuploadcomplete **");
		
		if (assetFile != null) {
			repositoryService.putAsset(ASSET_PATH, assetFile
					.getOriginalFilename(),
					new ByteArrayInputStream(assetFile.getBytes()));
		}
		return "uploadComplete";
	}
}
