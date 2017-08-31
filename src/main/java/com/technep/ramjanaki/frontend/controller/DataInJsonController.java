package com.technep.ramjanaki.frontend.controller;

import com.technep.ramjanaki.exception.ProductNotFoundException;
import com.technep.ramjanaki.product.model.Product;
import com.technep.ramjanaki.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
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
    public List<Product> getProducts(HttpServletResponse response) throws ProductNotFoundException {
        response.setHeader("Access-Control-Allow-Origin","*");
        List<Product> allProducts = productService.getActiveProducts();
        if(allProducts==null){
            throw new ProductNotFoundException("The product you are looking for doesn't exist");
        }
        else
            return allProducts;
    }

    @RequestMapping(value = "/get/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable("id")int id) throws ProductNotFoundException {

        List<Product> productByCategory = productService.getProductByCategory(id);
        if(productByCategory==null){
            throw new ProductNotFoundException("The product you are looking for doesn't exist");
        }
        else
            return productByCategory;
    }
}
