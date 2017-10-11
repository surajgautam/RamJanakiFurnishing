package com.technep.ramjanaki.signup.service;

import com.technep.ramjanaki.login.model.CodeUser;
import com.technep.ramjanaki.login.model.User;

public interface SigupService {

    public void saveUser(User user);

    public void saveCodeUser(CodeUser user);
    public boolean isValidCode(Integer code);
}
