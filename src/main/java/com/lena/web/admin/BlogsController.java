package com.lena.web.admin;


import com.lena.po.Blog;
import com.lena.service.BlogService;
import com.lena.service.TypeService;
import com.lena.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogsController {
    private static final String INPUT="admin/blogs-input";
    private static final String LIST="admin/blogs";
    private static final String REDIRECT_LIST="admin/blogs";
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        BlogQuery blogVo, Model model) {
        model.addAttribute("types", typeService.listType());
        System.out.println(typeService.listType());
        model.addAttribute("page", blogService.getList(pageable, blogVo));
        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blogVo, Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.getList(pageable, blogVo));
        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("blog",new Blog());
        return INPUT;
    }
}
