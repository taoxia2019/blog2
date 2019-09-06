package com.lena;

import com.lena.service.BlogService;
import com.lena.service.TypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {
	@Autowired
	private TypeService typeService;
	@Autowired
	private BlogService blogService;


	@Test
	public void contextLoads() {
		long id = Long.parseLong("4");
		System.out.println(typeService.listTypeTop(6));
		System.out.println(blogService.getBlog(id).getAppreciation());
	}

}
