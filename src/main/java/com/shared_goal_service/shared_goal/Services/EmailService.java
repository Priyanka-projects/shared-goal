package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Util.EmailDetails;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
