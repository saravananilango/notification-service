package com.notificationservice.gateway;


public abstract class NotificationGatewayCreator {
	public abstract NotificationGatewayService getGatewayInstance(String ntsType);
}
