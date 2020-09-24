package cn.dqb.activemq;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerListener2 implements MessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerListener2.class);

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    private AtomicInteger i = new AtomicInteger(0);

    @Override
    public void onMessage(Message message) {
        final TextMessage msg = (TextMessage) message;
        String text = null;
        try {
            text = msg.getText();
        } catch (JMSException e) {
            LOG.error("Message.getText() is error", e);
        }
        if (StringUtils.isBlank(text)) {
            return;
        }

//        if (i.compareAndSet(0, 1)) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        if (atomicInteger.get()==10){
//            try {
//                Thread.sleep(50000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //System.out.println("ThreadName = " + Thread.currentThread().getName() + "，接收到消息 = " + text + "，已处理 = " +
        // atomicInteger.getAndIncrement());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOG.info("ThreadName = {}，接收到消息 = {}，已处理 = {}", Thread.currentThread().getName(), text,
                atomicInteger.getAndIncrement());
    }
}
