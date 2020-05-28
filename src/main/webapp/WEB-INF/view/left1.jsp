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
			<a href="<%=path%>/jsp/main" target="main">
				<div class="line">
					<img src="<%=path%>/static/img/coin01.png" />&nbsp;&nbsp;首页
				</div>
			</a>
			<!-- <dl class="system_log">
			<dt><img class="icon1" src="../img/coin01.png" /><img class="icon2"src="../img/coin02.png" />
				首页<img class="icon3" src="../img/coin19.png" /><img class="icon4" src="../img/coin20.png" /></dt>
		</dl> -->
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
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin05.png" />
					<img class="icon2" src="<%=path%>/static/img/coin06.png" /> 公共管理
					<img class="icon3" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a class="cks" href="<%=path%>/jsp/banner" target="main">广告管理</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a class="cks" href="<%=path%>/jsp/opinion" target="main">意见管理</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin07.png" />
					<img class="icon2" src="<%=path%>/static/img/coin08.png" /> 会员管理
					<img class="icon3" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a href="<%=path%>/jsp/vip" target="main" class="cks">会员管理</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin10.png" />
					<img class="icon2" src="<%=path%>/static/img/coin09.png" /> 行家管理
					<img class="icon3" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a href="<%=path%>/jsp/connoisseur" target="main" class="cks">行家管理</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin11.png" />
					<img class="icon2" src="<%=path%>/static/img/coin12.png" /> 话题管理
					<img class="icon3" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a href="<%=path%>/jsp/topic" target="main" class="cks">话题管理</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin14.png" />
					<img class="icon2" src="<%=path%>/static/img/coin13.png" /> 心愿管理
					<img class="icon3" src="<%=path%>/static/img/coin19.png" />
					<img class="icon4" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a href="<%=path%>/jsp/wish" target="main" class="cks">心愿管理</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin15.png" />
					<img class="icon2" src="<%=path%>/static/img/coin16.png" /> 约见管理
					<img class="icon3" src="<%=path%>/static/img/coin19.png" />
					<img class="icon4" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a href="<%=path%>/jsp/appointment" target="main" class="cks">约见管理</a>
					<img class="icon5"  src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coin17.png" />
					<img class="icon2" src="<%=path%>/static/img/coin18.png" /> 收支管理
					<img class="icon3" src="<%=path%>/static/img/coin19.png" />
					<img class="icon4" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a href="<%=path%>/jsp/balance" target="main" class="cks">收支管理</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="<%=path%>/static/img/coinL1.png" />
					<img class="icon2" src="<%=path%>/static/img/coinL2.png" /> 系统管理
					<img class="icon3" src="<%=path%>/static/img/coin19.png" />
					<img class="icon4" src="<%=path%>/static/img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a href="<%=path%>/jsp/changepwd" target="main" class="cks">修改密码</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="<%=path%>/static/img/coin111.png" />
					<img class="coin22" src="<%=path%>/static/img/coin222.png" />
					<a class="cks">退出</a>
					<img class="icon5" src="<%=path%>/static/img/coin21.png" />
				</dd>
			</dl>
		</div>
	</div>
</body>
</html>
