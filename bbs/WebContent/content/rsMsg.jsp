<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../elements/head.jsp"  %>
<link type="text/css" rel="stylesheet" href="../css/sms.css" />
<c:remove var="error"/>
 <body>
 <form action="remsg?uname=${sessionScope.name }" method="post" onsubmit="return check()">
	<div id="main">
		<div class="mainbox">			
			<div class="menu">
				<span>当前用户：<a href="mian.jsp">${sessionScope.name}</a></span>
				<span><a href="rsMsg.jsp">发短消息</a></span>
				<span><a href="loginout">退出</a></span>
			</div>
			<div class="content">
				<div class="message">
					
						<div class="tmenu">
							<ul class="clearfix">
								<li>
									发送给：
									<select name="toUser">
									  <c:if test="${!empty param.sendTo }">
						  	 			<option>${param.sendTo }</option>
						  	 		  </c:if>
						  	 		   <c:if test="${empty param.sendTo }">
						  	 			<c:forEach items="${sessionScope.usersname }" var="u">
						  	 			<option>${u.uname }</option>
						  	 			</c:forEach>
						  	 		  </c:if>
						  	 		</select>
								</li>								
								<li>标题：<input type="text" name="title" id="title"/></li>
							</ul>
						</div>
						<div class="view">
							<textarea name="content" id="content"></textarea>
							<div class="send"><input type="submit" name="submit" value=" " /></div>
						</div>
					
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>