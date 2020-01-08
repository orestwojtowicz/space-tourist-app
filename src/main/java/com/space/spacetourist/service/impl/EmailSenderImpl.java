package com.space.spacetourist.service.impl;

import com.space.spacetourist.service.EmailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    /**
     * In order to sent mail with formated html style
     * we need second boolean parameter in MimeMessageHelper class
     * setText() method
     * */


    @Override
    public void sendEmail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setReplyTo("example@com");
            helper.setFrom("Registration@com");
            helper.setSubject(subject);
            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);

    }

    @Override
    public void sendTemplateHtml(String templateName, Context context) {

        String body = templateEngine.process(templateName,context);


    }
}














