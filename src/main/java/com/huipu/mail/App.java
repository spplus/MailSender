package com.huipu.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
   	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("spplus", "This is text content");
        
        System.out.println( "send email ok!" );
    }
}
