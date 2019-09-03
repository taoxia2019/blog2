package com.lena.dao;

import com.lena.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TaoXia on 2019/8/15.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);
}
