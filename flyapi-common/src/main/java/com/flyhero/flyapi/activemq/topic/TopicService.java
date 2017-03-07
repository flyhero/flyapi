package com.flyhero.flyapi.activemq.topic;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    
    @Resource(name="topicTemplate")
    private JmsTemplate topicTemplate;
    
    
    /**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void publish(Destination destination,final Object message){
    	topicTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return topicTemplate.getMessageConverter().toMessage(message, session);
            }
        });
    }

}