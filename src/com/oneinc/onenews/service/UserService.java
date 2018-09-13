package com.oneinc.onenews.service;

import java.sql.SQLException;

import com.oneinc.onenews.dao.IUserDao;
import com.oneinc.onenews.dao.impl.UserDaoImpl;
import com.oneinc.onenews.entity.User;

public class UserService {
	
	/**
	 * 保存用户
	 * @param user 用户对象
	 * @throws SQLException 
	 */
	public void saveUser(User user) throws SQLException {
		IUserDao dao = new UserDaoImpl();
		dao.saveUser(user);
	}
	
	/**
	 * 根据用户账号（手机号）获取用户信息
	 * @param phone 用户账号（手机号）
	 * @throws SQLException
	 */
	public User getUserByPhone(String phone) throws SQLException {
		IUserDao dao = new UserDaoImpl();
		return dao.getUserByPhone(phone);
	}
	
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 * @throws SQLException
	 */
	public void modifyUserInfo(User user) throws SQLException {
		IUserDao dao = new UserDaoImpl();
		dao.modifyUserInfo(user);
	}
}
