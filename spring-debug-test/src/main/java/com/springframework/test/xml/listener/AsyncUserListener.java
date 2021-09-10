package com.springframework.test.xml.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.listener
 * @className: UserListener
 * @description:
 * @author: zhi
 * @date: 2021/9/9
 * @version: 1.0
 */
@EnableAsync
@Service
public class AsyncUserListener {

	@Async
	@EventListener
	public void createdUser(UserEvent event) {
		System.out.println("Async -> " + event);
	}
}
