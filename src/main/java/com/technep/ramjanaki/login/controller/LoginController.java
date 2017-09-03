package com.technep.ramjanaki.login.controller;

import com.technep.ramjanaki.category.model.Category;
import com.technep.ramjanaki.category.service.CategoryService;
import com.technep.ramjanaki.login.model.User;
import com.technep.ramjanaki.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired private LoginService loginService;

    @Autowired private HttpSession httpSession;

    @Autowired private CategoryService categoryService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("userName") String userName,@RequestParam("password")String password){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Category> allCategories = categoryService.getActiveCategories();
        if(userName!=null){

            User user = null;
            //if there is user then only check for password
            if(loginService.isuserExists(userName)){
                user = loginService.getUserByUserName(userName);
                if(user.getPassword().equals(password)){

                    httpSession.setAttribute("id",user.getUid());
                    httpSession.setAttribute("userName",user.getUserName());
                    modelAndView.addObject("categories",allCategories);
                    modelAndView.addObject("message","Welcome" + user.getUserName());
                    modelAndView.addObject("userAllProducts",true);
                    return modelAndView;
                }
            }

        }

        return new ModelAndView("index").addObject("userLogin",true).addObject("message","Invalid login");
    }

}
