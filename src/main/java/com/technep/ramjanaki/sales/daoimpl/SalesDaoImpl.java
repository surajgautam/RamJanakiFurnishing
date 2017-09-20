package com.technep.ramjanaki.sales.daoimpl;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/

import com.technep.ramjanaki.sales.dao.SalesDao;
import com.technep.ramjanaki.sales.model.SalesModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalesDaoImpl implements SalesDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void saveSales(SalesModel salesModel) {
        sessionFactory.getCurrentSession().save(salesModel);

    }
}
