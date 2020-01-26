package com.hp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hp.command.FileUploadCommand;

@Controller
public class FileUploadController {

	@GetMapping("/home.htm")
	public String loadHomePage(@ModelAttribute("uplCmd") FileUploadCommand cmd) {
		return "home";
	}

	@PostMapping("/register.htm")
	public String handleForm(@ModelAttribute("uplCmd") FileUploadCommand cmd, HttpServletRequest req) throws Exception {

		ServletContext sc = null;
		File uplLoc = null;
		InputStream is1, is2 = null;
		String fname1, fname2 = null;
		OutputStream os1, os2 = null;

		sc = req.getServletContext();
		uplLoc = new File(sc.getInitParameter("uplLocation"));

		if (!uplLoc.exists()) {
			System.out.println("Dir");
			uplLoc.mkdir();
		}

		is1 = cmd.getFile1().getInputStream();
		is2 = cmd.getFile2().getInputStream();

		fname1 = cmd.getFile1().getOriginalFilename();
		fname2 = cmd.getFile2().getOriginalFilename();

		os1 = new FileOutputStream(uplLoc.getAbsolutePath() + "/" + fname1);
		os2 = new FileOutputStream(uplLoc.getAbsolutePath() + "/" + fname2);

		IOUtils.copy(is1, os1);
		IOUtils.copy(is2, os2);

		os1.close();
		os2.close();
		is1.close();
		is2.close();

		return "redirect:/getAllFilesList.htm";
	}

}
