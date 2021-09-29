package com.webmvc.test.handler.beanname;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @projectName: spring
 * @package: com.webmvc.test.handler.mapping.beanname
 * @className: AController
 * @description:
 * @author: zhi
 * @date: 2021/9/27
 * @version: 1.0
 */
public class AController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView(new MappingJackson2JsonView(), "name", "Controller => " + request.getParameter("name"));
	}
}
