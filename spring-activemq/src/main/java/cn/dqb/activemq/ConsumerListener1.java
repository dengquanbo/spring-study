package cn.dqb.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

//@Component
public class ConsumerListener1 {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerListener1.class);


    //@JmsListener(destination = "cn.dqb.test", containerFactory = "defaultContainer")
    @JmsListener(destination = "cn.dqb.test", concurrency = "30-30")
    public void onMessage(Message message) {
        final TextMessage msg = (TextMessage) message;
        String text = null;
        try {
            text = msg.getText();
        } catch (JMSException e) {
            LOG.error("Message.getText() is error", e);
        }

        LOG.info("接收到消息 = {}", text);
        System.out.println("接收到消息 = " + text);
    }
}