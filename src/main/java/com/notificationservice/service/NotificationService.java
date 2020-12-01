package com.notificationservice.service;

import java.util.Map;

public interface NotificationService {
	String notifyByMail(Map<String,Object> requestData);
}
