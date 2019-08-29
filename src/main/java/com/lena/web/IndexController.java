package com.lena.web;

import com.lena.NoFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/8/28 16:55
 * @Version 1.0
 */
@Controller
public class IndexController {
    @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id,@PathVariable String name){
//        String blog=null;
//        if (blog==null){
//            throw new NoFoundException("博客不存在");
//        }
        System.out.println("-----Index");
        return "index";
    }
}

