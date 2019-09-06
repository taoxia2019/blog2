package com.lena.service;

import com.lena.po.Blog;
import com.lena.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by TaoXia on 2019/8/20.
 */
public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(String query,Pageable pageable);

    Blog saveBlog(Blog blog);

    Blog getAndConvert(Long id);

    List<Blog> listRecommendBlogTop(Integer size);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
