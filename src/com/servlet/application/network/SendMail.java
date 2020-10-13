package com.servlet.application.network;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendMail {

	public static void send(String to, String subject, 
            String msg, final String emailFrom,final String password)
{ 
//create an instance of Properties Class   
Properties props = new Properties();


props.put("mail.smtp.host", "smtp.gmail.com");

props.put("mail.smtp.port", "587");		
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");




Session session = Session.getInstance(props,new javax.mail.Authenticator()
{
protected PasswordAuthentication getPasswordAuthentication()
{
       return new PasswordAuthentication(emailFrom,password); 
       
}
});

try {

  /*  Create an instance of MimeMessage, 
      it accept MIME types and headers 
  */

	
	
MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress(emailFrom));
message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
message.setSubject(subject);
message.setText(msg);

MailSSLSocketFactory sf = new MailSSLSocketFactory();
sf.setTrustAllHosts(true);
props.put("mail.smtp.ssl.socketFactory", sf);	

/* Transport class is used to deliver the message to the recipients */

Transport.send(message);
}
catch(Exception e) {
e.printStackTrace();
}
}  

}
