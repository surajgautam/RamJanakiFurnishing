package com.technep.ramjanaki.login.serviceimpl;

import com.technep.ramjanaki.login.dao.LoginDao;
import com.technep.ramjanaki.login.model.User;
import com.technep.ramjanaki.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired private LoginDao loginDao;

    public User getUserByUserName(String userName) {

    return loginDao.getUserByUserName(userName);

    }

    public boolean isuserExists(String userName) {
        return loginDao.isuserExists(userName);
    }

}
