package cn.dqb.springaop.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

import cn.dqb.springaop.service.impl.GoodServiceImpl;

public class CglibTest {
    public static void main(String[] args) {
        // 获取CGLIB生成的字节码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\data");
        CglibProxy cglibProxy = new CglibProxy();
        GoodServiceImpl goodService = cglibProxy.newProxyInstance(GoodServiceImpl.class);
        goodService.listGood();
    }
}