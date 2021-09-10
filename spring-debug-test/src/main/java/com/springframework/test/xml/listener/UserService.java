package com.springframework.test.xml.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.listener
 * @className: UserService
 * @description:
 * @author: zhi
 * @date: 2021/9/9
 * @version: 1.0
 */
@Service
public class UserService implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void createUser(String id, String name) {
		System.out.println("创建用户: id=" + id + ", name=" + name);
		applicationContext.publishEvent(new UserEvent(id, name));
	}

}
