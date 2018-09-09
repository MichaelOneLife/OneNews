package com.oneinc.onenews.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

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
		News news = null;
		try {
			news = newsService.getNewsDetail(newsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		List<Map<String, Object>> categoryNewsList = null;
		try {
			categoryNewsList = newsService.getNewsByCategory(categoryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("categoryNewsList", categoryNewsList);
		return "category_news.jsp";
	}
	
	/**
	 * 新增新闻
	 */
	public String addNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();		// 获取新增新闻参数
		News news = new News();
		// 将新闻请求参数转换为对象
		try {
			BeanUtils.populate(news, parameterMap);
			news.setUserId(3);
			news.setStateId(3);
			news.setVisitors("0");
			NewsService newsService = new NewsService();
			newsService.addNews(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HomeServlet";
	}
	
	/**
	 * 删除新闻
	 */
	public String deleteNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String newsId = request.getParameter("newsId");
		NewsService newsService = new NewsService();
		try {
			newsService.updateNewsState(newsId, "4");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "HomeServlet";
	}
}
