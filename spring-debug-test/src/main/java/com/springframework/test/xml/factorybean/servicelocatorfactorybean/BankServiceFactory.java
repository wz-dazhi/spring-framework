package com.springframework.test.xml.factorybean.servicelocatorfactorybean;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.factorybean
 * @className: BankServiceFactory
 * @description:
 * @author: zhi
 * @date: 2023/3/1
 * @version: 1.0
 */
public interface BankServiceFactory {

	/**
	 * 字符串获取
	 */
	//BankService getBankService(String type);

	/**
	 * 枚举获取
	 */
	BankService getBankService(BankType type);

}
