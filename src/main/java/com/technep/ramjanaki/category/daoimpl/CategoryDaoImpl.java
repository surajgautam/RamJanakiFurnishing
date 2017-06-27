package com.technep.ramjanaki.category.daoimpl;

import com.technep.ramjanaki.category.dao.CategoryDao;
import com.technep.ramjanaki.category.model.Category;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by surajgautam on 6/25/17.
 */

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

    Logger logger = Logger.getLogger(CategoryDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public List<Category> getAllCategories() {
        return sessionFactory.getCurrentSession().createQuery("From Category c where c.active=:active").setParameter("active",true).list();
    }

    public Category getCategoryById(int id) {
        return sessionFactory.getCurrentSession().get(Category.class,id);
    }

    public boolean addCategory(Category category) {
        try{
            sessionFactory.getCurrentSession().save(category);
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            return false;
        }
    }
}


