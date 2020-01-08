package com.space.spacetourist.service;

import org.thymeleaf.context.Context;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
    void sendTemplateHtml(String templateName, Context context);
}
