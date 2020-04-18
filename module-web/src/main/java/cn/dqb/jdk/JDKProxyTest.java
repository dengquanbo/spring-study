package cn.dqb.jdk;

/**
 * @date 2019/9/23 22:47
 */
public class JDKProxyTest {

    public static void main(String[] args) throws InterruptedException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        UserService userService = new UserServiceImpl();
        JDKInvocationHandler<UserService> invocationHandler = new JDKInvocationHandler<>(userService);
        UserService proxy = invocationHandler.createProxy();
        proxy.listUser();
        proxy.getUserById(1L);

    }
}
