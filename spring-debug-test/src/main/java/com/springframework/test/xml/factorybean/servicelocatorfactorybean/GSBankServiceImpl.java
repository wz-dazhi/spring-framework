package com.springframework.test.xml.factorybean;

import org.springframework.stereotype.Service;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.factorybean
 * @className: GSBankServiceImpl
 * @description:
 * @author: zhi
 * @date: 2023/3/1
 * @version: 1.0
 */
@Service(BankType.G_S)
public class GSBankServiceImpl implements BankService {

	@Override
	public String pay() {
		return "工商银行";
	}

}
