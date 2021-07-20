package com.springframework.test.xml.customeditor;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.customeditor
 * @className: AddressEditor
 * @description:
 * @author: zhi
 * @date: 2021/7/19
 * @version: 1.0
 */
public class AddressEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (!StringUtils.isEmpty(text)) {
			final String[] s = text.split(",");
			final Address addr = new Address();
			addr.setProvince(s[0]);
			addr.setCity(s[1]);
			addr.setCounty(s[2]);
			setValue(addr);
		}
	}
}
