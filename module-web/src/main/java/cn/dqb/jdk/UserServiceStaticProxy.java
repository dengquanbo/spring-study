package cn.dqb.jdk;

import java.util.List;

/**
 * @date 2019/9/26 22:51
 */
public class UserServiceStaticProxy implements UserService {

    private UserService userService;


    public UserServiceStaticProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<String> listUser() {
        long start = System.currentTimeMillis();
        List<String> users = userService.listUser();
        long cost = System.currentTimeMillis() - start;
        // 记录时间
        System.out.println(String.format("方法:%s,耗时:%s", "listUser", cost));
        return users;
    }

    @Override
    public String getUserById(Long id) {
        long start = System.currentTimeMillis();
        String user = userService.getUserById(id);
        long cost = System.currentTimeMillis() - start;
        // 记录时间
        System.out.println(String.format("方法:%s,耗时:%s", "getUserById", cost));
        return user;
    }
}
