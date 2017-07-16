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
        return sessionFactory.getCurrentSession().createQuery("From Products p").list();
    }

    public List<Product> getActiveProducts() {
        return sessionFactory.getCurrentSession().createQuery("From Product p where p.category.active=:active").setParameter("active",true).list();
    }

    public List<Product> getProductByCategory(int id) {

        return sessionFactory.getCurrentSession().createQuery("From Product p WHERE p.category.cid=:cid AND p.active=:active").setParameter("cid",id).setParameter("active",true).list();
    }

    public Product getProductByProductId(int id) {
        return (Product) sessionFactory.getCurrentSession().createQuery("From Product p Where p.pid=:pid AND p.active=:active").setParameter("pid",id).setParameter("active",true).uniqueResult();
    }

    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    public void insertProduct(Product product){

         sessionFactory.getCurrentSession().save(product);

    }
}
