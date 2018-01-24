package com.example.demo.web.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.util.FileUtils;

@RestController
public class UploadRest {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile, HttpServletRequest request) {
		try {
			String filename = uploadfile.getOriginalFilename();
			String directory = request.getContextPath() + "upload";
			FileUtils.createFolderIfNoExists(directory);

			File filepath = new File(Paths.get(directory, filename).toString());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(filepath));
			stream.write(uploadfile.getBytes());
			stream.close();
			System.out.println("creating file => " + filepath);
			// FileUtils.removeFile(filepath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
