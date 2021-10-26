package com.webmvc.test.handler.beanname;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

	@SuppressWarnings("serial")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//return new ModelAndView(new MappingJackson2JsonView(), "name", "Controller => " + request.getParameter("name"));
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		/**
		 * <pre>
		 * {
		 *   	"r": {
		 *     		"code": "0",
		 *     		"msg": "成功",
		 *     		"data": {
		 *       		"number": 10,
		 *       		"name": null,
		 *       		"age": null
		 *            }
		 *        }
		 * }
		 * </pre>
		 */
//		mv.addObject(new R<Map<String, Object>>("0", "成功", new HashMap<String, Object>() {{
//			put("name", request.getParameter("name"));
//			put("age", request.getParameter("age"));
//			put("number", 10);
//		}}));
		R<Map<String, Object>> r = new R<>("0", "成功", new HashMap<String, Object>() {{
			put("name", request.getParameter("name"));
			put("age", request.getParameter("age"));
			put("number", 10);
		}});
		/**
		 * <pre>
		 * {
		 *   	"msg": "成功",
		 *   	"code": "0",
		 *   	"data": {
		 *     		"number": 10,
		 *     		"name": null,
		 *     		"age": null
		 *        },
		 *   	"isSuccess": true
		 * }
		 * </pre>
		 */
		mv.addObject("code", r.getCode());
		mv.addObject("msg", r.getMsg());
		mv.addObject("data", r.getData());
		mv.addObject("isSuccess", r.isSuccess());
		return mv;
	}

	@SuppressWarnings("serial")
	public static class R<T> implements Serializable {
		String code;
		String msg;
		T data;

		public R() {
		}

		public R(String code, String msg, T data) {
			this.code = code;
			this.msg = msg;
			this.data = data;
		}

		public boolean isSuccess() {
			return "0".equals(code);
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}
	}
}
