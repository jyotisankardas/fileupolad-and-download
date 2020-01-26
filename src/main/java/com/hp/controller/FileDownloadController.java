package com.hp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hp.service.FileDownloadMgmtService;

@Controller
public class FileDownloadController {

	@Autowired
	private FileDownloadMgmtService fileDownloadService;

	@GetMapping("/getAllFilesList.htm")
	public String showAllFilesList(Map<String, Object> map, HttpServletRequest req) {

		ServletContext sc = null;
		String fileLocation = null;
		List<String> filesLocation = null;

		sc = req.getServletContext();
		fileLocation = sc.getInitParameter("uplLocation");
		filesLocation = fileDownloadService.getAvailableFiles(fileLocation);

		map.put("FileLocation", filesLocation);

		return "file_download";
	}

	@RequestMapping("/download.htm")
	public void dowloadFiles(@RequestParam("fname") String fileName, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		ServletContext sc = null;
		String fileLocation = null;
		File file = null;
		InputStream is = null;
		OutputStream os = null;

		// Get ServletContext Object
		sc = req.getServletContext();

		// Get File Location Where File Is Available
		fileLocation = sc.getInitParameter("uplLocation");

		// Locate The File
		file = new File(fileLocation + "/" + fileName);

		// Set The Length Of File And Make It Downloadable
		res.setContentLengthLong(file.length());

		// Get MIME Type Of File And Make It As Response MIME Type
		res.setContentType(sc.getMimeType(fileLocation + "/" + fileName));

		// Make Browser Receive File As Downloadable File
		res.addHeader("Content-Disposition", "attachment;fileName=" + fileName);

		// Create InputStream Pointing To File
		is = new FileInputStream(file);

		// Create OutPut Stream
		os = res.getOutputStream();

		// Copy Files From InputStream to OutputStream
		IOUtils.copy(is, os);

		// Close Streams
		is.close();
		os.close();
	}
}
