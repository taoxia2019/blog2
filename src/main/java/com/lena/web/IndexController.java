package com.lena.web;

import com.lena.NoFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/8/28 16:55
 * @Version 1.0
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        String blog=null;
        if (blog==null){
            throw new NoFoundException("博客不存在");
        }
        return "index";
    }
}

