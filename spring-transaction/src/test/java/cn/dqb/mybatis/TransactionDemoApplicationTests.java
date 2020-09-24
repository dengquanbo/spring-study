package cn.dqb.mybatis;

import cn.dqb.mybatis.entity.Account;
import cn.dqb.mybatis.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.dqb.mybatis.entity.User;
import cn.dqb.mybatis.service.UserService;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionDemoApplicationTests {
	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setName("require11");
		user.setPassword("123456");
		userService.insertUser(user);
	}
	
	@Test
	public void testInsert(){
		userService.testTranscation();
	}
	
	
	@Test
	public void testInsert1(){
		accountService.setTransactionTemplate(transactionTemplate);
		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);
		Account account = new Account();
		account.setUserId(1111);
		account.setCount(20000);
		accountService.insertAccount1(account);
	}
	
	@Test
	public void testInsert3(){
//		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);
//		accountService.setTransactionTemplate(transactionTemplate);
//
//		userService.setTransactionTemplate(transactionTemplate);
//		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		User user = new User();
		user.setName("require11");
		user.setPassword("123456");
		userService.insertUser1(user);
	}
}
