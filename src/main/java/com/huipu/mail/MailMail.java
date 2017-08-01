package com.huipu.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailMail
{
	private JavaMailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String dear, String content) {
	
		MimeMessage message = mailSender.createMimeMessage();
		
		try{
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setFrom("yleesun@163.com");
			helper.setTo("yleesun@qq.com");
			helper.setSubject(simpleMailMessage.getSubject());
			helper.setText(String.format(
					simpleMailMessage.getText(), dear, content));
			
			FileSystemResource file = new FileSystemResource("C:\\pic/kb.jpg");
			
			helper.addAttachment(file.getFilename(), file);
			
			
		}catch (MessagingException e) {
			throw new MailParseException(e);
		}
		mailSender.send(message);
		
		
	}
	
	
}
