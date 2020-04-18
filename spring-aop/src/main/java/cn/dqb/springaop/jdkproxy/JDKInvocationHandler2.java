package cn.dqb.springaop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.dqb.springaop.service.IUserService;
import cn.dqb.springaop.service.impl.UserServiceImpl;

/**
 * 动态代理类对应的调用处理程序类
 *
 * @author dengquanbo
 */
public class JDKInvocationHandler2<T> implements InvocationHandler {

    /**
     * 目标对象
     */
    private T target;

    public JDKInvocationHandler2(T target) {
        this.target = target;
    }

    /**
     * 2.创建代理对象
     */
    public T createProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 实现 invoke 方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        // 实际调用的方法，利用反射机制将请求分派给委托类处理
        Object result = method.invoke(target, args);
        long cost = System.currentTimeMillis() - start;
        // 记录时间
        System.out.println(String.format("方法:%s,耗时:%s", method.getName(), cost));
        return result;
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        IUserService goodService = new UserServiceImpl();
        // 获取代理对象
        JDKInvocationHandler<IUserService> invocationHandler = new JDKInvocationHandler<>(goodService);
        IUserService proxy = invocationHandler.createProxy();
        proxy.getUsername();
    }
}