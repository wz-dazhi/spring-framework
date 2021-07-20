package com.springframework.test.xml.beanpostprocessor;

import com.springframework.test.xml.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.beanpostprocessor
 * @className: UserInstantiationAwareBeanPostProcessor
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class UserInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		// 使用InstantiationAwareBeanPostProcessor 的方式进行实例化
		if (beanClass == User.class && "user".equals(beanName)) {
			return new User("UserInstantiationAwareBeanPostProcessor");
		}
		return null;
	}
}
