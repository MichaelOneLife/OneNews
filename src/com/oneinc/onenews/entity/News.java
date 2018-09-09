package com.oneinc.onenews.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 新闻实体类
 * @Author michael
 * @Date 2018年7月14日 下午4:24:13
 */
@Getter@Setter@ToString
public class News {
	private Integer id;				// 新闻ID
	private Integer userId;			// 用户ID
	private Integer stateId;		// 状态ID
	private Integer categoryId;		// 分类ID
	private String title;			// 新闻标题
	private String content;			// 新闻内容
	private String image;			// 新闻大图地址
	private String visitors;		// 点击量
	private String createTime;		// 创建时间
	private String modifyTime;		// 状态变动时间
}
