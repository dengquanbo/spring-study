package cn.dqb.jdk;

import java.util.List;

/**
 * @date 2019/9/23 22:39
 */
public interface UserService {

    List<String> listUser();

    String getUserById(Long id);
}

interface UserService1 {

    String getUsernameById(long id);
}