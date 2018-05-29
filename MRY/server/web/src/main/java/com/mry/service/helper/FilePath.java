package com.mry.service.helper;

public class FilePath {
	private String host;
	private String absolutePath;

	public FilePath() {
	}

	public FilePath(String host, String absolutePath) {
		this.host = host;
		this.absolutePath = absolutePath;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

}
