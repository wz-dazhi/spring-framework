package com.springframework.test.xml.factorybean.servicelocatorfactorybean;

/**
 * @projectName: spring-framework
 * @package: com.springframework.test.xml.factorybean
 * @className: BankType
 * @description:
 * @author: zhi
 * @date: 2023/3/1
 * @version: 1.0
 */
public enum BankType {
	ZS(BankType.Z_S, "招商"),
	GS(BankType.G_S, "工商"),

	;

	public static final String Z_S = "zhao.shang";

	public static final String G_S = "gong.shang";

	private final String type;
	private final String desc;


	BankType(String type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return this.type;
	}

}
