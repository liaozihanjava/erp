package com.elvis.action;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Repository;

import com.elvis.pojo.News;
import com.elvis.service.NewsService;
import com.opensymphony.xwork2.ActionSupport;

@Repository
@ParentPackage(value = "root")
@Namespace(value = "/pages/news")
@Action(value = "NewsAction")
public class NewsAction extends ActionSupport {
	@Resource
	private NewsService newsService;
	private News news = new News();

	public News getNews() {
		return news;
	}

	public void insert() {
		System.out.println("【新闻数据增加】数据：" + this.news);
		try {
			System.out.println("【新闻数据增加】业务调用结果：" + this.newsService.insert(this.news));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		System.out.println("【新闻数据修改】数据：" + this.news);
		try {
			System.out.println("【新闻数据修改】业务调用结果：" + this.newsService.update(this.news));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		String ids = ServletActionContext.getRequest().getParameter("ids");
		System.out.println("【新闻数据删除】数据：" + ids);
		try {
			Set<Integer> set = new HashSet<Integer>();
			String result[] = ids.split("\\,");
			for (int x = 0; x < result.length; x++) {
				set.add(Integer.parseInt(result[x]));
			}
			System.out.println("【新闻数据修改】业务调用结果：" + this.newsService.delete(set));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void get() {
		System.out.println("【新闻数据取得】数据：" + this.news);
		try {
			System.out.println("【新闻数据取得】业务调用结果：" + this.newsService.get(this.news.getNid()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void list() {
		System.out.println("【新闻数据查询】数据：" + this.news);
		try {
			System.out.println("【新闻数据查询】业务调用结果：" + this.newsService.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listSplit() {
		System.out.println("【新闻数据查询】数据：" + this.news);
		try {
			System.out.println("【新闻数据查询】业务调用结果：" + this.newsService.list("title", "", 1, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
