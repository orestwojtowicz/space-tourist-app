package com.space.spacetourist.service;

import com.space.spacetourist.shared.UserDto;
import org.thymeleaf.context.Context;

public interface EmailSender {
    void sendEmail(String to, String subject, String content, boolean isMultiPart, boolean isHtml);
    void sendTemplateHtml(UserDto userDto, String templateName, String subject);
}
