package cn.dqb.springaop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public <T> T newProxyInstance(Class<T> tClass) {
        // 设置产生的代理对象的父类
        enhancer.setSuperclass(tClass);

        // 设置CallBack接口的实例
        enhancer.setCallback(this);

        // 使用默认无参数的构造函数创建目标对象
        return (T) enhancer.create();
    }

    /**
     * @param o           代理类对象实例
     * @param method      被代理的原始方法
     * @param args        方法参数
     * @param methodProxy 方法代理，fastClass机制相关
     * @return cglib生成用来代替Method对象的一个对象，使用MethodProxy比调用JDK自身的Method直接执行方法效率会有提升
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
       // long start = System.currentTimeMillis();
       // System.out.println("before " + methodProxy.getSuperName());
        //System.out.println(method.getName());

        Object value = methodProxy.invokeSuper(o, args);

        // 使用这种方式会发生死循环，因为方法会被拦截
        //  Object value = methodProxy.invoke(o, args);

        // 使用这种方式会发生死循环，因为方法会被拦截
        //Object value = method.invoke(o, args);
       // System.out.println("after " + methodProxy.getSuperName());

        // 记录时间
       // System.out.println(String.format("方法:%s,耗时:%s", method.getName(), System.currentTimeMillis() - start));
        return value;
    }
}
