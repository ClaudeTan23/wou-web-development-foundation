package community.portal.Service;

import java.util.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

import community.portal.EmailHtml.EmailVerifyTemplate;

@Service
public class EmailRegistration 
{
    @Value("${email.smtp.server}")
    private String SmtpServer;

    @Value("${email.user}")
    private String userEmail;

    @Value("${email.smtp.username}")
    private String username;

    @Value("${email.smtp.password}")
    private String password;

    @Value("${email.smtp.auth}")
    private String auth;

    @Value("${email.smtp.port}")
    private int port;

    @Value("${email.protocol}")
    private String protocol;

    @Value("${server.ip}")
    private String ip;

    @Autowired
    private EmailVerifyTemplate html;

    public Boolean Run(String uid, String username, String email) 
    {
        try {
            String verifyLink = "http://" + ip + "/verify?u=" + uid + "&n=" + username;

            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost(this.SmtpServer);
            mailSender.setPort(this.port);

            mailSender.setUsername(this.username);
            mailSender.setPassword(this.password);

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", this.protocol);
            props.put("mail.smtp.auth", this.auth);
            props.put("mail.smtp.starttls.enable", "true");

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper msg = new MimeMessageHelper(message, true);
            msg.setFrom(this.userEmail);
            msg.setTo(email);
            msg.setSubject("Verify Email to complete registration");
            msg.setText(this.html.Run(verifyLink, email), this.html.Run(verifyLink, email));

            mailSender.send(message);

            return true;
            
        } catch (Exception e) {

            System.out.println(e.getStackTrace());
            return false;
        }
       
    }
}
