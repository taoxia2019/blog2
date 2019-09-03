package com.lena.dao;

import com.lena.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TaoXia on 2019/8/16.
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);
}
