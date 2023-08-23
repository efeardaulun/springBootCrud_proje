package com.example.efe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject,String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("efeardacoder@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);

        System.out.println("mail is goneee.....");
    }

    public void sendMailWithAttachment(String toEmail, String subject, String body, String fileToAttach) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("efeardacoder@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            File attachment = new File(fileToAttach);
            mimeMessageHelper.addAttachment("deneme.pdf", attachment);
        };
        javaMailSender.send(messagePreparator);
    }

}
