<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String imgPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/img/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页左侧导航</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/public.css" />
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/public.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head></head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">
		<div class="leftsidebar_box">
			<c:forEach items="${permissions}" var="cart">
				<c:if test="${cart.permissionName=='首页'}">
					<a href="<%=path%>${cart.permissionSrc}" target="main">
						<div class="line">
							<img src="<%=path%>/static/img/coin01.png" />&nbsp;&nbsp;${cart.permissionName}
						</div>
					</a>
				</c:if>
				<c:if test="${cart.permissionName!='首页'}">
					<dl class="system_log">
						<dt>
							<img class="icon1" src="<%=path%>/static/img/${cart.permissionClass}" />
							<img class="icon2" src="<%=path%>/static/img/${cart.permissionImg}" /> ${cart.permissionName}
							<img class="icon3" src="<%=path%>/static/img/coin19.png" />
							<c:if test="${cart.childrens.size()>0}">
								<img class="icon4" src="<%=path%>/static/img/coin20.png" />
							</c:if>
						</dt>
						<c:if test="${cart.childrens.size()>0}">
							<c:forEach items="${cart.childrens}" var="children">
								<dd>
									<img class="coin11" src="<%=path%>/static/img/coin111.png" />
									<img class="coin22" src="<%=path%>/static/img/coin222.png" />
									<c:if test="${children.permissionName!='退出'}">
										<a class="cks" href="<%=path%>${children.permissionSrc}" target="main">${children.permissionName}</a>
									</c:if>
									<c:if test="${children.permissionName=='退出'}">
										<a class="cks" href="#" id="tc">${children.permissionName}</a>
									</c:if>
									<img class="icon5" src="<%=path%>/static/img/coin21.png" />
								</dd>
							</c:forEach>
						</c:if>
					</dl>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
    $("#tc").click(function(){
        if (confirm("是否退出登录!")) {
            window.top.location.href="${path}/jsp/login";
        }
    });
</script>
