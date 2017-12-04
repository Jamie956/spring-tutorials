package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.FileUtils;


@Controller
public class MainController {
	private static final Logger logger = LogManager.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile, HttpServletRequest request) {
		try {
			String filename = uploadfile.getOriginalFilename();
			String directory = request.getContextPath() + "upload";
			FileUtils.createFolderIfNoExists(directory);

			File filepath = new File(Paths.get(directory, filename).toString());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(filepath));
			stream.write(uploadfile.getBytes());
			stream.close();
			logger.info("creating file => " + filepath);
			
//			FileUtils.removeFile(filepath);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
