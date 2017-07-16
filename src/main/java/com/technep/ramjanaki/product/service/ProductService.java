package com.technep.ramjanaki.product.service;

import com.technep.ramjanaki.product.model.Product;

import java.util.List;

/**
 * Created by surajgautam on 6/26/17.
 */
public interface ProductService {

    List<Product> getActiveProducts();

    List<Product> getProductByCategory(int id);

    Product getProductByProductId(int id);

    void updateProduct(Product product);
    List<Product> getAllProducts();

    void insertProduct(Product product);



}
