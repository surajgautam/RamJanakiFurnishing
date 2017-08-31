package com.technep.ramjanaki.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @Autowired
    private  HttpSession httpSession;

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){

        httpSession.removeAttribute("id");
        httpSession.removeAttribute("userName");
        return "redirect:/login";

    }
}