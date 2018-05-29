package com.mry.cometd.app;

import com.mry.service.helper.FilePath;

public class Application {

	private static FilePath filePath;

	public static FilePath getFilePath() {
		return filePath;
	}

	public static void setImagePath(FilePath imagePath) {
		Application.filePath = imagePath;
	}

}
