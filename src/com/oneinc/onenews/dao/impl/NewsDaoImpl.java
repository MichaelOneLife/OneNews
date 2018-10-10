package com.oneinc.onenews.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.oneinc.onenews.dao.INewsDao;
import com.oneinc.onenews.entity.News;
import com.oneinc.onenews.util.DBUtil;

/**
 * 新闻DAO实现
 * @author michael
 * @date 2018年10月10日 上午10:34:10
 */
public class NewsDaoImpl implements INewsDao {

	@Override
	public News getNewsById(String id) throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT * FROM news_news WHERE id=?";
		return queryRunner.query(sql, new BeanHandler<News>(News.class), id);
	}

	@Override
	public List<Map<String, Object>> listNewsByState(String stateId) throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT id, title FROM news_news WHERE stateid=?";
		List<Map<String, Object>> newsList = new ArrayList<>();
		newsList = queryRunner.query(sql, new MapListHandler(), stateId);
		return newsList;
	}

	@Override
	public List<Map<String, Object>> listNewsCategory() throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT id, name FROM news_category";
		List<Map<String, Object>> newsCategoryList = new ArrayList<>();
		newsCategoryList = queryRunner.query(sql, new MapListHandler());
		return newsCategoryList;
	}

	@Override
	public List<Map<String, Object>> listNewsByCategory(String categoryId, String stateId) throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT id, title FROM news_news WHERE categoryId=? AND stateid=?";
		List<Map<String, Object>> newsList = new ArrayList<>();
		newsList = queryRunner.query(sql, new MapListHandler(), categoryId, stateId);
		return newsList;
	}

	@Override
	public void saveNews(News news) throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "INSERT INTO news_news(userid, stateid, categoryid, title, content, image, visitors, createtime, modifytime) VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
		queryRunner.update(sql, news.getUserId(), news.getStateId(), news.getCategoryId(), news.getTitle(), news.getContent(), news.getImage(), news.getVisitors());
	}

	@Override
	public void updateNewsState(String newsId, String stateId) throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "UPDATE news_news SET stateId=?, modifytime=NOW() WHERE id=?";
		queryRunner.update(sql, stateId, newsId);
		
	}
}
