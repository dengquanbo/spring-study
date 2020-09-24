package cn.dqb.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 发布自己的事件
        applicationContext.publishEvent(new MyAppEvent("this is my event"));

    //    HelloService helloService = applicationContext.getBean(HelloService.class);

    //    ((HelloServiceImpl)helloService).hello1();

    }
}
