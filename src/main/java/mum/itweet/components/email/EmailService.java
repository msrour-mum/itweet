package mum.itweet.components.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements IEmailService {

    @Autowired
    public JavaMailSender emailSender;


    @Value("${email.sent.from}")
    String sentFrom;

    @Override
    public void sendMail(String to, String subject, String body) {

        //SimpleMailMessage message = new SimpleMailMessage();

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(sentFrom);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(body, true);
        };
            emailSender.send(messagePreparator);

//        message.setFrom(sentFrom);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
        //emailSender.send(message);
    }

    @Override
    public void sendMail(String subject, String body, String... to) {

            MimeMessagePreparator messagePreparator = mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setFrom(sentFrom);
                messageHelper.setTo(to);
                messageHelper.setSubject(subject);
                messageHelper.setText(body, true);
            };
                emailSender.send(messagePreparator);

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//        emailSender.send(message);

    }
}
