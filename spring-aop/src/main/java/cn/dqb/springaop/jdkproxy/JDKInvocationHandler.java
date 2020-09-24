package cn.dqb.springaop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类对应的调用处理程序类
 *
 * @author dengquanbo
 */
public class JDKInvocationHandler<T> implements InvocationHandler {
    /**
     * 目标对象
     */
    private T target;

    public JDKInvocationHandler(T target) {
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
     *
     * @param proxy  调用方法的代理实例对象
     * @param method 指代具体被代理的方法
     * @param args   包含传入代理实例上方法调用的参数，如果接口方法不使用参数，则为 null
     * @return 从代理实例的方法调用返回的值
     * @throws Throwable 从代理实例上的方法调用抛出的异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      //  long start = System.currentTimeMillis();
        // 实际调用的方法，利用反射机制将请求分派给委托类处理
        Object result = method.invoke(target, args);
        // 记录时间
      //  System.out.println(String.format("方法:%s,耗时:%s", method.getName(), System.currentTimeMillis() - start));
        return result;
    }
}