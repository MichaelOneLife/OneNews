package com.oneinc.onenews.dao;

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
	 */
	public News getNewsById(String id);
	
	/**
	 * 根据状态获取所有新闻
	 * @return 新闻对象集合
	 */
	public List<Map<String, Object>> listNewsByState(String stateId);
	
	/**
	 * 获取所有新闻分类
	 * @return 新闻分类名称集合
	 */
	public List<Map<String, Object>> listNewsCategory();
	
	/**
	 * 根据分类ID获取所有新闻
	 * @return 新闻对象集合
	 */
	public List<Map<String, Object>> listNewsByCategory(String categoryId, String stateId);
}
