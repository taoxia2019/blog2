package com.lena.service;

import com.lena.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {
    Tag saveTag(Tag tag);
    Tag getTag(Long id);
    Page<Tag> listTag(Pageable pageable);
    Tag update(Long id, Tag tag);
    void deleteTag(Long id);
    Tag findByName(String name);
}
