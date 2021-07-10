package com.springframework.test.tag.handler;

import com.springframework.test.tag.parse.DazhiBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @projectName: spring
 * @package: com.springframework.test.tag.handler
 * @className: DazhiNamespaceHandler
 * @description:
 * @author: zhi
 * @date: 2021/7/6
 * @version: 1.0
 */
public class DazhiNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("da-zhi", new DazhiBeanDefinitionParser());
	}

}
