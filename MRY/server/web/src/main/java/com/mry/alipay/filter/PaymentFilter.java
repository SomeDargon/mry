package com.mry.alipay.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(PaymentFilter.class);
	private static final String RETURN_URL = "/payment/return";	//TODO: 最好从数据库取, 保持一致性
	private static final String RETURN_PAGE = "/#/patient/payment_return?";

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
		logger.info("Payment Request HTML Page: " + requestUri);
		if (requestUri.indexOf(RETURN_URL) != -1) {
			((HttpServletResponse) response).sendRedirect(req.getContextPath() + RETURN_PAGE + req.getQueryString());
		}else{
			chain.doFilter(request, response);
		}
	}
}
