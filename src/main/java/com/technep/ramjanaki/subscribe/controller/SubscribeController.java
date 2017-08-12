package com.technep.ramjanaki.subscribe.controller;

import com.technep.ramjanaki.mail.service.MailSenderService;
import com.technep.ramjanaki.subscribe.model.Subscribe;
import com.technep.ramjanaki.subscribe.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

/**
 * Created by surajgautam on 8/11/17.
 */
@Controller
public class SubscribeController {

    @Autowired private SubscribeService subscribeService;

    @Autowired private MailSenderService mailSenderService;



    @RequestMapping(value = "/subscribe/newsletter",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView subscribeToRamJanaki(@ModelAttribute Subscribe subscribe) throws MessagingException {

        subscribe.setStatus(true);
        subscribeService.saveSubscriber(subscribe);
        mailSenderService.sendMail("teamwarrior20@gmail.com","teamwarrior200@gmail.com","","Hey test");
        return new ModelAndView("redirect:/index?action=subscribe");
    }
}
