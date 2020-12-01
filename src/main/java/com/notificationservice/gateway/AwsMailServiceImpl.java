package com.notificationservice.gateway;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class AwsMailServiceImpl implements NotificationGatewayService {
	
    @Autowired
    private Environment environment;
	
	@Override
	public String send(Map<String, Object> requestData) {//AWS handler Data
	    String fromAddress = environment.getProperty("fromAddress");
	    String fromName = environment.getProperty("fromName");
	    String smtpUserName = environment.getProperty("smtpUserName");
	    String smtpPassword = environment.getProperty("smtpPassword");
	    String smtphost = environment.getProperty("smtphost");
	    boolean enable_tls = true;
	    boolean enable_auth = true;
	    int port = Integer.parseInt(environment.getProperty("port"));//587;
	    
	    //Mail User Data
	    String to = requestData.get("email_id").toString();
	    String subjectText = requestData.containsKey("mail_subject") ? requestData.get("mail_subject").toString() : requestData.get("default_title").toString();
	    String bodyText = requestData.containsKey("mail_body") ? requestData.get("mail_body").toString() : requestData.get("default_text").toString();
	    
	    String body = String.join(
	    	    System.getProperty("line.separator"),
	    	    bodyText
	    	);

	    	java.util.Properties props = System.getProperties();
	    	props.put("mail.transport.protocol", "smtp");
	    	props.put("mail.smtp.port", port); 
	    	props.put("mail.smtp.starttls.enable", enable_tls);
	    	props.put("mail.smtp.auth", enable_auth);
 
	    	Session session = Session.getDefaultInstance(props);
	        MimeMessage msg = new MimeMessage(session);
	        try {
				msg.setFrom(new InternetAddress(fromAddress,fromName));
				 msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			     msg.setSubject(subjectText);
			     msg.setContent(body,"text/html");
			} catch (UnsupportedEncodingException | MessagingException e) {
				e.printStackTrace();
			}
	        Transport transport = null;
			try {
				transport = session.getTransport();
	            transport.connect(smtphost, smtpUserName, smtpPassword);
	            transport.sendMessage(msg, msg.getAllRecipients());
			} catch (NoSuchProviderException e) {
				e.printStackTrace();
				return "Mail sent failed"; 
			}
	        catch (Exception ex) {
	        	return "Mail sent failed"; 
	        }
	        finally
	        {
	            try {
					transport.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
	        }
			return "Success"; 
	    
	}

}
