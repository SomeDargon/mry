package com.mry.resources.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mry.util.Constants;

public class AppSecurityInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory
			.getLogger(AppSecurityInterceptor.class);

	private Set<String> excludedUrls;

	public void setExcludedUrls(Set<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestUri = request.getRequestURI();

		if (excludedUrls.contains(requestUri) || checkUrl(requestUri)) {
			return true;
		}
		String authToken = request.getHeader(Constants.AUTH_TOKEN_HEADER_NAME);
//		if (userService.checkUserSessionErrorOrExpired(authToken)) {
//			throw new BusinessException(ErrorCode.AUTHTOKEN_ERROR);
//		}

		return true;
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
