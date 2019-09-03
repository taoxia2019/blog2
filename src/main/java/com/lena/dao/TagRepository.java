package com.lena.dao;

import com.lena.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TaoXia on 2019/8/16.
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);
}
