package cn.dqb.jdk;

/**
 * @date 2019/9/26 22:53
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        // 目标对象
        UserService userService = new UserServiceImpl();

        // 创建代理对象
        UserServiceStaticProxy proxy = new UserServiceStaticProxy(userService);

        // 实际使用代理对象，调用方法
        proxy.listUser();

        proxy.getUserById(1L);

    }
}
