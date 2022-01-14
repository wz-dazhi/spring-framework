package com.webflux.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @projectName: spring
 * @package: com.webflux.test.controller
 * @className: HelloController
 * @description:
 * @author: zhi
 * @date: 2022/1/14
 * @version: 1.0
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just("hello world");
	}
}
