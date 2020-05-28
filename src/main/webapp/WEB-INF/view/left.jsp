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
<head></head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">
		<div class="leftsidebar_box">
			<%--<a href="<%=path%>/jsp/main" target="main">
				<div class="line">
					<img src="<%=path%>/static/img/coin01.png" />&nbsp;&nbsp;首页
				</div>
			</a>--%>
			 <%--<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin01.png" />
					<img class="icon2"src="<%=path%>/static/img/coin02.png" />首页
					<img class="icon3" src="<%=path%>/static/img/coin19.png" />
					<img class="icon4" src="<%=path%>/static/img/coin20.png" />
				</dt>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin03.png" />
					<img class="icon2" src="<%=path%>/static/img/coin04.png" /> 网站管理
					<img class="icon3" src="<%=path%>/static/img/coin19.png" />
					<img class="icon4" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a class="cks" href="<%=path%>/jsp/user" target="main">管理员管理</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>--%>
		</div>
	</div>
</body>
<script type="text/javascript">
    /*$(".leftsidebar_box")
		.append("<dl class='system_log'>")
			.append("<dt>")
				.append("<img class='icon1' src='<%=path%>/static/img/coin03.png'/>")
				.append("<img class='icon2' src='<%=path%>/static/img/coin04.png'/>").append("网站管理")
				.append("<img class='icon3' src='<%=path%>/static/img/coin19.png'/>")
				.append("<img class='icon4' src='<%=path%>/static/img/coin20.png'/>")
        	.append("</dt>")
		.append("</dl>")*/
</script>
</html>
