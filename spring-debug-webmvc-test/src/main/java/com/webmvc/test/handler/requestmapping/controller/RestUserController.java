package com.webmvc.test.handler.requestmapping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webmvc.test.handler.requestmapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: spring
 * @package: com.webmvc.test
 * @className: UserController
 * @description:
 * @author: zhi
 * @date: 2021/9/17
 * @version: 1.0
 */
@RequestMapping("/rest/user")
@RestController
public class RestUserController {
	@Autowired
	private UserService userService;

	/**
	 * 由于使用自定义Tomcat 包, 可能出现乱码问题. 加上 MediaType.APPLICATION_JSON_VALUE
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String getName(@RequestParam String name) {
		System.out.println(name);
		return userService.getName(name);
	}

	@GetMapping("/obj")
	public Obj getObj(@RequestParam String name) {
		return new Obj(name);
	}

	public static class Obj {
		String name;

		public Obj() {
		}

		public Obj(String name) {
			this.name = name;
		}

//		public void setName(String name) {
//			this.name = name;
//		}

		public String getName() {
			return name;
		}
	}

	public static void main(String[] args) throws Exception {
		// 序列化 必须有get
		Obj o = new Obj("name0");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(o);
		System.out.println(json);
		// 反序列化 必须有无参构造方法
		o = mapper.readValue(json, Obj.class);
		System.out.println(o);
	}
}
