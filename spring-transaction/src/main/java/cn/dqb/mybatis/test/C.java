package cn.dqb.mybatis.test;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class C {

    private D d;

    public C(@Autowired D d) {
        this.d = d;
    }
}
