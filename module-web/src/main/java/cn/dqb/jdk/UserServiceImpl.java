package cn.dqb.jdk;


import java.util.ArrayList;
import java.util.List;

/**
 * @date 2019/9/23 22:39
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<String> listUser() {
        System.out.println("执行UserServiceImpl的listUser方法");
        return new ArrayList<>();
    }

    @Override
    public String getUserById(Long id) {
        System.out.println("执行UserServiceImpl的getUserById方法");
        return "dqb";
    }
}
