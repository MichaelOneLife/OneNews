package com.oneinc.onenews.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.oneinc.onenews.entity.User;
import com.oneinc.onenews.service.UserService;
import com.oneinc.onenews.util.CommonUtil;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户注册
	 */
	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phoneNum = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String psdCheck = request.getParameter("psdCheck");
		
		if (!password.equals(psdCheck)) {
			return "";
		}
		
		User user = new User();
		// 将请求参数转换为对象
		try {
			user.setPhone(phoneNum);
			user.setUsername(username);
			user.setPassword(CommonUtil.md5(password));		// 密码MD5加密
			user.setRoleId(1);
			UserService userService = new UserService();
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HomeServlet";
	}
	
	/**
	 * 用户登录
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phoneNum = request.getParameter("phone");
		String password = request.getParameter("password");
		User user = new User();
		UserService userService = new UserService();
		// 将请求参数转换为对象
		try {
			user = userService.getUserByPhone(phoneNum);
			password = CommonUtil.md5(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!password.equals(user.getPassword())) {
			return "";
		}
		return "HomeServlet";
	}
	
	public String modifyUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		UserService userService = new UserService();
		// 将请求参数转换为对象
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HomeServlet";
	}
}
