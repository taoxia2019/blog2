package com.lena.dao;

import com.lena.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by TaoXia on 2019/8/16.
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    /*@Query("select type from Type type")
    List<Type> findTopBySize(Pageable pageable);*/
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
