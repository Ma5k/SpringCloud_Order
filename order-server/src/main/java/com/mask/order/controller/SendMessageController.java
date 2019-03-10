package com.mask.order.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mask.order.dto.OrderDTO;
import com.mask.order.message.StreamClient;

@RestController
public class SendMessageController {
	
	@Autowired
	private StreamClient streamClient;
	
//	@GetMapping("/sendMessage")
//	public void process() {
//		String message = "now " + new Date();
//		streamClient.output().send(MessageBuilder.withPayload(message).build());
//	}
	
	/**
	 * 发送OrderDTO对象
	 */
	@GetMapping("/sendMessage")
	public void process() {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId("123456");
		streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
	}
}
