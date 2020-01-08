package com.space.spacetourist.ui.controller;

import com.space.spacetourist.service.EmailSender;
import com.space.spacetourist.ui.model.response.OperationStatusModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @RequestMapping("/email")
    public String sendMail() {

        Context context = new Context();
        context.setVariable("header", "Nowy artykuł na CodeCouple");
        context.setVariable("title", "#8 Spring Boot – email - szablon i wysyłanie");
        context.setVariable("description", "Tutaj jakis opis...");
        String body = templateEngine.process("mail_template", context);
        emailSender.sendEmail("your.email.here@gmail.com", "CodeCouple Newsletter", body);
        return "index";
    }

}
