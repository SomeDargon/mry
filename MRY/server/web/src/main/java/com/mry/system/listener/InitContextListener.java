package com.mry.system.listener;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mry.service.helper.FilePath;
import com.mry.util.properties.ConfigPropertiesUtil;
import org.apache.commons.lang.StringUtils;

import com.mry.cometd.app.Application;

public class InitContextListener implements ServletContextListener {

	private static final String CONFIG_PATH_KEY = "system.save.pic.parent";
	private static final String PIC_HOST_KEY = "pic.server.host";

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		String absolutePath = getAbsolutePath(ctx);
		String host = getHost();

		Application.setImagePath(new FilePath(host, absolutePath));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	protected static String getAbsolutePath(ServletContext ctx) {
		String absolutePath = System.getProperty(CONFIG_PATH_KEY);
		if (StringUtils.isBlank(absolutePath)) {
			absolutePath = ConfigPropertiesUtil.getString(CONFIG_PATH_KEY);
		}

		if (StringUtils.isBlank(absolutePath)) {
			absolutePath = ctx.getRealPath("/");

			File file = new File(absolutePath);
			absolutePath = file.getParent();
		}
		return absolutePath;
	}

	protected static String getHost() {
		String host = System.getProperty(PIC_HOST_KEY);
		if (StringUtils.isBlank(host)) {
			host = ConfigPropertiesUtil.getString(PIC_HOST_KEY);
		}

		if (StringUtils.isBlank(host)) {
			host = getExternalIp();
		}
		return host;
	}

	private static String getExternalIp() {
		BufferedReader in = null;
		try {
			URL whatismyip = new URL("http://checkip.amazonaws.com");
			in = new BufferedReader(new InputStreamReader(
					whatismyip.openStream()));

			String ip = in.readLine();
			return ip;
		} catch (Exception e) {

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getExternalIp());
	}
}
