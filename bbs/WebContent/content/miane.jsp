<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../elements/head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link type="text/css" rel="stylesheet" href="../css/sms.css" />
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<div class="menu">
				<span>当前用户：<a href="main.jsp">${sessionScope.name}</a></span> <span><a
					href="rsMsg.jsp">发短消息</a></span> <span><a href="loginout">退出</a></span>
			</div>
			<!-- 错误信息 -->
			<%-- <div id="error">${error}</div> --%>
			<div class="content messageList">
				<ul>
                  <p>
                  <strong>用户无信息</strong>
                  </p>
				</ul>
			</div>
		</div>

</body>
</html>