<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../elements/head.jsp"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" rel="stylesheet" href="../css/sms.css" />
<html>
  <head>    
    <title>读短消息</title>	    
  </head>
	<body>
		<div id="main">
			<div class="mainbox">
				<div class="title readMessage png"></div>
				<div class="menu">
					<span>当前用户：<a href="mian.jsp">${sessionScope.name}</a></span>
					<span><a href="content/rsMsg.jsp">发短消息</a></span>
					<span><a href="loginout">退出</a></span>
				</div>
				<div class="content">
					<div class="message">
				      
							<div class="tmenu">
								<ul class="clearfix">
									<li>题目：${sessionScope.messageById.title } </li>
									<li>来自：${sessionScope.messageById.sendTo}</li>
									<li>时间：${sessionScope.messageById.msgCreateDate }</li>									
								</ul>
							</div>
					  	 	<div class="view">
								<p>${sessionScope.messageById.msgContent }</p>
							</div>
				  	 	
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
