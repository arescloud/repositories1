package com.example.demo.mq;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner{
	@Autowired
	private Queue queue;
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Override
	public void run(String... arg0) throws Exception {
		for(int i=0;i<500;i++){
			Map<String, Object> map = new HashMap<>();
			map.put("key", i);
			send(map);
		}
		
	}
	
	public void send(Map<String, Object> msg){
		jmsMessagingTemplate.convertAndSend(this.queue, msg);
		System.out.println("消息已发送至队列中");
	}
	
}
