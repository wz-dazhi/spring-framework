package com.springframework.test.xml.annotation;

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

	public void show() {
		userService.show();
	}
}
