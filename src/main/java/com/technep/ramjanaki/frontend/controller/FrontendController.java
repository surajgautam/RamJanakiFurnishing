package com.technep.ramjanaki.frontend.controller;

import com.technep.ramjanaki.category.model.Category;
import com.technep.ramjanaki.category.service.CategoryService;
import com.technep.ramjanaki.exception.ProductNotFoundException;
import com.technep.ramjanaki.product.model.Product;
import com.technep.ramjanaki.product.service.ProductService;
import org.apache.taglibs.standard.lang.jstl.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView returnIndexPage(@RequestParam(name="action",required = false) String action) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Category> allCategories = categoryService.getActiveCategories();

        List<Product> activeProducts = productService.getActiveProducts();
        //checking if list of categories is null or not
        if (allCategories != null) {
            modelAndView.addObject("categories", allCategories);
        }

        //if subscribed
        if(action!=null){
            if(action.equals("subscribe")){
                modelAndView.addObject("subscribeMessage","Thank you for subscribing to Ram Janaki Furnishing").addObject("userHome",true);
            }
        }
        modelAndView.addObject("userHome", true);
        modelAndView.addObject("title", "RamJanaki.com");
        modelAndView.addObject("products",activeProducts);
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

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public ModelAndView returnSignup() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userSignup", true);
        modelAndView.addObject("title", "Signup");
        return modelAndView;

    }
    //showing all products
    @RequestMapping(value = {"/show/products"}, method = RequestMethod.GET)
    public ModelAndView showAllProducts() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Category> allCategories = categoryService.getActiveCategories();
        if(allCategories!=null){
            modelAndView.addObject("categories",allCategories);
        }
        modelAndView.addObject("userAllProducts", true);
        modelAndView.addObject("title", "All Products");
        return modelAndView;

    }

    @RequestMapping(value = {"/show/category/{pid}/products"}, method = RequestMethod.GET)
    public ModelAndView showProductsByCategory(@PathVariable("pid") int pid) throws ProductNotFoundException {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Category> allCategories = categoryService.getActiveCategories();
        if(allCategories!=null){
            modelAndView.addObject("categories",allCategories);
        }
        Category categoryById = categoryService.getCategoryById(pid);
        if(categoryById!=null){
            modelAndView.addObject("category",categoryById);
        }
        else
            throw new ProductNotFoundException("The product you are looking for doesn't exist");
        modelAndView.addObject("userSingleProduct", true);
        modelAndView.addObject("title", "View Product");
        return modelAndView;

    }

    //used for dispalying single product

    @RequestMapping(value = "/show/{pid}/product")
    public ModelAndView showProductById(@PathVariable("pid") int pid) throws ProductNotFoundException {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userProductDetail",true);

        Product productByProductId = productService.getProductByProductId(pid);

        if(productByProductId!=null){
            modelAndView.addObject("product",productByProductId);
            modelAndView.addObject("title",productByProductId.getPname());
            productByProductId.setViews(productByProductId.getViews()+1);
            productService.updateProduct(productByProductId);
        }
        else
            throw new ProductNotFoundException("The product you are looking for doesn't exist");



        return modelAndView;

    }

    @RequestMapping(value = {"/esewatest"}, method = RequestMethod.GET)
    public ModelAndView returnEsewa() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("esewaTest", true);
        modelAndView.addObject("title", "About Us");
        return modelAndView;

    }
}
