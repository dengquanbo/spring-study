package cn.dqb.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.dqb.mybatis.dao.impl.AccountMapperImpl;
import cn.dqb.mybatis.entity.Account;


/**
 * @author baes
 * @date 2018/10/17 17:03
 */
@Service
public class AccountService {

    @Autowired
    @Qualifier("accountMapperImpl")
    private AccountMapperImpl accountMapper;


    @Autowired
    private PlatformTransactionManager transactionManager;


    public Account getAccount() {
        return accountMapper.getAccount(1);
    }

    // @Transactional
    public Account getAccountWithTransaction() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        return transactionTemplate.execute(new TransactionCallback<Account>() {
            @Override
            public Account doInTransaction(TransactionStatus status) {
                return accountMapper.getAccountWithTransaction(1);
            }
        });
    }
}
