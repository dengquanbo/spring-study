package cn.dqb.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import cn.dqb.annotation.SwitchDB;
import cn.dqb.common.DynamicDataSource;

/**
 * @author dqb
 * @date 2018/8/16 15:27
 * @description
 */
@Component
@Aspect
@Order(1)
public class SwitchDbAspect {

    @Before(value = "execution(* cn.dqb.service.*.*(..)) || @annotation(cn.dqb.annotation.SwitchDB)")
    public void dataSwitch(JoinPoint joinPoint) {
        Class<?> target = joinPoint.getTarget().getClass();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 默认使用接口、接口方法上的注解
        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, method);
        }
        // 实际实现类、方法优先级更高
        resolveDataSource(target, method);
    }

    private void resolveDataSource(Class<?> clazz, Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        // 默认使用类型注解
        if (clazz.isAnnotationPresent(SwitchDB.class)) {
            SwitchDB switchDB = clazz.getAnnotation(SwitchDB.class);
            if (StringUtils.isNotBlank(switchDB.value())) {
                DynamicDataSource.setDataSourceKey(switchDB.value());
            }
        }

        // 方法注解优先级最高
        try {
            Method m = clazz.getMethod(method.getName(), parameterTypes);
            if (m != null && m.isAnnotationPresent(SwitchDB.class)) {
                SwitchDB switchDB = m.getAnnotation(SwitchDB.class);
                if (StringUtils.isNotBlank(switchDB.value())) {
                    DynamicDataSource.setDataSourceKey(switchDB.value());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
