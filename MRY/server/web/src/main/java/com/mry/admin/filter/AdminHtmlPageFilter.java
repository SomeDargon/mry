package com.mry.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mry.util.Constants;

public class AdminHtmlPageFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(AdminHtmlPageFilter.class);
	private static final String LOGIN_PAGE = "/admin/login.jsp";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		String requestUri = req.getRequestURI();
		logger.info("Admin Request HTML Page: " + requestUri);
		if (LOGIN_PAGE.equalsIgnoreCase(requestUri)) {
			chain.doFilter(request, response);
		} else {
			String authToken = (String) req.getSession(true).getAttribute(
					Constants.AUTH_TOKEN_HEADER_NAME);
			if (StringUtils.isBlank(authToken)) {
				((HttpServletResponse) response).sendRedirect(LOGIN_PAGE);
			} else {
				chain.doFilter(request, response);
			}
		}
	}
}
