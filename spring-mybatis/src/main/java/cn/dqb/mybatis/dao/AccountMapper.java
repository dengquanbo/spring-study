package cn.dqb.mybatis.dao;


import cn.dqb.mybatis.entity.Account;

/**
 * @author baes
 * @date 2018/10/17 17:02
 */
public interface AccountMapper {
    Account getAccount(int userId);

    Account getAccountWithTransaction(int userId);

    int insertAccount(Account account);
}
