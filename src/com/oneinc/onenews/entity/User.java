package com.oneinc.onenews.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户实体类
 * @Author michael
 * @Date 2018年7月14日 下午4:19:23
 */
@Getter@Setter@ToString
public class User {
	private Integer id;				// 用户ID
	private Integer roleId;			// 角色ID
	private String phone;			// 手机号，登录账号
	private String password;		// 登录密码
	private String username;		// 昵称
	private String birthday;		// 生日
	private String gender;			// 性别
	private String email;			// 邮箱
	private String photo;			// 头像图片地址
	private String introduction;	// 介绍
	private String createTime;		// 注册时间
}
