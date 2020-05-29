<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String imgPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/img/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页-CRM</title>
</head>
<frameset rows="100,*" cols="*" scrolling="No" framespacing="0" frameborder="no" border="0">
	<!-- 引用头部 -->
	<frame src="<%=path%>/jsp/head" name="headmenu" id="mainFrame1" title="mainFrame">
	<!-- 引用左边和主体部分 -->
	<frameset rows="100*" cols="220,*" scrolling="No" framespacing="0" frameborder="no" border="0">
		<frame src="<%=path%>/jsp/left" name="leftmenu" id="mainFrame2" title="mainFrame">
		<frame src="<%=path%>/jsp/main" name="main" scrolling="yes" noresize="noresize" id="rightFrame3" title="rightFrame">
	</frameset>
</frameset>
</html>