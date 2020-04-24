package cn.dqb.springaop.cglib;

import cn.dqb.springaop.service.IGoodService;
import cn.dqb.springaop.service.impl.GoodServiceImpl;

public class CglibTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        IGoodService goodService = cglibProxy.newProxyInstance(GoodServiceImpl.class);
        goodService.listGood();
    }
}