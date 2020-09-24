package cn.dqb.mybatis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import cn.dqb.mybatis.dao.AccountMapper;
import cn.dqb.mybatis.entity.Account;

@Component
public class AccountMapperImpl implements AccountMapper {
    private static final String NAME_SPACE = "cn.dqb.mybatis.dao.AccountMapper";
    @Resource
    private SqlSessionTemplate sqlSession;

    @Override
    public Account getAccount(int userId) {
        // 此句执行db查询
        Account result = sqlSession.selectOne(NAME_SPACE + ".getAccount", userId);
        return result;
    }

    @Override
    public Account getAccountWithTransaction(int userId) {
        // 此句执行db查询
        Account result = sqlSession.selectOne(NAME_SPACE + ".getAccount", userId);
        return result;
    }

    @Override
    public int insertAccount(Account account) {
        return 0;
    }
}
