package com.oneinc.onenews.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 新闻分类实体类
 * @Author michael
 * @Date 2018年7月14日 下午4:32:13
 */
@Getter@Setter@ToString
public class NewsCategory {
	private Integer id;				// 新闻分类ID
	private String name;			// 新闻分类名称
	private String belongId;		// 大类ID
	private String createtTime;		// 创建时间
}