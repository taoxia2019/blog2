package com.lena.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogsController {

    @GetMapping("/blogs")
    public String getBlogs(){
        return "admin/blogs";
    }
}