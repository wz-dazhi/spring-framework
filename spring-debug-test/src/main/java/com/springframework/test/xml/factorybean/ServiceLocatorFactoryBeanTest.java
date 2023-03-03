package com.springframework.test.xml.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.factorybean
 * @className: ServiceLocatorFactoryBeanTest
 * @description:
 * @author: zhi
 * @date: 2023/3/1
 * @version: 1.0
 */
@Configuration
@ComponentScan("com.springframework.test.xml.factorybean")
public class ServiceLocatorFactoryBeanTest {

	private static class GetBeanException extends RuntimeException {
		public static final long serialVersionUID = 1L;

		public GetBeanException(Throwable cause) {
			super("获取bean失败", cause);
		}

	}

	@Bean
	public FactoryBean<Object> bankServiceFactoryBean() {
		// getObject 返回Proxy代理对象, ServiceLocatorInvocationHandler
		ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
		// 设置工厂接口
		serviceLocatorFactoryBean.setServiceLocatorInterface(BankServiceFactory.class);
		// 获取bean抛出的异常, 自定义
		//serviceLocatorFactoryBean.setServiceLocatorExceptionClass(IllegalArgumentException.class);
		serviceLocatorFactoryBean.setServiceLocatorExceptionClass(GetBeanException.class);
		return serviceLocatorFactoryBean;
	}

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ServiceLocatorFactoryBeanTest.class);
		BankServiceFactory f = ac.getBean(BankServiceFactory.class);
		// ServiceLocatorInvocationHandler 调用invoke方法, 从BeanFactory中根据beanName获取
		System.out.println(f.getBankService(BankType.Z_S).pay());
		System.out.println(f.getBankService(BankType.G_S).pay());

		// 获取一个不存在的实现类
		f.getBankService("hello").pay();
	}

}
