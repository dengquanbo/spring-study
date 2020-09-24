package cn.dqb.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Local {
    public static void main(String[] args) throws JMSException {
        //1、创建工厂连接对象，需要制定ip和端口号
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //2、使用连接工厂创建一个连接对象
        Connection connection = connectionFactory.createConnection();
        //3、开启连接
        connection.start();
        //4、使用连接对象创建会话（session）对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、使用会话对象创建目标对象，包含queue和topic（一对一和一对多）
        Queue queue = session.createQueue("test-queue");
        //使用session创建到达queue的consumer
        MessageConsumer consumer = session.createConsumer(queue);
        MessageConsumer consumer1 = session.createConsumer(session.createQueue("test-queue1"));

        //((ActiveMQSession)session).add

        session.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println(textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        //为consumer添加消息处理方法---异步等待服务器推
//        consumer.setMessageListener((message) -> {
//            TextMessage textMessage = (TextMessage) message;
//            try {
//                System.out.println(textMessage.getText());
//            } catch (JMSException e) {
//                e.printStackTrace();
//            }
//        });
//        Message msg = consumer.receive();//同步，消费者主动拉
//        session.close();
//        connection.close();
    }
}
