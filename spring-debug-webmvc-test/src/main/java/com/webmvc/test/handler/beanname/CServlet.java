package com.webmvc.test.handler.beanname;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @projectName: spring
 * @package: com.webmvc.test.handler.beanname
 * @className: CServlet
 * @description:
 * @author: zhi
 * @date: 2021/9/27
 * @version: 1.0
 */
//public class CServlet implements Servlet {
@SuppressWarnings("serial")
public class CServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		String id = req.getParameter("id");
		PrintWriter w = res.getWriter();
		w.println("Servlet => " + id);
		w.flush();
		w.close();
	}

}
