package com.oneinc.onenews.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 连接数据库工具类
 * @author michael
 * @Date 2018年4月18日 下午11:14:53
 */
public class DBUtil {
	
	//数据源对象
	public static DataSource ds = null;
	
	static {
		try {
			Properties properties = new Properties();
			String resourcePath = DBUtil.class.getClassLoader().getResource("/db.properties").getPath();
			FileInputStream inputStream = new FileInputStream(resourcePath);
			properties.load(inputStream);
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Apache-dbUtils数据库自动连接对象
	 * @return QueryRunner对象
	 */
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(ds);
	}
	
	/**
	 * 释放数据库连接对象资源
	 * @param rs 查询结果集对象
	 * @param st 数据库预编译语句对象
	 * @param conn 数据库连接对象
	 */
	public static void release(ResultSet rs, Statement st, Connection conn) {
		
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
