package com.oneinc.onenews.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneinc.onenews.entity.News;
import com.oneinc.onenews.service.NewsService;

@WebServlet("/NewsDetailServlet")
public class NewsDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String newsId = request.getParameter("id");
		NewsService newsService = new NewsService();
		News news = newsService.getNewsDetail(newsId);
		request.setAttribute("news", news);
		request.getRequestDispatcher("news_detail.jsp").forward(request, response);
	}

}
