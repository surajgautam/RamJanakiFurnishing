package com.technep.ramjanaki.signup.controller;

import com.technep.ramjanaki.login.model.User;
import com.technep.ramjanaki.signup.service.SigupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {

    @Autowired private SigupService signupService;


    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ModelAndView signup(@ModelAttribute("user") User user){

        signupService.saveUser(user);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("signupSuccessful",true);
        mv.addObject("message","Signup successfull");

        return mv;
    }

}
