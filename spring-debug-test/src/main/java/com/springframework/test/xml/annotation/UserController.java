package com.springframework.test.xml.annotation;

import org.springframework.beans.factory.annotation.Value;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.annotation
 * @className: UserController
 * @description:
 * @author: zhi
 * @date: 2021/7/21
 * @version: 1.0
 */
@ComponentZhi
public class UserController {
	@Zhi
	private UserService userService;

	@Value("${user.home}")
	private String userHome;

	public void show() {
		System.out.println(userHome);
		userService.show();
	}
}
