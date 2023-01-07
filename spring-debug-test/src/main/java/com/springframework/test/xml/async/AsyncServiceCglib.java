package com.springframework.test.xml.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.async
 * @className: AsyncServiceCglib
 * @description:
 * @author: zhi
 * @date: 2022/10/13
 * @version: 1.0
 */
@Async
@Service
public class AsyncServiceCglib {

	public void m(String s) {
		System.out.println("AsyncServiceCglib -> " + s + " --> " + Thread.currentThread().getName());
//		throw new RuntimeException(s);
	}
}
