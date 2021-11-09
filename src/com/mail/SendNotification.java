package com.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendNotification {
	
	public void Notification(String email,String notification){
		
		
		
		 String to =email;
		  System.out.println("To:"+to);
		  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication("systemproject64@gmail.com","Systemproject64@"); 
		   }  
		  });  
		   
	
		  try {  
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress("systemproject64@gmail.com")); 
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		   message.setSubject("Notification");  
		   message.setText(notification); 
		   
		     
		   //send message  
		   Transport.send(message);  
		  
		   System.out.println("message sent successfully");  
		   
		  } catch (MessagingException e) {throw new RuntimeException(e);}  
		   
		 }  
}
