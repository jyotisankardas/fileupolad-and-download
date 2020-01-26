package com.hp.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileDownloadMgmtServiceImpl implements FileDownloadMgmtService {

	public List<String> getAvailableFiles(String fileLocation) {
		File storeLocation = null;
		List<String> locationOfFiles = null;
		File files[] = null;

		storeLocation = new File(fileLocation);
		locationOfFiles = new ArrayList<String>();

		if (storeLocation.exists()) {
			files = storeLocation.listFiles();
			for (File f : files) {
				locationOfFiles.add(f.getName());
			}
		}
		return locationOfFiles;
	}
}
