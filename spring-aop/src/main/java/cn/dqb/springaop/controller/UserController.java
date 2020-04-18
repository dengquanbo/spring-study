package cn.dqb.springaop.controller;

import org.springframework.stereotype.Controller;

/**
 * @author baes
 * @date 2018/8/16 11:42
 */
@Controller
public class UserController {


    public interface UserService2 {

        String getUsernameById(long id);
    }
}

