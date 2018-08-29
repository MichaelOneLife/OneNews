package com.oneinc.onenews.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户角色实体类
 * @Author michael
 * @Date 2018年7月14日 下午4:32:13
 */
@Getter@Setter@ToString
public class UserRole {
	private Integer id;				//新闻状态ID
	private String name;			//新闻状态名称
	private String createtTime;		//创建时间
}
