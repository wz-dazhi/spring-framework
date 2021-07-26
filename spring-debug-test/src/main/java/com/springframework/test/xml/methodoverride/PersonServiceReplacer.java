package com.springframework.test.xml.methodoverride;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.methodoverride
 * @className: PersonServiceReplacer
 * @description:
 * @author: zhi
 * @date: 2021/7/26
 * @version: 1.0
 */
public class PersonServiceReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("hello replacer. args: " + args[0] + ", argsLength: " + args.length);
		System.out.println(obj + "--" + method);
		// return null;
		return args[0] + " is reimplement.";
	}
}
