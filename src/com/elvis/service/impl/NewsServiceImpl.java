package com.elvis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elvis.dao.NewsDao;
import com.elvis.pojo.News;
import com.elvis.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Resource
	private NewsDao newsDao;
	
	@Override
	public boolean insert(News vo) throws Exception {
		return this.newsDao.doCreate(vo);
	}

	@Override
	public boolean update(News vo) throws Exception {
		return this.newsDao.doUpdate(vo);
	}

	@Override
	public News get(int id) throws Exception {
		return this.newsDao.findById(id);
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		if (ids.size() == 0) {
			return false;
		}
		return this.newsDao.doRemoveBatch(ids);
	}

	@Override
	public List<News> list() throws Exception {
		return this.newsDao.findAll();
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allNews", this.newsDao.findAllSplit(column, keyWord,
				currentPage, lineSize));
		map.put("newsCount", this.newsDao.getAllCount(column, keyWord));
		return map;
	}

}
