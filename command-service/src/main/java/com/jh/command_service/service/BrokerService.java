package com.jh.command_service.service;

public interface BrokerService {
	public void send(String type, Object data);
}
