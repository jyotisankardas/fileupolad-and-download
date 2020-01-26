package com.hp.service;

import java.util.List;

public interface FileDownloadMgmtService {
	public List<String> getAvailableFiles(String fileLocation);
}
