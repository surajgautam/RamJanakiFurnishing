package com.technep.ramjanaki.signup.controller;

import com.technep.ramjanaki.login.model.CodeUser;
import com.technep.ramjanaki.login.model.User;
import com.technep.ramjanaki.signup.service.SigupService;
import com.technep.ramjanaki.sms.TextBeltDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class SignupController {

    @Autowired
    private SigupService signupService;

    private User user=null;


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signup(@ModelAttribute("user") User user) {
        this.user = user;
        Random random = new Random();
        Integer code =  10000 + random.nextInt(99999);
        CodeUser codeUser = new CodeUser();
        codeUser.setCode(code);
        signupService.saveCodeUser(codeUser);
        TextBeltDemo.sendSms(code,user.getMobileNumber());



       /* signupService.saveUser(user);*/

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("verifySuccess", true);
       /* mv.addObject("message", "Signup successfull");*/

        return mv;
    }

    @RequestMapping(value = "/verify/user", method = RequestMethod.POST)
    public ModelAndView verifyUser(@RequestParam("code") Integer code) {

        if(!code.equals(null)){
            if(signupService.isValidCode(code)){
             signupService.saveUser(user);
            }
        }

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("signupSuccessful", true);
        mv.addObject("message", "Signup successfull");

        return mv;
    }


}
