package cn.dqb.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import cn.dqb.mybatis.entity.Account;
import cn.dqb.mybatis.entity.User;
import cn.dqb.mybatis.dao.UserMapper;


/**
 * @author baes
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //@Autowired
    private AccountService accountService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public boolean insertUser(User user) {
        TransactionTemplate transactionTemplate1 = new TransactionTemplate(transactionManager);
        transactionTemplate1.setName("11111");
        transactionTemplate1.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        System.out.println(transactionTemplate1.getName());
        return transactionTemplate1.execute((status) -> {
            int i = userMapper.insertUser(user);
            Account account = new Account();
            account.setUserId(user.getId());
            account.setCount(1000);
            //accountService.insertAccount(account);
            System.out.println(transactionTemplate1.getName());
            return i > 0;
        });
    }

    public void testTranscation() {
        User user = new User();
        user.setName("faaa");
        user.setPassword("mmmmm");
        userMapper.insertUser(user);
        int j = 1 / 0;
        Account account = new Account();
        account.setCount(3223);
        account.setUserId(3232);
       // accountService.insertAccount(account);
    }

    public boolean insertUser1(User user) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return transactionTemplate.execute((status) -> {
            int i = userMapper.insertUser(user);
            Account account = new Account();
            account.setUserId(user.getId());
            account.setCount(1000);
            //accountService.insertAccount1(account);
            System.out.println(transactionTemplate.getName());
            return i > 0;
        });
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean insertUser2() {
        User user = new User();
        user.setName("faaa");
        user.setPassword("mmmmm");
        userMapper.insertUser(user);
        int j = 1 / 0;
        return true;
    }

}
