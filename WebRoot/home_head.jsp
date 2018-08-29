<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新闻首页</title>
</head>
<body>
<div id="head">
    <div id="logo">
    	<img src="${pageContext.request.contextPath }/images/logo.png">
    	<div>
    		<input type="text">
    		<span>
    			<button>查询</button>
    		</span>
    	</div>
    </div>
    <div id="newsType">
    	<c:forEach items="${newsCategoryList }" var="categoryMap">
    		<a href="${pageContext.request.contextPath }/CategoryNewsServlet?categoryId=${categoryMap.get('id') }">${categoryMap.get('name') }</a>
		</c:forEach>
    </div>
</div>
</body>
</html>