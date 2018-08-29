<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>新闻详情</title>
</head>
<body>
	<div id="head">
		<jsp:include page="/home_head.jsp"></jsp:include>
	</div>
	<div id="body">
		<div>
			<h1>${news.title }</h1>
		</div>
		<div>
			<img src="${pageContext.request.contextPath }/${news.image }">
		</div>
		<div>${news.content }</div>
	</div>
	<div id="foot"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>