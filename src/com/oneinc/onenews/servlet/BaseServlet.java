package com.oneinc.onenews.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		
		try {
			Class c = this.getClass();
			Method method = c.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			
			if (method != null) {
				String dispatchPath = (String) method.invoke(this, request, response);
				
				if (dispatchPath != null) {
					request.getRequestDispatcher(dispatchPath).forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
