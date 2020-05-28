<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
		   pageEncoding="UTF-8"%>
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
<title>欢迎某某CRM</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/public.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/static/css/page.css" />
<%--<script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>--%>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/public.js"></script>
</head>
<body>

	<!-- 登录页面头部 -->
	<div class="logHead">
		<img src="<%=path%>/static/img/logLOGO.png" />
	</div>
	<!-- 登录页面头部结束 -->

	<!-- 登录body -->
	<div class="logDiv">
		<img class="logBanner" src="<%=path%>/static/img/logBanner.png" />
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">登录</p>
				<p class="p2">人员登录</p>
			</div>
			<!-- 输入框 -->
			<form id="login_form">
				<div class="lgD">
					<img class="img1" src="<%=path%>/static/img/logName.png" />
					<input type="text" placeholder="输入用户名" name="userCode"/>
				</div>
				<div class="lgD">
					<img class="img1" src="<%=path%>/static/img/logPwd.png" />
					<input type="text" placeholder="输入用户密码" name="userPassword"/>
				</div>
			</form>
			<%--<div class="lgD logD2">
				<input class="getYZM" type="text" />
				<div class="logYZM">
					<img class="yzm" src="<%=path%>/static/img/logYZM.png" />
				</div>
			</div>--%>
			<div class="logC">
				<button onclick="login()">登 录</button>
			</div>
		</div>
	</div>
	<!-- 登录body  end -->

	<!-- 登录页面底部 -->
	<div class="logFoot">
		<p class="p1">版权所有：XXXX网络科技有限公司</p>
		<p class="p2">XXXX网络科技有限公司 登记序号：XXXX备XXXXXXXX号-X</p>
	</div>
	<!-- 登录页面底部end -->
</body>

<script type="text/javascript">
    function login(){
        $.ajax({
            url:"<%=path%>/login/login",
            type:"post",
            data:$("#login_form").serialize(),
            dataType:"json",
            success:function(data){
                if(data.success=="true"){
                    alert(data.return);
                    location.href="<%=path%>/jsp/index"
                }else{
                    alert(data.return);
                }
            },
            error:function(){
                alert("系统错误!")
            }
        });
	}
</script>
</html>