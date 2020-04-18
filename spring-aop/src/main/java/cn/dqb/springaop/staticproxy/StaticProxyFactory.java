package cn.dqb.springaop.staticproxy;

import cn.dqb.springaop.service.IGoodService;
import cn.dqb.springaop.service.impl.GoodServiceImpl;

/**
 * 静态代理类工厂
 */
public class StaticProxyFactory {
    public static IGoodService getGoodServiceInstance() {
        return new GoodServiceStaticProxy(new GoodServiceImpl());
    }
}
