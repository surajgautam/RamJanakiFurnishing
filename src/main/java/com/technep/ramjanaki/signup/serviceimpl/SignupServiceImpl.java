package com.technep.ramjanaki.signup.serviceimpl;

import com.technep.ramjanaki.login.model.CodeUser;
import com.technep.ramjanaki.login.model.User;
import com.technep.ramjanaki.signup.dao.SignupDao;
import com.technep.ramjanaki.signup.service.SigupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignupServiceImpl implements SigupService {

    @Autowired private SignupDao signupDao;

    public void saveUser(User user) {

        signupDao.saveUser(user);

    }

    public void saveCodeUser(CodeUser user) {
        signupDao.saveCodeUser(user);
    }

    public boolean isValidCode(Integer code) {
        return signupDao.isValidCode(code);
    }
}
