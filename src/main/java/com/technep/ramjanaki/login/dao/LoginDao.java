package com.technep.ramjanaki.login.dao;

import com.technep.ramjanaki.login.model.User;

public interface LoginDao {

    public User getUserByUserName(String userName);
}
