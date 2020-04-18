package cn.dqb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dqb.dao.UserMapper;
import cn.dqb.entity.User;
import cn.dqb.service.UserService;

/**
 * @author baes
 * @date 2018/8/16 11:43
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> listUser() {
		return userMapper.listUser();
	}
	
	@Override
	public String getUsername() {
		System.out.println("getUsername方法被调用了");
		return "dqb";
	}
}
