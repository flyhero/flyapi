package com.flyhero.flyapi.activemq.listener;

import java.util.function.Consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyhero.flyapi.activemq.consumer.ConsumerService;


public class QueueMessageListener implements MessageListener {

	@Autowired
    private ConsumerService consumerService;
    //当收到消息后，自动调用该方法
    @Override
    public void onMessage(Message message) {
        
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"
                    + tm.getText());
            consumerService.receive(tm.getJMSDestination());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}