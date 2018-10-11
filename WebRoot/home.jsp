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
	<div id="body" class="layui-fluid">
		<div class="layui-row layui-col-space10">
			<div class="layui-col-xs2 layui-col-sm2 layui-col-md2">
			</div>
			<div class="layui-col-xs7 layui-col-sm7 layui-col-md7">
				<c:forEach items="${publishedNewsList }" var="newsMap">
					<div>
						<a href="${pageContext.request.contextPath }/NewsServlet?id=${newsMap.get('id')}&action=getNewsDetail" target="_blank">${newsMap.get("title") }</a>
					</div>
				</c:forEach>
			</div>
			<div class="layui-col-xs3 layui-col-sm3 layui-col-md3">
			</div>
		</div>
	</div>
	<div id="foot"></div>
	
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script> --%>
	<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>