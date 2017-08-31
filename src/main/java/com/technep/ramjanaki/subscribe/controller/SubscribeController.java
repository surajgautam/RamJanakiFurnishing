package com.technep.ramjanaki.subscribe.controller;

import com.technep.ramjanaki.mail.service.MailSenderService;
import com.technep.ramjanaki.subscribe.dto.SubscribeDto;
import com.technep.ramjanaki.subscribe.model.Subscribe;
import com.technep.ramjanaki.subscribe.service.SubscribeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

/**
 * Created by surajgautam on 8/11/17.
 */
@Controller
public class SubscribeController {



    @Autowired private SubscribeService subscribeService;

    @Autowired private MailSenderService mailSenderService;

    private  Logger logger = Logger.getLogger(SubscribeController.class);



    @RequestMapping(value = "/subscribe/newsletter",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView subscribeToRamJanaki(@ModelAttribute Subscribe subscribe) throws MessagingException {

        subscribe.setStatus(true);
        subscribeService.saveSubscriber(subscribe);
        /*mailSenderService.sendMail("teamwarrior200@gmail.com","","Hey test");*/
        return new ModelAndView("redirect:/index?action=subscribe");
    }

    //for admin
    @RequestMapping(value = "/admin/get/subscribers",method = RequestMethod.GET)
    public ModelAndView  getSubscribers(@RequestParam(name="action",required = false) String action){
        ModelAndView modelAndView = new ModelAndView("admin/admin") ;


        if(action!=null){
            if(action.equals("true")){
                modelAndView.addObject("message","Email Sent Successfully");
            }
        }
        return  modelAndView.addObject("subscribe",true).addObject("subscribers",subscribeService.getAllActiveSubscribersByEmail());
    }


    @RequestMapping(value = "/admin/subscribe/send/mail",method = RequestMethod.POST)
    public String sendMail(@ModelAttribute("subscribeDto") SubscribeDto subscribeDto) throws MessagingException {

        if(subscribeDto!=null){
            for(String email:subscribeDto.getEmails()){
                logger.info("*****************Sending Mail*************");
                logger.info("Sending mail to : " + email);
                mailSenderService.sendMail(email,"Ram Janaki Furnishing NewsLetter","Thank you "+email + " for subscribing to Ram Janaki Furnishing. News Letter would be available very soon. Regards, Ramjanaki Frunishing and Decor Pvt. Ltd baneshwor");

            }
            return "redirect:/admin/get/subscribers?action=true";
        }
        return "redirect:/admin/get/subscribers";
    }

    @RequestMapping(value="/unsubscribe")
    public ModelAndView unsubscribe(){
        ModelAndView modelAndView = new ModelAndView("admin/admin");
       /* subscribeService.updateStatus();*/
        modelAndView.addObject("message","Thank you for unsubscribing");
        return modelAndView;
    }
}
