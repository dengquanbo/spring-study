package cn.dqb.springaop.jdkproxy;

import cn.dqb.springaop.service.impl.GoodServiceImpl;
import cn.dqb.springaop.service.IGoodService;

/**
 * JDK 动态代理测试类
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        IGoodService goodService = new GoodServiceImpl();
        // 获取代理对象
        JDKInvocationHandler<IGoodService> invocationHandler = new JDKInvocationHandler<>(goodService);
        IGoodService proxy = invocationHandler.createProxy();
        proxy.listGood();
        proxy.getGood(1L);

    }
}
