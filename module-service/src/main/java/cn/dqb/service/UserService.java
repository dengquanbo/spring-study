package cn.dqb.service;

import java.util.List;

import cn.dqb.entity.User;

/**
 * @author baes
 * @date 2018/8/16 11:43
 *
 */
public interface UserService {

	List<User> listUser();
	
	String getUsername();
}
