package com.jh.command_service.service;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.jh.command_service.configuration.RabbitMQTopicConfig;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@RequiredArgsConstructor
public class RabbitMqServiceImpl implements BrokerService{

	private final ObjectMapper objectMapper;
	
	private final RabbitTemplate rabbitTemplate;
	
	private RabbitMQTopicConfig rabbitMQTopicConfig;
	
	@Override
	public void send(String type, Object data) {
		String routingKey = type +".#";
		
		try {
			String jsonData = objectMapper.writeValueAsString(data);
			rabbitTemplate.convertAndSend(rabbitMQTopicConfig.exchangeName, routingKey, jsonData, message -> {
				message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
				return message;
			});
		}
		catch (Exception e) {
			throw new RuntimeException("Erro ao enviar mensagem: " + e.getMessage());
		}
		
	}

}
