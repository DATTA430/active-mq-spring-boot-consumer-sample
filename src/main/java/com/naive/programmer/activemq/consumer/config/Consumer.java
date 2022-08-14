package com.naive.programmer.activemq.consumer.config;

import java.util.logging.Logger;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.naive.programmer.activemq.model.User;
@Component
public class Consumer {

	private static final Logger logger = Logger.getLogger(Consumer.class.getName());
	@JmsListener(destination = "outbound.queue")
	public void consumerUser(User user) {
		logger.info("Received User : "+user.toString());
	}
}
