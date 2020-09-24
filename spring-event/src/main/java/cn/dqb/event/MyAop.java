package cn.dqb.event;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {
    @Pointcut("execution(* cn.dqb.event.HelloServiceImpl.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after");
    }
}
