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

public class NewsDaoImpl implements INewsDao {

	@Override
	public News getNews(String id) {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT * FROM news_news WHERE id=?";
		News news = new News();
		try {
			news = queryRunner.query(sql, new BeanHandler<News>(News.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

	@Override
	public List<Map<String, Object>> listNewsByState(String stateId) {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT id, title FROM news_news WHERE stateid=?";
		List<Map<String, Object>> newsList = new ArrayList<>();
		try {
			newsList = queryRunner.query(sql, new MapListHandler(), stateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public List<Map<String, Object>> listNewsCategory() {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT id, name FROM news_category";
		List<Map<String, Object>> newsCategoryList = new ArrayList<>();
		try {
			newsCategoryList = queryRunner.query(sql, new MapListHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsCategoryList;
	}

	@Override
	public List<Map<String, Object>> listNewsByCategory(String categoryId, String stateId) {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT b.id, b.title FROM news_news_category a LEFT JOIN news_news b ON a.newsid = b.id WHERE a.categoryId=? AND b.stateid=?";
		List<Map<String, Object>> newsList = new ArrayList<>();
		try {
			newsList = queryRunner.query(sql, new MapListHandler(), categoryId, stateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}

}
