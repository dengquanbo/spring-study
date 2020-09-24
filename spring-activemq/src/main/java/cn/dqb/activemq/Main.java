package cn.dqb.activemq;

import org.apache.activemq.ActiveMQMessageConsumer;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.FifoMessageDispatchChannel;
import org.apache.activemq.command.MessageDispatch;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.connection.CachingConnectionFactory;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.jms.Session;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
//        applicationContext.refresh();
        applicationContext.start();

//        new Thread(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            SimpleMessageListenerContainer container =
//                    (SimpleMessageListenerContainer) applicationContext.getBean("consumer2Container");
//           // container.stop();
//            System.out.println("stop" + container.isRunning());
//        }).start();


        while (true) {
            try {
                CachingConnectionFactory connectionFactory = applicationContext.getBean("cachingConnectionFactory",
                        CachingConnectionFactory.class);
                reflect(connectionFactory);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //System.in.read();

    }

    public static void reflect(Object object) {
        HashMap<Integer, LinkedList<Session>> cachedSessions =
                (HashMap<Integer, LinkedList<Session>>) ClassUtil.getFieldValueByFieldName("cachedSessions",
                        object);

        for (Map.Entry<Integer, LinkedList<Session>> entry : cachedSessions.entrySet()) {
            LinkedList<Session> sessions = entry.getValue();
            for (Session session : sessions) {

                ActiveMQSession activeMQSession = (ActiveMQSession) ClassUtil.getFieldValueByFieldName("target",
                        session);
                Object object1 = ClassUtil.getFieldValueByFieldName("h", (Proxy) session);
                ActiveMQSession activeMQSession1 = (ActiveMQSession) ClassUtil.getFieldValueByFieldName("target",
                        object1);


                CopyOnWriteArrayList<ActiveMQMessageConsumer> consumers =
                        (CopyOnWriteArrayList<ActiveMQMessageConsumer>) ClassUtil.getFieldValueByFieldName(
                                "sessionList", session);

                for (ActiveMQMessageConsumer consumer : consumers) {
                    FifoMessageDispatchChannel fifoMessageDispatchChannel =
                            (FifoMessageDispatchChannel) ClassUtil.getFieldValueByFieldName(
                                    "unconsumedMessages", consumer);
                    LinkedList<MessageDispatch> list =
                            (LinkedList<MessageDispatch>) ClassUtil.getFieldValueByFieldName("list",
                                    fifoMessageDispatchChannel);
                    System.out.println("===================================================");
                    System.out.println(list.size());
                }


            }
        }

    }


}
