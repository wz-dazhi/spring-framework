package com.webmvc.test.handler.function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.ServerResponse.ok;

/**
 * @projectName: spring
 * @package: com.webmvc.test.handler.mapping.function
 * @className: UserFunction
 * @description:
 * @author: zhi
 * @date: 2021/9/26
 * @version: 1.0
 */
@Configuration
//@EnableWebMvc
public class FunctionConfiguration { //implements WebMvcConfigurer {

	@Bean
	public RouterFunction<ServerResponse> userRouterFunction() {
		return RouterFunctions.route()
				.GET("/user/{name}", req -> ok().body("RouterFunction => " + req.pathVariable("name")))
				.GET("/user", req -> ok().body(new String[]{"zhangsan", "lisi", "wangwu"}))
				.POST("/user", req -> ok().body(true))
				.DELETE("/user", req -> req.param("id").isPresent(), req -> ok().body("RouterFunction => " + req.param("id").orElse("") + "删除成功"))
				.build();
	}

//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new MappingJackson2HttpMessageConverter());
//	}

}
