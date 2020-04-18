package cn.dqb.springaop.aspectj;

import cn.dqb.springaop.service.IUserService;
import cn.dqb.springaop.service.impl.UserServiceImpl;

/**
 * @author dengquanbo
 */
public class AspectJTest {
    public static void main(String[] args) {
        IUserService service = new UserServiceImpl();
        service.getUsername();
    }
}
