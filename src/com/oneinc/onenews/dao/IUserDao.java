package com.oneinc.onenews.dao;

import java.sql.SQLException;

import com.oneinc.onenews.entity.User;

public interface IUserDao {

	/**
	 * 新增用户
	 * @param user 用户对象
	 * @throws SQLException
	 */
	public void saveUser(User user) throws SQLException;
}
