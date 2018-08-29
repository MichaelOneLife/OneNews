package com.oneinc.onenews.service;

import java.util.List;
import java.util.Map;

import com.oneinc.onenews.dao.INewsDao;
import com.oneinc.onenews.dao.impl.NewsDaoImpl;
import com.oneinc.onenews.entity.News;

/**
 * 新闻请求服务类
 * @Author michael
 * @Date 2018年7月15日 下午12:08:09
 */
public class NewsService {
	
	/**
	 * 根据新闻ID获取新闻详情
	 * @param newsId 新闻ID
	 * @return 新闻对象
	 */
	public News getNewsDetail(String newsId) {
		INewsDao newsDao = new NewsDaoImpl();
		News news = newsDao.getNews(newsId);
		return news;
	}
	
	/**
	 * 获取已发布新闻
	 * @return 新闻ID与新闻标题集合
	 */
	public List<Map<String, Object>> getPublishedNews() {
		INewsDao newsDao = new NewsDaoImpl();
		List<Map<String, Object>> listNews = newsDao.listNewsByState("3");
		return listNews;
	}
	
	/**
	 * 获取所有新闻分类
	 * @return 新闻分类集合
	 */
	public List<Map<String, Object>> getNewsCategory() {
		INewsDao newsDao = new NewsDaoImpl();
		List<Map<String, Object>> listNewsCategory = newsDao.listNewsCategory();
		return listNewsCategory;
	}
	

	/**
	 * 根据类别获取已发布新闻
	 * @return 新闻ID与新闻标题集合
	 */
	public List<Map<String, Object>> getNewsByCategory(String categoryId) {
		INewsDao newsDao = new NewsDaoImpl();
		List<Map<String, Object>> listNews = newsDao.listNewsByCategory(categoryId, "3");
		return listNews;
	}
}
