package com.springframework.test.xml.customeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.customeditor
 * @className: AddressEditorRegistrar
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class AddressEditorRegistrar implements PropertyEditorRegistrar {
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Address.class, new AddressEditor());
	}
}
