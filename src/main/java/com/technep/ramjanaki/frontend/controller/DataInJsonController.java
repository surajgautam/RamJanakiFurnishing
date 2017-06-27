package com.technep.ramjanaki.frontend.controller;

import com.technep.ramjanaki.product.model.Product;
import com.technep.ramjanaki.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by surajgautam on 6/25/17.
 */
@Controller
public class DataInJsonController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/get/all/products")
    @ResponseBody
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/get/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable("id")int id){
        return productService.getProductByCategory(id);
    }
}
