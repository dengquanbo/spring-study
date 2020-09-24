package cn.dqb.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.dqb.mybatis.entity.User;

/**
 * @author baes
 * @date 2018/10/17 17:02
 */
@Mapper
public interface UserMapper {
	int insertUser(User user);
}
