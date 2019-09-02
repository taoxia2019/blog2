package com.lena.service;

import com.lena.po.Blog;
import com.lena.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName BlogService
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/2 15:36
 * @Version 1.0
 */
public interface BlogService {
    Blog getBlog(Long id);
    Page<Blog> getList(Pageable pageable,BlogQuery blogVo);
    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id,Blog blog);
    void deleteBlog(Long id);
}
