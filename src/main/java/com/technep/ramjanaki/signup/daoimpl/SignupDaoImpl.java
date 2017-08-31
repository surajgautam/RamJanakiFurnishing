package com.technep.ramjanaki.signup.daoimpl;

import com.technep.ramjanaki.login.model.User;
import com.technep.ramjanaki.signup.dao.SignupDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SignupDaoImpl implements SignupDao {

    @Autowired  private SessionFactory sessionFactory;

    public void saveUser(User user) {

        sessionFactory.getCurrentSession().save(user);

    }

}
