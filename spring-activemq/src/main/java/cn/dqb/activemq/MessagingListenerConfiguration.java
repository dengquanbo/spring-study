package cn.dqb.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;

//@Configuration
//@EnableJms
@Order(300)
public class MessagingListenerConfiguration {

    @Autowired
    @Qualifier("cachingConnectionFactory")
    private CachingConnectionFactory connectionFactory;
//
//    @Bean(name = "defaultContainer")
//    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setConcurrency("5-10");
//        return factory;
//    }
//
    @Bean(name = "jmsListenerContainerFactory")
    public SimpleJmsListenerContainerFactory simpleJmsListenerContainerFactory() {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

}