package com.springframework.test.xml.annotation;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.annotation
 * @className: ZhiBeanPostProcessor
 * @description:
 * @author: zhi
 * @date: 2021/7/21
 * @version: 1.0
 */
@ComponentZhi
public class ZhiAnnotationBeanPostProcessor extends AutowiredAnnotationBeanPostProcessor {

	public ZhiAnnotationBeanPostProcessor() {
		this.setAutowiredAnnotationType(Zhi.class);
	}
}
