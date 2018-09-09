package com.oneinc.onenews.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 新闻评论实体类
 * @Author michael
 * @Date 2018年7月14日 下午4:19:23
 */
@Getter@Setter@ToString
public class NewsComment {
	private Integer id;				// 评论ID
	private Integer userId;			// 用户ID
	private Integer newsId;			// 新闻ID
	private Integer replyId;		// 回复评论ID
	private String content;			// 评论内容
	private String createTime;		// 创建时间
}
