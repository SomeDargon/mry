package com.mry.admin.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import com.mry.service.userInfo.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mry.util.Constants;

public class AdminSecurityInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminSecurityInterceptor.class);

	@Autowired
	private AdminService adminService;

	private Set<String> excludedUrls;

	public void setExcludedUrls(Set<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestUri = request.getRequestURI();

		logger.info("Request URL: " + requestUri);

		if (excludedUrls.contains(requestUri) || checkUrl(requestUri)) {
			return true;
		}

		String authToken = getAuthToken(request);
		if (adminService.checkAdminUserSessionErrorOrExpired(authToken)) {
			throw new BusinessException(ErrorCode.AUTHTOKEN_ERROR);
		}

		return true;
	}

	private String getAuthToken(HttpServletRequest request) {
		String authToken = request.getHeader(Constants.AUTH_TOKEN_HEADER_NAME);
		return authToken;
	}

	private boolean checkUrl(String url) {
		for (String excludedUrl : excludedUrls) {
			if (url.contains(excludedUrl)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}
}