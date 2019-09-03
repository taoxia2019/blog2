package com.lena.service;

import com.lena.po.User;

/**
 * Created by TaoXia on 2019/8/15.
 */
public interface UserService {

    User checkUser(String username, String password);
}
