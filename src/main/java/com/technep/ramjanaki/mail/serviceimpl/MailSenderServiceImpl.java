package com.technep.ramjanaki.mail.serviceimpl;

import com.technep.ramjanaki.mail.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by surajgautam on 8/12/17.
 */
@Service
@Transactional
public class MailSenderServiceImpl implements MailSenderService {

    @Autowired private JavaMailSenderImpl mailSender;

    public void sendMail(String to, String subject, String message) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
//        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(message);

        mailSender.send(mimeMessage);


    }
}
