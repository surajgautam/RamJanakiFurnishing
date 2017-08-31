package com.technep.ramjanaki.subscribe.daoimpl;

import com.technep.ramjanaki.subscribe.dao.SubscribeDao;
import com.technep.ramjanaki.subscribe.model.Subscribe;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Subscribe> getAllActiveSubscribersByEmail() {
        return  sessionFactory.getCurrentSession().createQuery("From Subscribe s where s.status=:status").setParameter("status",true).list();
    }

    public void updateStatus(String email) {
        sessionFactory.getCurrentSession().createQuery("update Subscribe s SET s.status=:status WHERE s.email=:email").setParameter("email",email).setParameter("status",false).executeUpdate();
    }
}
