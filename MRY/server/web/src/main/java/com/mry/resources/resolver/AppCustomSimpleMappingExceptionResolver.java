package com.mry.resources.resolver;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

@Component
public class AppCustomSimpleMappingExceptionResolver extends
		AbstractHandlerExceptionResolver {

	private static final Logger logger = LoggerFactory
			.getLogger(AppCustomSimpleMappingExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		logger.error(ex.getMessage(), ex);
		
		if (ex instanceof BusinessException) {
			return processException(response, (BusinessException) ex);
		}else{
			return processException(response, new BusinessException(ErrorCode.INTERNAL_ERROR, ex));
		}
	}

	private ModelAndView processException(HttpServletResponse response, BusinessException te) {
		ErrorCode errorCode = te.getErrorCode();
		String message = errorCode.toJson();
		logger.warn("Business Exception: " + message);
		
		response.setStatus(errorCode.getHttpStatusCode());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(message);
			writer.flush();
		} catch (Exception handlerException) {
			logger.warn("Handling of [" + te.getClass().getName()
					+ "] resulted in Exception", handlerException);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

		return new ModelAndView();
	}
}
