package com.technep.ramjanaki.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by surajgautam on 8/11/17.
 */
@Controller
@RequestMapping(value="/admin")
public class SliderController {


    @RequestMapping(value = "/slider")
    public ModelAndView showSliderJsp(){
        return new ModelAndView("admin/admin").addObject("sliderClicked",true);
    }


}
