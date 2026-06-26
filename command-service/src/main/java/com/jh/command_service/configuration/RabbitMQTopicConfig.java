package com.jh.command_service.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {
	
	public final String exchangeName = "agendamentoExchange";
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchangeName);
	}
	
	@Bean
	public Queue clienteQueue() {
		return new Queue("clienteQueue", true);
	}
	
	@Bean
	Binding bindingCliente(Queue clienteQueue, TopicExchange exchange) {
		return BindingBuilder.bind(clienteQueue).to(exchange).with("cliente.#");
	}
}
