package com.webflux.test.controller;

import com.webflux.test.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @projectName: spring
 * @package: com.webflux.test.controller
 * @className: UserController
 * @description:
 * @author: zhi
 * @date: 2022/1/14
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	public Mono<User> get() {
		return Mono.just(new User("张三", "123456", 20));
	}
}
