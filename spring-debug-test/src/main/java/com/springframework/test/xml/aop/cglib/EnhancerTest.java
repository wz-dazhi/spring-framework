package com.springframework.test.xml.aop.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.aop
 * @className: EnhancerTest
 * @description:
 * @author: zhi
 * @date: 2021/7/27
 * @version: 1.0
 */
public class EnhancerTest {
	public static void main(String[] args) {
		// System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/wangzhi/work/project/spring-framework/spring-debug-test/src/main/java/com/springframework/test/xml/aop");
		// final Enhancer enhancer = new Enhancer();
		// enhancer.setSuperclass(UserService.class);
		// enhancer.setCallback(NoOp.INSTANCE);
//		enhancer.setCallback((MethodInterceptor) (obj, method, arg, proxy) -> {
//			System.out.println("-------MethodInterceptor---------");
//			return proxy.invokeSuper(obj, arg);
//		});
//		final UserService userService = (UserService) enhancer.create();
//		System.out.println(userService.getClass());
//		userService.show();

		final EnhancerFactory<UserService> factory = new EnhancerFactory<>(UserService.class);
		final UserService userService = factory.getObject();
		userService.show("");
	}

	private static class EnhancerFactory<T> {
		private Class<T> clazz;
		private Callback callback = NoOp.INSTANCE;

		public EnhancerFactory(Class<T> clazz) {
			this.clazz = clazz;
		}

		public void setCallback(Callback callback) {
			this.callback = callback;
		}

		@SuppressWarnings({"unchecked"})
		public T getObject() {
			final Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(clazz);
			enhancer.setCallback(callback);
			return (T) enhancer.create();
		}
	}
}
