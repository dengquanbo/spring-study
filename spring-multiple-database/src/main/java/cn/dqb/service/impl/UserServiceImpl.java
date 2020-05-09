package cn.dqb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.dqb.annotation.SwitchDB;
import cn.dqb.common.DynamicDataSource;
import cn.dqb.entity.User;
import cn.dqb.mapper.IUserMapper;
import cn.dqb.service.IUserService;

/**
 * @author dqb
 * @date 2018/8/16 11:43
 * @description
 */
@Service
@SwitchDB(value = DynamicDataSource.dataSource1)
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @SwitchDB(value = DynamicDataSource.dataSource1)
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user) > 0;
    }
}
