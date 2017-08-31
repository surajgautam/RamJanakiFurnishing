package com.technep.ramjanaki.payment.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

    @RequestMapping(value = "/payment")
    public ModelAndView returnPayment(@RequestParam("action")String action){

        ModelAndView mv = new ModelAndView("index");
        if(action!=null){
            if(StringUtils.equals(action,"su")){
                mv.addObject("payment",true);
                mv.addObject("message","Successfully paid");
                return mv;
            }
            if(StringUtils.equals(action,"fu")){
                mv.addObject("payment",true);
                mv.addObject("message","Payment Unsuccessful due to several reasons");
            }
        }
        return mv;

    }


}
