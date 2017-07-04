package com.technep.ramjanaki.admin.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.technep.ramjanaki.category.model.Category;
import com.technep.ramjanaki.category.service.CategoryService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by surajgautam on 7/3/17.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    final static Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/manage")
    public ModelAndView returnAdmin(){
        ModelAndView modelAndView = new ModelAndView("admin/admin");
        modelAndView.addObject("title","Admin Panel");
        return  modelAndView;
    }

    //show edit category form
    @RequestMapping(value = "/edit/category/{id}")
    public ModelAndView returnEditCategoryForm(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("admin/admin");
        modelAndView.addObject("editCategory",true);
        Category categoryById = categoryService.getCategoryById(id);
        if(categoryById!=null){
            modelAndView.addObject("category",categoryById);
        }
        return modelAndView;
    }

    //show edit category form
    @RequestMapping(value = "/edit/category",method = RequestMethod.POST)
    public ModelAndView editCategory(@ModelAttribute("category") Category category){

        if(category!=null){
            categoryService.updateCategory(category);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/categories");
        modelAndView.addObject("message","Successfully edited");
        return modelAndView;

    }

    //delete category form
    @RequestMapping(value = "/delete/category/{id}")
    public ModelAndView deleteCategory(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/categories");
        categoryService.deleteCategory(id);
        return modelAndView;
    }

    //for managing categories
    @RequestMapping(value = "/categories")
    public ModelAndView showCategories(){
        ModelAndView modelAndView = new ModelAndView("admin/admin");
        modelAndView.addObject("title","Show Categories");
        modelAndView.addObject("categoriesClicked",true);
        List<Category> allCategories = categoryService.getAllCategories();
        if(allCategories!=null){
            modelAndView.addObject("categories",allCategories);
        }
        return  modelAndView;
    }

    //show category form
    @RequestMapping(value = "/add/category",method = RequestMethod.GET)
    public ModelAndView showAddForm(){
        ModelAndView modelAndView = new ModelAndView("admin/admin");
        modelAndView.addObject("title","Add Category");
        modelAndView.addObject("addCategory",true);
        return modelAndView;
    }

    //add category in database
    @RequestMapping(value = "/add/category",method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category category){
       if(category!=null){
            logger.info(category.getCname());
            logger.info(category.isActive());
           categoryService.addCategory(category);
       }

       return "redirect:/admin/categories";

    }

}
