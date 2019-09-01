package com.lena.service;

import com.lena.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
