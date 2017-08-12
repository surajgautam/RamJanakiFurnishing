package com.technep.ramjanaki.subscribe.daoimpl;

import com.technep.ramjanaki.subscribe.dao.SubscribeDao;
import com.technep.ramjanaki.subscribe.model.Subscribe;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by surajgautam on 8/12/17.
 */
@Repository
public class SubscribeDaoImpl implements SubscribeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveSubscriber(Subscribe subscribe) {
       sessionFactory.getCurrentSession().save(subscribe);
    }
}
