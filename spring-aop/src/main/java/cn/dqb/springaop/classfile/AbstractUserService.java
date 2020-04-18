package cn.dqb.springaop.classfile;

/**
 * @date 2019/9/29 23:33
 */
public abstract class AbstractUserService implements UserService {

    public abstract Integer getAge(Long userId);
}
