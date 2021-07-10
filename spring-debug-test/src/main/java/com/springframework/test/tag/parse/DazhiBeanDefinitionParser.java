package com.springframework.test.tag.parse;

import com.springframework.test.tag.DazhiTag;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @projectName: spring
 * @package: com.springframework.test.tag.parse
 * @className: DazhiBeanDefinitionParser
 * @description:
 * @author: zhi
 * @date: 2021/7/6
 * @version: 1.0
 */
public class DazhiBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return DazhiTag.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		if (element.hasAttribute("name")) {
			builder.addPropertyValue("name", element.getAttribute("name"));
		}
		if (element.hasAttribute("age")) {
			builder.addPropertyValue("age", element.getAttribute("age"));
		}
		if (element.hasAttribute("email")) {
			builder.addPropertyValue("email", element.getAttribute("email"));
		}
	}
}
