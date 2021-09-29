package com.webmvc.test.handler.beanname;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @projectName: spring
 * @package: com.webmvc.test.handler.beanname
 * @className: BHttpRequestHandler
 * @description:
 * @author: zhi
 * @date: 2021/9/27
 * @version: 1.0
 */
public class BHttpRequestHandler implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		PrintWriter w = response.getWriter();
		w.write("HttpRequestHandler => " + id);
		w.flush();
		w.close();
	}

}
