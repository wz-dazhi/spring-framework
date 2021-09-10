package com.springframework.test.xml.listener;

import org.springframework.context.event.EventListener;
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
@Service
public class UserListener {

	@EventListener
	public void createdUser(UserEvent event) {
		System.out.println(event);
	}
}
