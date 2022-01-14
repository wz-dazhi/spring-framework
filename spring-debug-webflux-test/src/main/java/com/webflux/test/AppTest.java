package com.webflux.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

/**
 * @projectName: spring
 * @package: com.webflux.test
 * @className: AppTest
 * @description:
 * @author: zhi
 * @date: 2022/1/14
 * @version: 1.0
 */
public class AppTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(WebFluxConfiguration.class);
		HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
		HttpServer.create()
				.host("localhost")
				.port(8080)
				.handle(adapter)
				.bindNow()
				.onDispose()
				.block();
	}

}
