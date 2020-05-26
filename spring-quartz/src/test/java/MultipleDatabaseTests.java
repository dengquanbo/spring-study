import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dqb.entity.Good;
import cn.dqb.entity.User;
import cn.dqb.service.IGoodService;
import cn.dqb.service.IUserService;

/**
 * @author dqb
 * @date 2018/8/16 15:45
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml"})
public class MultipleDatabaseTests {
    @Autowired
    private IGoodService goodService;

    @Autowired
    private IUserService userService;

    @Test
    public void testListGood() {
        System.out.println(goodService.listGood());
    }

    @Test
    public void testListUser() {
        System.out.println(userService.listUser());
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("li si");
        userService.addUser(user);
    }

    @Test
    public void addGood() {
        Good good = new Good();
        good.setName("apple");
        goodService.addGood(good);
    }

    @Test
    public void addGood1() {
        Good good = new Good();
        good.setName("apple");
        goodService.addGood(good, false);
    }
}
