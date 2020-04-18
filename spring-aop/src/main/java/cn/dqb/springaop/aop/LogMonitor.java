package cn.dqb.springaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

/**
 * @author dengquanbo
 * @date 2019/4/28 17:18
 */
@Aspect
@Component
public class LogMonitor {
    /**
     * 定义切点
     */
    @Pointcut("execution(* cn.dqb.springaop.service.*.*(..))")
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
