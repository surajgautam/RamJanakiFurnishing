package com.technep.ramjanaki.mail.service;

import javax.mail.MessagingException;

/**
 * Created by surajgautam on 8/12/17.
 */
public interface MailSenderService {

    public void sendMail(String to, String subject, String message) throws MessagingException;
}
