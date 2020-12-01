package com.notificationservice.gateway;

import java.util.Map;

public interface NotificationGatewayService {
	String send(Map<String,Object> requestData);
}
