package cn.dqb.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 显然此处，它会收到两个时间，分别进行处理
@Component
public class MyAllEventListener {

    //value必须给值,但可以不用是ApplicationEvent的子类  任意事件都ok
    // 也可以给一个入参，代表事件的Event
    @EventListener(value = {ContextRefreshedEvent.class, MyAppEvent.class}
            // confition的使用，若同一个事件进行区分同步异步 等等条件的可以使用此confition 支持spel表达式  非常强大
            /*,condition = "#event.isAsync == false"*/)
    public void handle(Object o) {
        System.out.println(o);
        System.out.println("事件来了~");
    }
}
