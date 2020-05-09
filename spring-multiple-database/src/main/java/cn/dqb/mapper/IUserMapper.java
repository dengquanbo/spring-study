package cn.dqb.mapper;

import java.util.List;

import cn.dqb.entity.User;

/**
 * @author dqb
 */
public interface IUserMapper {
    List<User> listUser();

    int addUser(User user);
}
