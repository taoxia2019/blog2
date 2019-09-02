package com.lena.service;

import com.lena.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {
    Type saveType(Type type);
    Type getType(Long id);
    Page<Type> listType(Pageable pageable);
    Type update(Long id,Type type);
    void deleteType(Long id);
    Type findByName(String name);
}
