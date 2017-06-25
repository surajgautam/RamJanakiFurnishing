package com.technep.ramjanaki.frontend.controller;

import org.apache.taglibs.standard.lang.jstl.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by surajgautam on 6/21/17.
 */
@Controller
public class FrontendController {

   @RequestMapping(value={"/","/index"},method = RequestMethod.GET)
    public ModelAndView returnIndexPage(){
        ModelAndView modelAndView = new ModelAndView("index");
       modelAndView.addObject("userHome",true);
       modelAndView.addObject("title","Home");

        return  modelAndView;

    }



    @RequestMapping(value={"/aboutus"},method = RequestMethod.GET)
    public ModelAndView returnAboutUs(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userAbout",true);
        modelAndView.addObject("title","About Us");
        return  modelAndView;

    }

    @RequestMapping(value={"/contact"},method = RequestMethod.GET)
    public ModelAndView returnContact(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userContact",true);
        modelAndView.addObject("title","Contact");
        return  modelAndView;

    }

    @RequestMapping(value={"/login"},method = RequestMethod.GET)
    public ModelAndView returnLogin(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userLogin",true);
        modelAndView.addObject("title","Login");
        return  modelAndView;

    }

}
