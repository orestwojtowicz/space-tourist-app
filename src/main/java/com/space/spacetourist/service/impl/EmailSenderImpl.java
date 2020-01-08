package com.space.spacetourist.service.impl;

import com.space.spacetourist.service.EmailSender;
import com.space.spacetourist.shared.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Locale;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;

    /**
     * In order to sent mail with formated html style
     * we need second boolean parameter in MimeMessageHelper class
     * setText() method
     * */


    @Override
    @Async
    public void sendEmail(String to, String subject, String content, boolean
            isMultiPart, boolean isHtml) {
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
    @Async
    public void sendTemplateHtml(UserDto userDto, String templateName, String subject) {
        Locale locale = Locale.ENGLISH;
        Context context = new Context(locale);
        context.setVariable("user", userDto);
        String content = springTemplateEngine.process(templateName, context);
        sendEmail("damianwojtowicz94@gmail.com", subject, content, false, true);
    }

    /**
     *
     * */
    @Async
    public void sendWelcomeEmail(UserDto userDto) {
        sendTemplateHtml(userDto,"mail_template","Welcome "
                + userDto.getUsername());
    }




}














