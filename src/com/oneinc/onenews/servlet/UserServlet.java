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
		Map<String, String[]> parameterMap = request.getParameterMap();		// 获取注册用户参数
		User user = new User();
		// 将请求参数转换为对象
		try {
			BeanUtils.populate(user, parameterMap);
			// 密码MD5加密
			String password = CommonUtil.md5(user.getUsername() + user.getPassword());
			user.setPassword(password);
			user.setRoleId(1);
			UserService userService = new UserService();
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "HomeServlet";
	}
}
