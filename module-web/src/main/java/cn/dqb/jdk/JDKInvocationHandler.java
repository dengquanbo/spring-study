package cn.dqb.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date 2019/9/23 22:40
 */
public class JDKInvocationHandler<T> implements InvocationHandler {

    private T target;

    public JDKInvocationHandler(T target) {
        this.target = target;
    }

    public T createProxy() {
        return (T) Proxy
            .newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        // 实际调用的方法
        Object result = method.invoke(target, args);
        long cost = System.currentTimeMillis() - start;
        // 记录时间
        System.out.println(String.format("方法:%s,耗时:%s", method.getName(), cost));
        return result;
    }
}
