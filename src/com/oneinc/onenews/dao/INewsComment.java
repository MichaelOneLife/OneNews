package com.oneinc.onenews.dao;

import java.sql.SQLException;
import java.util.List;

import com.oneinc.onenews.entity.NewsComment;

/**
 * 新闻评论DAO接口
 * @author michael
 * @date 2018年10月9日 下午3:48:59
 */
public interface INewsComment {

	/**
	 * 根据新闻ID获取所有评论
	 * @return
	 * @throws SQLException
	 */
	public List<NewsComment> listNewsCommentByNewsId() throws SQLException;
}
