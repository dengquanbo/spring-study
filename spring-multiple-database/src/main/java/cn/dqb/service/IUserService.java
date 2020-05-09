package cn.dqb.service;

import java.util.List;

import cn.dqb.annotation.SwitchDB;
import cn.dqb.common.DynamicDataSource;
import cn.dqb.entity.User;

/**
 * @author dqb
 * @date 2018/8/16 11:43
 * @description
 */
public interface IUserService {

    List<User> listUser();

    @SwitchDB(value = DynamicDataSource.dataSource2)
    boolean addUser(User user);
}
