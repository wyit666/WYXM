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
<title>头部-CRM</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/public.css" />
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/public.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
</head>

<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<img class="headLogo" src="<%=path%>/static/img/headLogo.png" />
		</div>
		<div class="headR">
			<p class="p1">
				欢迎,${user.userName}
			</p>
			<p class="p2">
				<a href="#" class="resetPWD">重置密码</a>&nbsp;&nbsp;
				<a href="#" class="goOut">退出</a>
			</p>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
</script>