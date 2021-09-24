package com.webmvc.test.simple.controller;

import com.webmvc.test.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping
	public String getName(@RequestParam String name) {
		return userService.getName(name);
	}
}
