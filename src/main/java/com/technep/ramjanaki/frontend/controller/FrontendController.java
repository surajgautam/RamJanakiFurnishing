package com.technep.ramjanaki.frontend.controller;

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
        return  modelAndView;

    }

}
