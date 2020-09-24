package cn.dqb.mybatis.test;

import org.springframework.stereotype.Component;

@Component
public class E {
    private  E(){}

    public void say(){
        System.out.println("say");
    }
}
