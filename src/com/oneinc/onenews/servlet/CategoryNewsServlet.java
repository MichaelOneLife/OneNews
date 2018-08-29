package com.oneinc.onenews.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneinc.onenews.service.NewsService;

@WebServlet("/CategoryNewsServlet")
public class CategoryNewsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String categoryId = request.getParameter("categoryId");
		NewsService newsService = new NewsService();
		List<Map<String, Object>> categoryNewsList = newsService.getNewsByCategory(categoryId);
		request.setAttribute("categoryNewsList", categoryNewsList);
		request.getRequestDispatcher("category_news.jsp").forward(request, response);
	}

}
