package com.notificationservice.service;

import java.util.Map;

import com.notificationservice.gateway.NotificationGatewayCreator;
import com.notificationservice.gateway.NotificationGatewayService;

public class NotificationServiceImpl implements NotificationService {
	
	private final NotificationGatewayCreator notificationGatewayCreator;
	
	public NotificationServiceImpl(NotificationGatewayCreator notificationGatewayCreator) {
		this.notificationGatewayCreator = notificationGatewayCreator;
	}

	public String notifyByMail(Map<String, Object> requestData) {
		NotificationGatewayService emailGateway = notificationGatewayCreator.getGatewayInstance("MAIL");
		emailGateway.send(requestData);
		return null;
	}

}
