package cn.dqb.springaop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.dqb.springaop.service.IGoodService;
import cn.dqb.springaop.service.impl.GoodServiceImpl;

/**
 * 动态代理类对应的调用处理程序类
 *
 * @author dengquanbo
 */
public class JDKInvocationHandler1 implements InvocationHandler {


    /**
     * 实现 invoke 方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        // 实际调用的方法，利用反射机制将请求分派给委托类处理
        Object result = method.invoke(proxy, args);
        long cost = System.currentTimeMillis() - start;
        // 记录时间
        System.out.println(String.format("方法:%s,耗时:%s", method.getName(), cost));
        return result;
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IGoodService goodService = new GoodServiceImpl();
        // 获取代理对象
        JDKInvocationHandler1 invocationHandler = new JDKInvocationHandler1();
        IGoodService proxy = (IGoodService) Proxy.newProxyInstance(goodService.getClass().getClassLoader(),
                goodService.getClass().getInterfaces(), invocationHandler);
        proxy.listGood();
        proxy.getGood(1L);
    }
}