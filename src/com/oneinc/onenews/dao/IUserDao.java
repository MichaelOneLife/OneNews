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
	
	/**
	 * 根据手机查询用户
	 * @param phone 登录账号（手机号）
	 * @throws SQLException
	 */
	public User getUserByPhone(String phone) throws SQLException;
	
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 * @throws SQLException
	 */
	public void modifyUserInfo(User user) throws SQLException;
}
