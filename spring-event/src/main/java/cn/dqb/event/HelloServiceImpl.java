package cn.dqb.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    private ApplicationContext applicationContext;

    @EventListener(classes = ContextRefreshedEvent.class)
    public void applicationContextEvent(ContextRefreshedEvent event) {
        applicationContext = event.getApplicationContext();
        System.out.println("xxxxx");
    }

    @Override
    public void hello1(){
        System.out.println("hello1");
    }
    public void hello2(){
        System.out.println("hello2");
    }
}