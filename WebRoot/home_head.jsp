<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新闻首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
</head>
<body>
<div id="head" class="layui-fluid">
	<div class="layui-row">
		<div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
			<img src="${pageContext.request.contextPath }/images/logo.png">
		</div>
		<div class="layui-col-xs6 layui-col-sm6 layui-col-md6">
			<input type="text">
    		<span>
    			<button>查询</button>
    		</span>
		</div>
	</div>
    <div id="newsType" class="layui-row">
    	<ul class="layui-nav layui-bg-green" lay-filter="">
  			<li class="layui-nav-item">
  				<a href="${pageContext.request.contextPath }/HomeServlet">首页</a>
  			</li>
	    	<c:forEach items="${newsCategoryList }" var="categoryMap">
	    		<li class="layui-nav-item">
	    			<a href="${pageContext.request.contextPath }/NewsServlet?categoryId=${categoryMap.get('id') }&action=getNewsByCategory">${categoryMap.get('name') }</a>
	    		</li>
			</c:forEach>
  		</ul>
    </div>
</div>
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
</body>
</html>