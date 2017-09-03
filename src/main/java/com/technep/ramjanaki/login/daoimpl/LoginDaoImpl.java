package com.technep.ramjanaki.login.daoimpl;

import com.technep.ramjanaki.login.dao.LoginDao;
import com.technep.ramjanaki.login.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired  private SessionFactory sessionFactory;

    public User getUserByUserName(String userName) {

        return (User) sessionFactory.getCurrentSession().createQuery("From User u where u.userName=:name").setParameter("name",userName).uniqueResult();

    }

    public boolean isuserExists(String userName) {
        Long count = (Long) sessionFactory.getCurrentSession().createQuery("Select count(u.uid) From User u where u.userName=:name").setParameter("name", userName).uniqueResult();
        return (count==0)?false:true;
    }

}
