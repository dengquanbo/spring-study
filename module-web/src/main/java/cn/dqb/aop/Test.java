package cn.dqb.aop;

import cn.dqb.service.UserService;
import cn.dqb.service.impl.UserServiceImpl;

/**
 * @author deng.qb
 * @date 2018/12/14 16:41
 * @since 1.0
 */
public class Test {
	public static void main(String[] args) {
		UserService service = new UserServiceImpl();
		service.getUsername();
	}

	public interface UserService3 {

		String getUsernameById(long id);
	}
}
