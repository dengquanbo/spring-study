package cn.dqb.springaop.service.impl;

import org.springframework.stereotype.Service;

import cn.dqb.springaop.service.AbstractUserService;
import cn.dqb.springaop.service.IUserService;


/**
 * @author dengquanbo
 */
@Service
public class UserServiceImpl extends AbstractUserService implements IUserService {

    @Override
    public String getUsername() {
        System.out.println("getUsername方法被调用了");
        return "dqb";
    }

    @Override
    public void getUser(Long id) {
        System.out.println("a");
    }
}
