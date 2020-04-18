package cn.dqb.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @date 2019/4/28 17:18
 */
@Aspect
public class LogMonitor {
	// 定义切点
	@Pointcut("execution(* cn.dqb.service.*.*(..))")
	public void pointCut() {

	}

	@After("pointCut()")
	public void after() {
		System.out.println("after");
	}

	@Before("pointCut()")
	public void before() {
		System.out.println("before");
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("METHOD : " + joinPoint.getSignature().getName() + ", COST : " + (end - start));
		return result;
	}
}
