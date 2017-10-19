<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>短消息平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
</head>
<body>
<div id="loginTitle" class="png"></div>
<div id="loginForm" class="userForm png">
	<form method="post" name="loginform" action="login?action=login" onsubmit = "return check()">		
		<dl>			
			<div id="error">${msg}</div>
			<dt>用户名：</dt>
			<dd><input type="text" name="username" value="${param.username}"/></dd>
			<dt>密　码：</dt>
			<dd><input type="password" name="password" /></dd>
		</dl>
		<div class="buttons">
			<input class="btn-login png" type="submit" name="submit" value=" " />
			<input class="btn-reg png" type="button" name="register"  value=" " />
		</div>
	</form>
</div>

<c:remove var="msg"/>
<script type="text/javascript">
 $(function(){
	$(".btn-reg").bind("click",function(){
		window.location.href="register.jsp";
	});
}); 

</script>
<%-- <%=new Date(new Date().getTime()) %> --%>

</body>
</html>