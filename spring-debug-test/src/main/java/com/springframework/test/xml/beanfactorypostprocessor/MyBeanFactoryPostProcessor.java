package com.springframework.test.xml.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.beanfactorypostprocessor
 * @className: MyBeanFactoryPostProcessor
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor --> 执行postProcessBeanFactory");
	}
}
