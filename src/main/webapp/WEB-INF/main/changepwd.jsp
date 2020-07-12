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
<title>修改密码-CRM</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/css.css" />
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.3.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="<%=path%>/static/img/coin02.png" />
				<span><a href="#" id="sy">首页</a>&nbsp;-&nbsp;<a href="#">系统管理</a>&nbsp;-</span>&nbsp;修改密码
			</div>
		</div>
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;管理员UID：&nbsp;&nbsp;&nbsp;&nbsp;${user.id}
				</div>
				<div class="bbD">
					管理员用户名：&nbsp;&nbsp;&nbsp;&nbsp;${user.userName}
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;输入旧密码：
					<input type="password" class="input3" onblur="checkpwd1()" id="pwd1" />
					<img class="imga" src="<%=path%>/static/img/ok.png" />
					<img class="imgb" src="<%=path%>/static/img/no.png" />
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;输入新密码：
					<input type="password" class="input3" onblur="checkpwd2()" id="pwd2" />
					<img class="imga" src="<%=path%>/static/img/ok.png" />
					<img class="imgb" src="<%=path%>/static/img/no.png" />
				</div>
				<div class="bbD">
					再次确认密码：
					<input type="password" class="input3" onblur="checkpwd3()" id="pwd3" />
					<img class="imga" src="<%=path%>/static/img/ok.png" />
					<img class="imgb" src="<%=path%>/static/img/no.png" />
				</div>
				<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" href="#">提交</button>
						<a class="btn_ok btn_no" href="#">取消</a>
					</p>
				</div>
			</div>

			<!-- 修改密码页面样式end -->
		</div>
	</div>
</body>
<script type="text/javascript">
function checkpwd1(){
var user = document.getElementById('pwd1').value.trim();
 if (user.length >= 6 && user.length <= 12) {
  $("#pwd1").parent().find(".imga").show();
  $("#pwd1").parent().find(".imgb").hide();
 }else{
  $("#pwd1").parent().find(".imgb").show();
  $("#pwd1").parent().find(".imga").hide();
 };
}
function checkpwd2(){
var user = document.getElementById('pwd2').value.trim();
 if (user.length >= 6 && user.length <= 12) {
  $("#pwd2").parent().find(".imga").show();
  $("#pwd2").parent().find(".imgb").hide();
 }else{
  $("#pwd2").parent().find(".imgb").show();
  $("#pwd2").parent().find(".imga").hide();
 };
}
function checkpwd3(){
var user = document.getElementById('pwd3').value.trim();
var pwd = document.getElementById('pwd2').value.trim();
 if (user.length >= 6 && user.length <= 12 && user == pwd) {
  $("#pwd3").parent().find(".imga").show();
  $("#pwd3").parent().find(".imgb").hide();
 }else{
   $("#pwd3").parent().find(".imgb").show();
  $("#pwd3").parent().find(".imga").hide();
 };
}

$("#sy").click(function(){
    window.top.location.href="${path}/jsp/index";
});
</script>
</html>