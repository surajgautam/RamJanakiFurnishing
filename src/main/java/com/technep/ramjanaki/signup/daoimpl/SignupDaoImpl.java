package com.technep.ramjanaki.signup.daoimpl;

import com.technep.ramjanaki.login.model.CodeUser;
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

    public void saveCodeUser(CodeUser user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public boolean isValidCode(Integer code) {
        CodeUser codeUser = (CodeUser) sessionFactory.getCurrentSession().createQuery("From CodeUser u where u.code =:code").setParameter("code", code).uniqueResult();
        return codeUser!=null;
    }

}
