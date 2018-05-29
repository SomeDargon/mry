package com.mry.admin.interceptor;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.mry.util.Constants;

public class FakeHeadersRequest extends HttpServletRequestWrapper {
	public FakeHeadersRequest(HttpServletRequest request) {
		super(request);
	}

	public String getHeader(String name) {
		HttpServletRequest request = (HttpServletRequest) getRequest();

		if (Constants.AUTH_TOKEN_HEADER_NAME.equals(name)) {
			String authToken = (String) request.getSession().getAttribute(
					Constants.AUTH_TOKEN_HEADER_NAME);
			return authToken;
		}

		return request.getHeader(name);
	}

	public Enumeration<String> getHeaderNames() {
		List<String> names = Collections.list(super.getHeaderNames());

		names.add(Constants.AUTH_TOKEN_HEADER_NAME);

		return Collections.enumeration(names);
	}

}
