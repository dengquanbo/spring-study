package cn.dqb.activemq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main1 {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        applicationContext.start();
        System.in.read();
    }
}
