package com.technep.ramjanaki.product.serviceimpl;

import com.technep.ramjanaki.product.dao.ProductDao;
import com.technep.ramjanaki.product.model.Product;
import com.technep.ramjanaki.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by surajgautam on 6/26/17.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getActiveProducts() {
      return productDao.getActiveProducts();
    }

    public List<Product> getProductByCategory(int id) {
        return productDao.getProductByCategory(id);
    }

    public Product getProductByProductId(int id) {
        return productDao.getProductByProductId(id);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public void insertProduct(Product product) {
        productDao.insertProduct(product);
    }
}
