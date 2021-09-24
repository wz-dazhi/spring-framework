package com.webmvc.test.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: spring
 * @package: com.webmvc.test.simple.controller
 * @className: UserController
 * @description:
 * @author: zhi
 * @date: 2021/9/17
 * @version: 1.0
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@GetMapping
	public String user() {
		return "user";
	}
}
