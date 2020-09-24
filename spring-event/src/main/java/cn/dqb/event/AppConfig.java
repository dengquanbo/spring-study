package cn.dqb.event;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "cn.dqb.event")
@EnableAspectJAutoProxy
public class AppConfig {

}