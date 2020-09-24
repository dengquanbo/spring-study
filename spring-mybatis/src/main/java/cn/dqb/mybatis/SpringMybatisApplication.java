package cn.dqb.mybatis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dqb.mybatis.entity.User;
import cn.dqb.mybatis.service.AccountService;
import cn.dqb.mybatis.service.UserService;

public class SpringMybatisApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        applicationContext.start();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user = new User();
        user.setName("1");
        user.setPassword("2");
     //   userService.insertUser(user);


        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        //accountService.getAccount();

        accountService.getAccountWithTransaction();
    }
}
