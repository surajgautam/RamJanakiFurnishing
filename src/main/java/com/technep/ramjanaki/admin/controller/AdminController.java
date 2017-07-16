package com.technep.ramjanaki.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by surajgautam on 7/9/17.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/manage")
    public ModelAndView returnAdmin(){
        ModelAndView modelAndView = new ModelAndView("admin/admin");
        modelAndView.addObject("title","Admin Panel");
        return  modelAndView;
    }
}
