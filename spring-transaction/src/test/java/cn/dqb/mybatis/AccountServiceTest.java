package cn.dqb.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.dqb.mybatis.entity.Account;
import cn.dqb.mybatis.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void insertAccount() {
        Account account = new Account();
        account.setCount(1);
        account.setUserId(10);
        accountService.insertAccount(account);
    }
}
