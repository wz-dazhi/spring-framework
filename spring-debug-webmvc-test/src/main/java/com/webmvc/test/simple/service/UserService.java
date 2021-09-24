package com.webmvc.test.simple.service;

import org.springframework.stereotype.Service;

/**
 * @projectName: spring
 * @package: com.webmvc.test.service
 * @className: UserService
 * @description:
 * @author: zhi
 * @date: 2021/9/17
 * @version: 1.0
 */
@Service
public class UserService {
	public String getName(String name) {
		return "hello " + name;
	}
}
