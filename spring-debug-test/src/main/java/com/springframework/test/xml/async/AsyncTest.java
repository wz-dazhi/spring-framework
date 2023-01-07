package com.springframework.test.xml.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.async
 * @className: AsyncTest
 * @description:
 * @author: zhi
 * @date: 2022/10/13
 * @version: 1.0
 */
@EnableAsync // 必须启用, 不然不会生成代理对象
@ComponentScan("com.springframework.test.xml.async")
@Configuration
public class AsyncTest implements AsyncConfigurer {

	@Autowired(required = false)
	private AsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler;

	//	@Bean
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor e = new ThreadPoolTaskExecutor();
		e.setThreadNamePrefix("async-");
		e.setCorePoolSize(2);
		e.setMaxPoolSize(4);
		e.setKeepAliveSeconds(60);
		e.setQueueCapacity(100);
		e.initialize(); // 实现AsyncConfigurer 需要手动调用initializa() 方法
		return e;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return asyncUncaughtExceptionHandler == null ? AsyncExceptionHandler.ASYNC_EXCEPTION_HANDLER : asyncUncaughtExceptionHandler;
	}

	private static class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
		//		private static final Logger log = Logger.getLogger(AsyncExceptionHandler.class.getName());
		private static final Logger log = LoggerFactory.getLogger(AsyncExceptionHandler.class);
		public static final AsyncExceptionHandler ASYNC_EXCEPTION_HANDLER = new AsyncExceptionHandler();

		@Override
		public void handleUncaughtException(Throwable t, Method m, Object... params) {
//			log.log(Level.WARNING, t, () -> "Async线程池发生异常. 线程名称: " + Thread.currentThread().getName() +
//					", Class: " + m.getDeclaringClass().getSimpleName() +
//					", method: " + m.getName() +
//					", params: " + Arrays.toString(params));
			log.error("Async线程池发生异常. 具体方法: {}.{}, params: {}, t: ",
					m.getDeclaringClass().getTypeName(),
					m.getName(),
					Arrays.toString(params),
					t);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// 1. AsyncExecutionInterceptor 先从AsyncConfigurer获取线程池.
		// 2. 如果获取不到, 就从容器中获取. getBean(TaskExecutor.class) 获取一次 ; getBean(Executor.class) getBean(Executor.class) 获取两次
		// 3. 还是获取不到, 子类重写getDefaultExecutor() new SimpleAsyncTaskExecutor()

		ApplicationContext ac = new AnnotationConfigApplicationContext(AsyncTest.class);
		// 代理对象拦截器 AsyncExecutionInterceptor
		AsyncServiceJDK jdk = ac.getBean(AsyncServiceJDK.class);
		jdk.m("jdk");

		// 代理对象拦截器 AsyncExecutionInterceptor
		AsyncServiceCglib cglib = ac.getBean(AsyncServiceCglib.class);
		cglib.m("cglib");

//		UserService us = ac.getBean(UserService.class);
//		us.say("hello world");

		TimeUnit.SECONDS.sleep(100);
	}
}
