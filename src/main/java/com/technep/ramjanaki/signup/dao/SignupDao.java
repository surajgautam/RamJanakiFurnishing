package com.technep.ramjanaki.signup.dao;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.technep.ramjanaki.login.model.CodeUser;
import com.technep.ramjanaki.login.model.User;

public interface SignupDao {

    public void saveUser(User user);

    public void saveCodeUser(CodeUser user);

    public boolean isValidCode(Integer code);
}
