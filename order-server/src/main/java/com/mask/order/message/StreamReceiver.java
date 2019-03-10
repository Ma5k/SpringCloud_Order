package com.mask.order.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.mask.order.dto.OrderDTO;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {
	
	
	
//	@StreamListener(StreamClient.OUTPUT)
//	public void process(Object message) {
//		log.info("StreamReceiver:{}", message);
//	}
	
	@StreamListener(StreamClient.INPUT)
	@SendTo(StreamClient.OUTPUT)
	public Object processInput(Object message) {
		log.info("StreamReceiver:{}", message);
		return message;
	}
	
	/**
	 * 接收OrderDTO对象
	 * @param message
	 */
	@StreamListener(StreamClient.OUTPUT)
	public void processOutput(OrderDTO message) {
		log.info("Received:{}", message);
	}
}
