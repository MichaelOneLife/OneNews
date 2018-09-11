package com.oneinc.onenews.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

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

}
