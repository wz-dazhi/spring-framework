package com.springframework.test.xml.aop;

/**
 * @projectName: spring
 * @package: com.springframework.test.xml.aop
 * @className: LogAspect
 * @description:
 * @author: zhi
 * @date: 2021/7/27
 * @version: 1.0
 */
//@Component
//@Aspect
//@EnableAspectJAutoProxy
public class LogAspect {

//	@Pointcut("execution( * com.springframework.test.xml.aop.UserService.*(..))")
//	private void pointcut() {
//	}

//	@Before("pointcut()")
	public void before() {
		System.out.println("--------before---------------");
	}

//	@After("pointcut()")
	public void after() {
		System.out.println("--------after---------------");
	}

//	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("--------afterReturning---------------");
	}

//	@AfterThrowing("pointcut()")
	public void afterThrowing() {
		System.out.println("--------afterThrowing---------------");
	}

//	@Around("pointcut()")
	public void around() {
		System.out.println("--------around---------------");
	}

}
