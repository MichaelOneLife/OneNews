package com.oneinc.onenews.service;

import java.sql.SQLException;
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
	 * @throws SQLException 
	 */
	public News getNewsDetail(String newsId) throws SQLException {
		INewsDao newsDao = new NewsDaoImpl();
		News news = newsDao.getNewsById(newsId);
		return news;
	}
	
	/**
	 * 获取已发布新闻
	 * @return 新闻ID与新闻标题集合
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> getPublishedNews() throws SQLException {
		INewsDao newsDao = new NewsDaoImpl();
		List<Map<String, Object>> listNews = newsDao.listNewsByState("3");
		return listNews;
	}
	
	/**
	 * 获取所有新闻分类
	 * @return 新闻分类集合
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> getNewsCategory() throws SQLException {
		INewsDao newsDao = new NewsDaoImpl();
		List<Map<String, Object>> listNewsCategory = newsDao.listNewsCategory();
		return listNewsCategory;
	}
	
	/**
	 * 根据类别获取已发布新闻
	 * @return 新闻ID与新闻标题集合
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> getNewsByCategory(String categoryId) throws SQLException {
		INewsDao newsDao = new NewsDaoImpl();
		List<Map<String, Object>> listNews = newsDao.listNewsByCategory(categoryId, "3");
		return listNews;
	}
	
	/**
	 * 新增新闻
	 * @param news 新闻对象
	 * @throws SQLException
	 */
	public void addNews(News news) throws SQLException {
		INewsDao newsDao = new NewsDaoImpl();
		newsDao.saveNews(news);
	}
	
	/**
	 * 更新新闻状态
	 * @param newsId 新闻ID
	 * @param stateId 新闻状态ID
	 * @throws SQLException
	 */
	public void updateNewsState(String newsId, String stateId) throws SQLException {
		INewsDao newsDao = new NewsDaoImpl();
		newsDao.updateNewsState(newsId, stateId);
	}
}
