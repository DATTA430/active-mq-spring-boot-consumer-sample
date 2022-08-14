package com.naive.programmer.activemq.consumer.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@EnableJms
@Configuration
public class ConsumerConfig {

	//@Value("${spring.activemq.broker-url}")
	private String brokerUrl = "tcp://localhost:61616";

	@Bean
	public ActiveMQConnectionFactory consumerConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(brokerUrl);
		activeMQConnectionFactory.setTrustedPackages(Arrays.asList("java.lang","com.naive.programmer.activemq.model"));
		return activeMQConnectionFactory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
		return defaultJmsListenerContainerFactory;
	}

}
