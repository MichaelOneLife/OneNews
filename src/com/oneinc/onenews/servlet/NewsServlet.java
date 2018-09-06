package com.oneinc.onenews.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneinc.onenews.entity.News;
import com.oneinc.onenews.service.NewsService;

@WebServlet("/NewsServlet")
public class NewsServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 根据新闻ID获取新闻详情
	 */
	public String getNewsDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newsId = request.getParameter("id");
		NewsService newsService = new NewsService();
		News news = newsService.getNewsDetail(newsId);
		request.setAttribute("news", news);
		return "news_detail.jsp";
	}
	
	/**
	 * 根据新闻分类获取新闻列表
	 */
	public String getNewsByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryId = request.getParameter("categoryId");
		NewsService newsService = new NewsService();
		List<Map<String, Object>> categoryNewsList = newsService.getNewsByCategory(categoryId);
		request.setAttribute("categoryNewsList", categoryNewsList);
		return "category_news.jsp";
	}
}
