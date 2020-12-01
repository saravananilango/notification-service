package com.notificationservice.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notificationservice.service.NotificationService;

@RestController
@RequestMapping(value="/notification")
public class NotificationController {
	
	private final NotificationService notificationService;
	
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@PostMapping(value="/notifyByMail", produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String notifyByMail(@RequestBody Map<String,Object> requestData) {
		return notificationService.notifyByMail(requestData);
	}
}
