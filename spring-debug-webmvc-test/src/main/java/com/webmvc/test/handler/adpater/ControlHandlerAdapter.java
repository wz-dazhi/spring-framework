package com.webmvc.test.handler.adpater;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @projectName: spring
 * @package: com.webmvc.test.handler.adpater
 * @className: ControlHandlerAdapter
 * @description:
 * @author: zhi
 * @date: 2021/9/27
 * @version: 1.0
 */
public class ControlHandlerAdapter implements HandlerAdapter {
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public boolean supports(Object handler) {
		return handler instanceof Control;
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Object v = ((Control) handler).process(request);
		PrintWriter w = response.getWriter();
		w.write(mapper.writeValueAsString(v));
		w.flush();
		w.close();
		return null;
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		return -1;
	}
}
