package com.technep.ramjanaki.frontend.controller;

import com.technep.ramjanaki.category.model.Category;
import com.technep.ramjanaki.category.service.CategoryService;
import org.apache.taglibs.standard.lang.jstl.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by surajgautam on 6/21/17.
 */
@Controller
public class FrontendController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView returnIndexPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Category> allCategories = categoryService.getAllCategories();
        //checking if list of categories is null or not
        if (allCategories != null) {
            modelAndView.addObject("categories", allCategories);
        }
        modelAndView.addObject("userHome", true);
        modelAndView.addObject("title", "Home");

        return modelAndView;

    }

    @RequestMapping(value = {"/aboutus"}, method = RequestMethod.GET)
    public ModelAndView returnAboutUs() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userAbout", true);
        modelAndView.addObject("title", "About Us");
        return modelAndView;

    }

    @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
    public ModelAndView returnContact() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userContact", true);
        modelAndView.addObject("title", "Contact");
        return modelAndView;

    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView returnLogin() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userLogin", true);
        modelAndView.addObject("title", "Login");
        return modelAndView;

    }
    @RequestMapping(value = {"/show/products"}, method = RequestMethod.GET)
    public ModelAndView showAllProducts() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Category> allCategories = categoryService.getAllCategories();
        if(allCategories!=null){
            modelAndView.addObject("categories",allCategories);
        }
        modelAndView.addObject("userAllProducts", true);
        modelAndView.addObject("title", "All Products");
        return modelAndView;

    }

    @RequestMapping(value = {"/show/category/{pid}/products"}, method = RequestMethod.GET)
    public ModelAndView showProductsByCategory(@PathVariable("pid") int pid) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Category> allCategories = categoryService.getAllCategories();
        if(allCategories!=null){
            modelAndView.addObject("categories",allCategories);
        }
        Category categoryById = categoryService.getCategoryById(pid);
        if(categoryById!=null){
            modelAndView.addObject("category",categoryById);
        }
        modelAndView.addObject("userSingleProduct", true);
        modelAndView.addObject("title", "View Product");
        return modelAndView;

    }
}
