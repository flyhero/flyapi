package com.flyhero.flyapi.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.flyhero.flyapi.activemq.converter.ObjectConverter;
import com.flyhero.flyapi.entity.User;
public class TopicMessageListener implements MessageListener{

	@Autowired
	private ObjectConverter jmsMessageConverter;
	@Override
	public void onMessage(Message message) {
//		TextMessage tm = (TextMessage) message;
		try {
			User user=(User) jmsMessageConverter.fromMessage(message);
			System.out.println("TopicMessageListener \t" + user.getUserName());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
