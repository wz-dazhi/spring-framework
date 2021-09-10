package com.springframework.test.xml.aop.cglib;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

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

//	@Pointcut("execution( * com.springframework.test.xml.aop.cglib.UserService.*(..))")
//	private void pointcut() {
//	}

//	@Before("pointcut()")
	public void before(JoinPoint jp) {
		MethodInvocationProceedingJoinPoint mi = (MethodInvocationProceedingJoinPoint) jp;
		final Object[] args = mi.getArgs();
		final Signature signature = mi.getSignature();
		final Object target = mi.getTarget();
		final Object aThis = mi.getThis();
		// 在before中不用手动调用mi.proceed(), 手动调用会打乱执行链路顺序, 因为在调用当前方法后, aop执行链路中会自动调用
//			mi.proceed();
		System.out.println("--------before---------------mi: " + mi);
	}

//	@After("pointcut()")
	public void after(JoinPoint jp) {
		System.out.println("--------after---------------jp: " + jp);
	}

//	@AfterReturning("pointcut()")
	public void afterReturning(JoinPoint jp, Object resultObj) {
		final Signature signature = jp.getSignature();
		System.out.println("--------afterReturning---------------jp: " + jp + ", resultObj: " + resultObj);
	}

//	@AfterThrowing("pointcut()")
	public void afterThrowing(JoinPoint jp, Throwable t) {
		System.out.println("--------afterThrowing---------------jp: " + jp + ", t: " + t);
	}

//	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("--------around-----start----------pjp: " + pjp);
		MethodInvocationProceedingJoinPoint mi = (MethodInvocationProceedingJoinPoint) pjp;
		final Object[] args = mi.getArgs();
		final Signature signature = mi.getSignature();
		final Object target = mi.getTarget();
		final Object aThis = mi.getThis();
		final Object result = mi.proceed();
		System.out.println("--------around-----end----------pjp: " + pjp);
		return result;
	}

}
