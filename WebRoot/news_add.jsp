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
		<form action="${pageContext.request.contextPath }/NewsServlet">
			<div>
				标题：
				<input type="text" name="title" />
			</div>
			<div>
				类别：
				<select name="categoryId">
					<option value="1">社会</option>
					<option value="2">娱乐</option>
					<option value="3">体育</option>
					<option value="4">军事</option>
				</select>
			</div>
			<div>
				内容：
				<input type="text" name="content" />
			</div>
			<div>
				<input type="hidden" name="action" value="addNews">
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