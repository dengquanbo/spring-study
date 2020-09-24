package cn.dqb.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import cn.dqb.mybatis.test.E;

@SpringBootApplication
public class TransactionDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TransactionDemoApplication.class, args);
//        A a = context.getBean(A.class);
//        B b = context.getBean(B.class);
//        System.out.println(a);
//        System.out.println(b);

        E b = context.getBean(E.class);
        b.say();
    }
}
