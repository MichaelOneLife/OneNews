package com.oneinc.onenews.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.oneinc.onenews.entity.News;

/**
 * 新闻对象DAO接口
 * @Author michael
 * @Date 2018年7月14日 下午5:07:33
 */
public interface INewsDao {
	/**
	 * 根据新闻ID获取新闻
	 * @param id 新闻ID 
	 * @return 新闻对象
	 * @throws SQLException 
	 */
	public News getNewsById(String id) throws SQLException;
	
	/**
	 * 根据状态获取所有新闻
	 * @return 新闻对象集合
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> listNewsByState(String stateId) throws SQLException;
	
	/**
	 * 获取所有新闻分类
	 * @return 新闻分类名称集合
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> listNewsCategory() throws SQLException;
	
	/**
	 * 根据分类ID获取所有新闻
	 * @return 新闻对象集合
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> listNewsByCategory(String categoryId, String stateId) throws SQLException;
	
	/**
	 * 保存新闻
	 * @param news 新闻对象
	 * @throws SQLException 
	 */
	public void saveNews(News news) throws SQLException;
	
	/**
	 * 更新新闻状态
	 * @param newsId 新闻ID
	 * @param stateId 新闻状态ID
	 * @throws SQLException
	 */
	public void updateNewsState(String newsId, String stateId) throws SQLException;
}
