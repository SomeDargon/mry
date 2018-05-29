package com.mry.resources;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.mry.service.helper.FilePath;
import com.mry.util.properties.ConfigPropertiesUtil;
import org.apache.commons.lang.StringUtils;

import com.mry.util.Constants;

public abstract class BaseResource {

	private static final String CONFIG_PATH_KEY = "system.save.pic.parent";
	private static final String PIC_HOST_KEY = "pic.server.host";
	
	protected static final String BINARY_HEADER = "application/octet-stream";

	protected static String getAbsolutePath(HttpServletRequest request) {
		String absolutePath = System.getProperty(CONFIG_PATH_KEY);
		if (StringUtils.isBlank(absolutePath)) {
			absolutePath = ConfigPropertiesUtil.getString(CONFIG_PATH_KEY);
		}

		if (StringUtils.isBlank(absolutePath)) {
			absolutePath = request.getSession().getServletContext()
					.getRealPath("/");

			File file = new File(absolutePath);
			absolutePath = file.getParent();
		}
		return absolutePath;
	}

	protected static String getHost(HttpServletRequest request) {
		String host = System.getProperty(PIC_HOST_KEY);
		if (StringUtils.isBlank(host)) {
			host = ConfigPropertiesUtil.getString(PIC_HOST_KEY);
		}

		if (StringUtils.isBlank(host)) {
			host = "http://" + request.getServerName();
			int port = request.getServerPort();
			if (port != 80) {
				host += ":" + port;
			}
		}
		return host;
	}

	protected static FilePath getPicPath(HttpServletRequest request) {
		FilePath path = new FilePath();
		path.setAbsolutePath(getAbsolutePath(request));
		path.setHost(getHost(request));
		return path;
	}

	protected boolean isMobile(HttpServletRequest request) {
		String userAgent = request.getHeader("User-Agent");
		return Constants.ANDROID_USER_AGENT.equalsIgnoreCase(userAgent)
				|| Constants.IOS_USER_AGENT.equalsIgnoreCase(userAgent);
	}
}
