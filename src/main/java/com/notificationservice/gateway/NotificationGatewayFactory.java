package com.notificationservice.gateway;

import org.springframework.util.StringUtils;

public class NotificationGatewayFactory extends NotificationGatewayCreator {

	@Override
	public NotificationGatewayService getGatewayInstance(String ntsType) {
		if(!StringUtils.hasText(ntsType)) {
			return null;
		}
		switch(ntsType) {
		case "MAIL":
			return new AwsMailServiceImpl();
		default :
			return null;
		}
	}

}
