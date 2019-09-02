package com.lena.service;

import com.lena.NotFoundException;
import com.lena.dao.BlogRepository;
import com.lena.po.Blog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BlogServiceImpl
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/2 15:41
 * @Version 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Page<Blog> getList(Pageable pageable, Blog blog) {
        //Specification规格，说明书
        blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                //Predicate断言,Criteria条件
                List<Predicate> predicates=new ArrayList<>();
                //添加查询条件一,模糊查询blog标题
                if(!"".equals(blog.getTitle())&& blog.getTitle()!=null){
                    predicates.add(cb.like(root.<String>get("title"),"%"+blog.getTitle()+"%"));
                }
                //添加查询条件二，blog分类，级联查询
                if(blog.getType().getId()!=null){
                    predicates.add(cb.equal(root.<Long>get("type").get("id"),blog.getType().getId()));
                }
                //添加查询条件三，是否推荐recommend
                if(blog.isRecommend()){
                    predicates.add(cb.equal(root.<Boolean>get("recommend"),blog.isRecommend()));
                }
                //集合转为数组
                Predicate[] predicates1 = predicates.toArray(new Predicate[predicates.size()]);
                //放入查询条件中
                cq.where(predicates1);
                return null;
            }
        },pageable);


        return null;
    }


    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b = blogRepository.findById(id).get();
        if(b==null){
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(b,blog);

        return blogRepository.save(b);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
