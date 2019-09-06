package com.lena.dao;

import com.lena.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by TaoXia on 2019/8/16.
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

    @Query("select tag from Tag tag")
    List<Tag> findbyTop(Pageable pageable);
}
