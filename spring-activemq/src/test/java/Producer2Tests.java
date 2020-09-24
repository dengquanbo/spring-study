import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:spring-config.xml"})
//@WebAppConfiguration
public class Producer2Tests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Autowired
    private JmsTemplate jmsTemplate;

    // @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        session = new MockHttpSession();
    }

    @Test
    public void sendMessage() throws Exception {
        jmsTemplate.send("cn.dqb.test", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("1");
            }
        });
    }

    @Test
    public void producer() throws JMSException, InterruptedException {
        String brokerUrl = "tcp://localhost:61616";
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
        Connection connection = factory.createConnection();
        //ActiveMQFactory.createConnection(brokerUrl);
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue1 = session.createQueue("cn.dqb.test1");
        Destination queue2 = session.createQueue("cn.dqb.test2");
        Destination queue3 = session.createQueue("cn.dqb.test4");


        MessageProducer producer1 = session.createProducer(queue1);

        // 持久化消息
        producer1.setDeliveryMode(DeliveryMode.PERSISTENT);


        MessageProducer producer2 = session.createProducer(queue2);
        // 持久化消息
        producer2.setDeliveryMode(DeliveryMode.PERSISTENT);

        MessageProducer producer3 = session.createProducer(queue3);
        // 持久化消息
        producer3.setDeliveryMode(DeliveryMode.PERSISTENT);
        producer3.send(session.createTextMessage("Hello,queue3!!"));

        for (; ; ) {
            producer2.send(session.createTextMessage("Hello,queue2!!"));
            Thread.sleep(1000);
        }
    }

}