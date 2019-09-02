package com.lena.web.admin;

import com.lena.po.Blog;
import com.lena.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogsController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public String getBlogs(@PageableDefault(size=2,sort="crateTime",direction = Sort.Direction.DESC) Pageable pageable,
                           Blog blog,Model model){
        model.addAttribute("page",blogService.getList(pageable,blog));

        return "admin/blogs";
    }
}
