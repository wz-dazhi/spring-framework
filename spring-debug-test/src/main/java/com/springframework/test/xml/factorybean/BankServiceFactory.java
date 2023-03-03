package com.springframework.test.xml.factorybean;

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

	BankService getBankService(String type);

}
