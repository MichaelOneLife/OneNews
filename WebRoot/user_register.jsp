<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>新闻首页</title>
</head>
<body>
	<div id="body">
		<form action="${pageContext.request.contextPath }/UserServlet">
			<div>
				手机号：
				<input type="text" name="phone" />
			</div>
			<div>
				密码：
				<input type="password" name="password" />
			</div>
			<div>
				确认密码：
				<input type="password" name="psdCheck" />
			</div>
			<div>
				昵称：
				<input type="text" name="username" />
			</div>
			<div>
				<input type="hidden" name="action" value="register">
				<input type="button" id="btn_submit" value="提交" />
			</div>
		</form>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#btn_submit").on("click", function() {
				$("form").submit();
			});
		});
	</script>
</body>
</html>