package com.hp.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileUploadCommand {
	
	private MultipartFile file1;
	private MultipartFile file2;
}
