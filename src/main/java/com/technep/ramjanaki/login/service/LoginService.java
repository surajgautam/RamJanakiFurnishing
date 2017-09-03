package com.technep.ramjanaki.login.service;

import com.technep.ramjanaki.login.model.User;

public interface LoginService {

    public User getUserByUserName(String userName);

    public boolean isuserExists(String userName);
}
