package com.oneinc.onenews.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.oneinc.onenews.dao.IUserDao;
import com.oneinc.onenews.entity.User;
import com.oneinc.onenews.util.DBUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public void saveUser(User user) throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "INSERT INTO sys_user(roleid, phone, password, username, createtime, modifytime) VALUES (?, ?, ?, ?, NOW(), NOW())";
		queryRunner.update(sql, user.getRoleId(), user.getPhone(), user.getPassword(), user.getUsername());
	}

	@Override
	public User getUserByPhone(String phone) throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "SELECT * FROM sys_user WHERE phone=?";
		return queryRunner.query(sql, new BeanHandler<User>(User.class), phone);
	}

	@Override
	public void modifyUserInfo(User user) throws SQLException {
		QueryRunner queryRunner = DBUtil.getQueryRunner();
		String sql = "UPDATE sys_user SET username=?, birthday=?, gender=?, email=?, introduction=?, modifytime=NOW() WHERE id=?";
		queryRunner.update(sql, user.getUsername(), user.getBirthday(), user.getGender(), user.getEmail(), user.getIntroduction(), user.getId());
	}

}
