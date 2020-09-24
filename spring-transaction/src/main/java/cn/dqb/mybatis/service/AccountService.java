package cn.dqb.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import cn.dqb.mybatis.dao.AccountMapper;
import cn.dqb.mybatis.entity.Account;

/**
 * @author baes
 * @date 2018/10/17 17:03
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean insertAccount(Account account) {
        boolean isSuccess = accountMapper.insertAccount(account) > 0;

        // int i = 1 / 0;
        userService.insertUser2();

        return isSuccess;
    }

    public boolean insertAccount1(Account account) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        return transactionTemplate.execute((status) -> {
            transactionTemplate.setName("2222");
            System.out.println(transactionTemplate.getPropagationBehavior());
            System.out.println(transactionTemplate.getName());
            int i = accountMapper.insertAccount(account);
            //int j = 1 / 0;
            return i > 0;
        }).equals(Boolean.TRUE);
    }


}
