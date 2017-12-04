package com.example.demo.util;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FileUtils {
	private static final Logger logger = LogManager.getLogger(FileUtils.class);
	
	public static void createFolderIfNoExists(String folderName) {
		File folder = new File(folderName);
		if (!folder.exists()) {
			folder.mkdirs();
			logger.info("creating direcotry => " + folder);
		}
	}
	
	
	public static void removeFile(File filepath) {
		if (filepath.exists()) {
			filepath.delete();
			logger.info("remove file => " + filepath);
		}
	}
	
}
