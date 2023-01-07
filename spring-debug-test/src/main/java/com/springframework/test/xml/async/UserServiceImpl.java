package com.springframework.test.xml.async;

import org.springframework.stereotype.Service;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.async
 * @className: UserServiceImpl
 * @description:
 * @author: zhi
 * @date: 2022/10/13
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	private final AsyncServiceJDK asyncServiceJDK;
	private final AsyncServiceCglib asyncServiceCglib;

	public UserServiceImpl(AsyncServiceJDK asyncServiceJDK, AsyncServiceCglib asyncServiceCglib) {
		this.asyncServiceJDK = asyncServiceJDK;
		this.asyncServiceCglib = asyncServiceCglib;
	}

	@Override
	public void say(String s) {
		asyncServiceJDK.m(s);
		asyncServiceCglib.m(s);
	}
}
