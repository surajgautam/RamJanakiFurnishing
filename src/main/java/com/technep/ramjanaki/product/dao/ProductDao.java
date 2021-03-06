package com.technep.ramjanaki.product.dao;

import com.technep.ramjanaki.product.model.Product;

import java.util.List;

/**
 * Created by surajgautam on 6/26/17.
 */
public interface ProductDao {

    List<Product> getAllProducts();

    List<Product> getActiveProducts();

    List<Product> getProductByCategory(int id);

    Product getProductByProductId(int id);

     void updateProduct(Product product);

    void insertProduct(Product product);


}
