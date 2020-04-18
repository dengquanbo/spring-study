package cn.dqb.springaop.classfile;

/**
 * @date 2019/9/29 23:35
 */
public class UserServiceImpl extends AbstractUserService implements UserService {

    private static final String USER_PREFIX = "prefix";

    private String USER_KEY = "1";

    @Override
    public Integer getAge(Long userId) {
        return 1;
    }

    @Override
    public String getUsername(Long id) {
        return "dqb";
    }
}
