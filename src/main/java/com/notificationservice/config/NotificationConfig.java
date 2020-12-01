package com.notificationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.notificationservice.gateway.NotificationGatewayCreator;
import com.notificationservice.gateway.NotificationGatewayFactory;
import com.notificationservice.service.NotificationService;
import com.notificationservice.service.NotificationServiceImpl;

@Configuration
public class NotificationConfig {
	
	@Bean
	public NotificationGatewayCreator gatewayCreator() {
		return new NotificationGatewayFactory();
	}
	@Bean
	public NotificationService notificationService(NotificationGatewayCreator gatewayCreator){
		return new NotificationServiceImpl(gatewayCreator);
	}

}
