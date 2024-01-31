package community.portal.Service;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import community.portal.EmailHtml.ForgetPasswordTemplate;

@Service
public class ForgetPasswordEmail 
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
    private ForgetPasswordTemplate html;

    public Boolean Run(String username, String otp, String email) 
    {
        try {
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
            msg.setSubject("Password Recovery");
            msg.setText(this.html.Run(otp, username), this.html.Run(otp, username));

            mailSender.send(message);

            return true;
            
        } catch (Exception e) {

            System.out.println(e.getStackTrace());
            return false;
        }
       
    }
    
}
