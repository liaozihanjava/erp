package com.elvis.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elvis.pojo.News;
import com.elvis.service.NewsService;

import junit.framework.TestCase;

public class NewsServiceImplTest {
	public static ApplicationContext ctx;
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testInsert() {
		NewsService service = ctx.getBean("newsServiceImpl",
				NewsService.class);
		News vo = new News();
		vo.setTitle("LZH - " + System.currentTimeMillis());
		vo.setPubdate(new Date());
		vo.setContent("LZH内容很丰富");
		try {
			TestCase.assertEquals(service.insert(vo), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		NewsService service = ctx.getBean("newsServiceImpl", NewsService.class);
		News news = new News();
		news.setContent("ADAKJSDA");
		news.setPubdate(new Date());
		news.setTitle("sadas");
		news.setNid(9);
		try {
			TestCase.assertEquals(service.update(news), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
	}

	@Test
	public void testDelete() {
		NewsService service = ctx.getBean("newsServiceImpl",
				NewsService.class);
		Set<Integer> set = new HashSet<Integer>() ;
		set.add(1) ;
		set.add(3) ;
		set.add(5) ;
		try {
			TestCase.assertEquals(service.delete(set), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		NewsService service = ctx.getBean("newsServiceImpl",
				NewsService.class);
		try {
			List<News> all = service.list() ;
			System.out.println(all);
			TestCase.assertTrue(all.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListStringStringIntInt() {
		NewsService service = ctx.getBean("newsServiceImpl",
				NewsService.class);
		try {
			Map<String,Object> map = service.list("title", "", 1,2);
			System.out.println(map);
			TestCase.assertTrue(map.size() == 2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
