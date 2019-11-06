package com.acorp.adap.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;

import org.openqa.selenium.WebDriver;

import com.acorp.adap.util.BundleReader;

public interface MailSender {
	// sendMail('c:\\xyz\\abcd.jpg')
	// File to Be Attach Pass as an argument
public static void sendMail(String filePath) {
	WebDriver driver;
   final String username = "nmehta2807@gmail.com";
   final String password = "nmehta@1234";
   final String EmailTo = "nmehta2807@gmail.com";
    // Step - 0 Config Mail Server Details
    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    
    
    // Step-1 Create Session (Authenticate Userid, Password of Gmail)
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    // Step-2 From, To, Subject , Message
    try {
    	// Step 2.1 Create Message With From / To
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
       // message.setRecipients(arg0, arg1);
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(EmailTo));
        message.setSubject("Testing ScreenShot Mail");
        //message.setText("PFA");
        message.setText(SuccessTemplate.getMessage());
        
        
        // Step 2.2 Attachment Code
        MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        messageBodyPart = new MimeBodyPart();
        //String file = "path of file to be attached";
        String fileName = "brainmentors";  // attachment name
        FileDataSource source = new FileDataSource(filePath);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        System.out.println("Sending");

        
        // Step-3 Send Mail 
        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
}
}
