package com.mask.order.message;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqReceiverTest  {
	
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void send() {
		//第一个参数为自己命名的队列的名称
		amqpTemplate.convertAndSend("myQueue", "now " + new Date());
	}

	@Test
	public void sendOrder() {
		//第一个参数为自己命名的队列的名称
		amqpTemplate.convertAndSend("myOrder", "computer", "now " + new Date());
	}

	
}
