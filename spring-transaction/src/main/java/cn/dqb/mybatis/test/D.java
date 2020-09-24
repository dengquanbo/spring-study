package cn.dqb.mybatis.test;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class D {
    private C c;

    public D(@Autowired C c) {
        this.c = c;
    }
}
