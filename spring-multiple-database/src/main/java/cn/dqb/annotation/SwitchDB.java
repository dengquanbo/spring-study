package cn.dqb.annotation;

import java.lang.annotation.*;

/**
 * @author dqb
 * @date 2018/8/16 15:18
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface SwitchDB {
	String value() default "";
}
