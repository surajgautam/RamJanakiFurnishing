package com.technep.ramjanaki.product.daoimpl;

import com.technep.ramjanaki.product.dao.ProductDao;
import com.technep.ramjanaki.product.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by surajgautam on 6/26/17.
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession().createQuery("From Product p where p.active=:active").setParameter("active",true).list();
    }

    public List<Product> getProductByCategory(int id) {

        return sessionFactory.getCurrentSession().createNativeQuery("SELECT p.p_id,p.p_name,p.p_active,p.p_description,p.p_image,p.p_price,p.p_quantity,p.p_views,p.c_id FROM ecommerce_product p INNER JOIN ecommerce_category c ON p.p_id=c.c_id ").addEntity(Product.class).list();
    }

    public void insert(Product product){

         sessionFactory.getCurrentSession().save(product);

    }
}
