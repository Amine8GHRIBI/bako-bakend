package com.bakomotors.backend.Controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bakomotors.backend.Model.Contact;
import com.bakomotors.backend.Model.Role;

@Controller
public class ContactController {
	
        @PostMapping(path = "/mail")
	     public ResponseEntity<?> addrole(@RequestBody Contact contact) throws IOException {

		  JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		  mailSender.setHost("smtp.gmail.com");
		  mailSender.setPort(587);
		  mailSender.setUsername("aghribi011@gmail.com");
		  mailSender.setPassword("wqipmvryipnqryql");
		 
		  Properties properties = new Properties();
		  properties.setProperty("mail.smtp.auth", "true");
		  properties.setProperty("mail.smtp.starttls.enable", "true");
		  mailSender.setJavaMailProperties(properties);
		  String from = "amine.ghribi@bakomotors.com";
		  String to = "amine.ghribi@tek-up.de";
		  String mailContent = "Sender Name : " + contact.getName() + '\n';
		  mailContent += "Sender E-mail : " + contact.getEmail() + '\n' ;
		  mailContent += "Subject :" + contact.getSubject() + '\n';
		  mailContent+= "Content : " + contact.getContent() + '\n';
		  
	      SimpleMailMessage message = new SimpleMailMessage();
		  message.setFrom(from);
		  message.setTo(to);
		  message.setSubject("PRE-ORDER BAKO");
		  message.setText(mailContent);
		  mailSender.send(message);
		  return ResponseEntity.ok().body(HttpStatus.OK);
	    }
	}
