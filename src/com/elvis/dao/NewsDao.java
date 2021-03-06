package com.elvis.dao;

import java.util.List;
import java.util.Set;

import com.elvis.pojo.News;

public interface NewsDao {
	public boolean doCreate(News vo) throws Exception;

	public boolean doUpdate(News vo) throws Exception;

	public boolean doRemoveBatch(Set<Integer> ids) throws Exception;

	public News findById(Integer id) throws Exception ;
	
	public List<News> findAll() throws Exception;

	public List<News> findAllSplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception;

	public Integer getAllCount(String column, String keyWord) throws Exception;
}
