package com.springframework.test.xml.factorybean;

import org.springframework.stereotype.Service;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.factorybean
 * @className: ZSBankServiceImpl
 * @description:
 * @author: zhi
 * @date: 2023/3/1
 * @version: 1.0
 */
@Service(BankType.Z_S)
public class ZSBankServiceImpl implements BankService {

	@Override
	public String pay() {
		return "招商银行";
	}

}
