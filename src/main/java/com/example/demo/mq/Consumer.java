package com.example.demo.mq;

import java.util.Map;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 
 * 类名: Consumer <br/> 
 * 功能: TODO ADD FUNCTION. <br/> 
 * 创建时间: 2019年4月25日 上午9:13:45 <br/> 
 * 
 * @author caoti 
 * @version  
 * @since Jdk 1.8
 */
@EnableAsync
@Component
public class Consumer {
//	@Async
//	@Scheduled(cron = "0/5 * * * * ?")
	@JmsListener(destination = "activemqTest")
	public void receive(Map<String, Object> receiveMsg){
//		for(int i=0;i<10;i++){
//			Thread thread = new Thread(new Runnable() {	
//				@Override
//				public void run() {
//					receive(receiveMsg);
//				}
//			});
//			thread.start();
//		}
		test(receiveMsg);
		System.out.println("消费者1处理..."+receiveMsg.get("key"));
	}
	
	@JmsListener(destination = "activemqTest")
	public void receive2(Map<String, Object> receiveMsg){
		test(receiveMsg);
		System.out.println("消费者2处理..."+receiveMsg.get("key"));
		
	}
	
		
	
	public void test(Map<String, Object> receiveMsg){
		for(String s : receiveMsg.keySet()){
			System.out.println(receiveMsg.get(s));
		}
	}
	
}
