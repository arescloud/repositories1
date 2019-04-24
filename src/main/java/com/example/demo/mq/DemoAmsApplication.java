package com.example.demo.mq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class DemoAmsApplication {
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("activemqTest");
	}
}
