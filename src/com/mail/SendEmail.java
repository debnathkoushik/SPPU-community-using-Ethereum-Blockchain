package com.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public void RegistrationMail(String to)
	{

	String subject;
		String addtext;
		addtext="Register Succesfully";
		  subject="Welcome";
		  
		  //Get the session object  
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
		   return new PasswordAuthentication("systemproject64@gmail.com","Systemproject64@");//change accordingly  
		   }  
		  });  
		   
		  //compose message  
		  try {  
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress());//change accordingly  
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		   message.setSubject(subject);  
		   //message.setText(addtext); 
		   
		     
		   message.setText(addtext);
		   //send message  
		   Transport.send(message);  
		  
		   System.out.println("message sent successfully");  
		   

		  }
		  catch (MessagingException e) 
		  {
                 e.printStackTrace();
		}
	
		   
	}
	
}
