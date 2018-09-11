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
}
