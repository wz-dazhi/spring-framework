package com.springframework.test.xml.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.aop.jdk
 * @className: ProxyTest
 * @description:
 * @author: zhi
 * @date: 2021/8/16
 * @version: 1.0
 */
public class ProxyTest {
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		final Class<?>[] interfaces = {IUserService.class};
		final IUserService userService = (IUserService) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), interfaces, new UserServiceInvocationHandler(new UserService()));
		userService.show("lisi");
	}

	private static class UserServiceInvocationHandler implements InvocationHandler {
		private final IUserService userService;

		public UserServiceInvocationHandler(IUserService userService) {
			this.userService = userService;
		}

		@Override
		public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
			// 这个打印会进入死循环操作, 因为proxy会去调用toString()方法
			// System.out.println("Handler---------> proxy: " + proxy + ", method: " + m + ", args: " + Arrays.toString(args));
			System.out.println("Handler---------> proxy: " + proxy.getClass().getName() + ", method: " + m + ", args: " + Arrays.toString(args));
			return m.invoke(userService, args);
		}

	}
}
