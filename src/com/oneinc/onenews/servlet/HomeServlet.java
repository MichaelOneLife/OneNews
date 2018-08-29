package com.oneinc.onenews.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oneinc.onenews.service.NewsService;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		NewsService newsService = new NewsService();
		List<Map<String, Object>> newsCategoryList = newsService.getNewsCategory();
		List<Map<String, Object>> publishedNewsList = newsService.getPublishedNews();
		HttpSession session = request.getSession();
		session.setAttribute("newsCategoryList", newsCategoryList);
		request.setAttribute("publishedNewsList", publishedNewsList);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
