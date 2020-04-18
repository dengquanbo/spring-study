import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dqb.service.GoodService;
import cn.dqb.service.UserService;

/**
 * @author baes
 * @date 2018/8/16 15:45
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring-config.xml"})
public class GoodTests {
	@Autowired
	private GoodService goodService;

	@Autowired
	private UserService userService;

	@Test
	public void testListGood() {
		System.out.println(goodService.listGood() + "dsffsd");
	}

	@Test
	public void testListUser() {
		System.out.println(userService.listUser() + "dsffsd");
	}

	@Test
	public void testAop() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		GoodService goodService = (GoodService) ac.getBean("goodService");
		goodService.listGood();
	}
}
