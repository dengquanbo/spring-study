package cn.dqb.springaop.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dqb.springaop.service.IUserService;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserService userService = (IUserService) context.getBean("userServiceImpl");
        userService.getUsername();

        LogMonitor logMonitor = (LogMonitor) context.getBean("logMonitor");

    }
}
