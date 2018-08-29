<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>新闻首页</title>
</head>
<body>
	<div id="head">
		<jsp:include page="/home_head.jsp"></jsp:include>
	</div>
	<div id="body">
		<ul>
			<c:forEach items="${publishedNewsList }" var="newsMap">
				<li>
					<a href="${pageContext.request.contextPath }/NewsDetailServlet?id=${newsMap.get('id')}" target="_blank">${newsMap.get("title") }</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div id="foot"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>