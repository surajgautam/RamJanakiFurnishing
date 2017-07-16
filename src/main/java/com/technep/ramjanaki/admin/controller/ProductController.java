package com.technep.ramjanaki.admin.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.technep.ramjanaki.category.service.CategoryService;
import com.technep.ramjanaki.product.model.Product;
import com.technep.ramjanaki.product.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by surajgautam on 7/9/17.
 */
@Controller
@RequestMapping(value = "/admin")
public class ProductController {

    final static Logger logger = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    //show product page
    @RequestMapping(value = "/products")
    public ModelAndView returnAdmin(@RequestParam(value = "operation", required = false) String operation) {
        ModelAndView modelAndView = new ModelAndView("admin/admin");
        modelAndView.addObject("title", "Products");
        modelAndView.addObject("productsClicked", true);
        if (operation != null) {


            if (operation.equals("successfull")) {
                modelAndView.addObject("message", "Product has been successfully added");
            }
        }
        return modelAndView;
    }


    //form post request
    @RequestMapping(value = "/add/product", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = null;
        logger.info("********************************************************");

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Products");
            model.addAttribute("productsClicked", true);
            model.addAttribute("message","Failed");
            return "admin/admin";
        } else {
            if (product != null) {
                productService.insertProduct(product);
            }

        }
        return "redirect:/admin/products?operation=successfull";
    }


}
