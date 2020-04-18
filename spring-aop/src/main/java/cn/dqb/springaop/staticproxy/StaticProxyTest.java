package cn.dqb.springaop.staticproxy;

import cn.dqb.springaop.service.IGoodService;

/**
 * 静态代理测试类
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        IGoodService proxy = StaticProxyFactory.getGoodServiceInstance();
        proxy.listGood();
        proxy.getGood(1L);
    }
}
