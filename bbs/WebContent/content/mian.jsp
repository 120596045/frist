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
				<span>当前用户：<a href="mian.jsp">${sessionScope.name}</a></span> <span><a
					href="rsMsg.jsp">发短消息</a></span> <span><a href="loginout">退出</a></span>
			</div>
			<!-- 错误信息 -->
			<%-- <div id="error">${error}</div> --%>
			<div class="content messageList">
				<ul>
					<!-- 显示当前用户的消息
                     1.判断是否有信息对象,如果没有取控制层取
                     -->
					<c:if test="${empty msgObject }">
						<jsp:forward page="msgObject">
							<jsp:param value="msg" name="opr" />
						</jsp:forward>
					</c:if>
					<c:forEach var="m" items="${msgObject}">
						<c:if test="${m.state == 0}">
							<li class="unReaded">
						</c:if>
						<c:if test="${m.state == 1}">
							<li>
						</c:if>
						<!-- 标题 -->
						<strong><a href="read?msgId=${m.msgId}"><c:out value="${m.title}" /></a></strong> &nbsp;
						<!-- 内容 -->
						<c:if test="${fn:length(m.msgContent) > 8}">
							<c:out value="${fn:substring(m.msgContent,0,7)}......" />
						</c:if>

						<c:if test="${fn:length(m.msgContent) <= 8}">
							<c:out value="${m.msgContent}" />
						</c:if>
						<em><c:out value="${m.msgCreateDate}" /></em>
						<em><a href="rsMsg.jsp?sendTo=${m.sendTo }">回信</a></em>
						<em><a href="romove?id=${m.msgId}">删除</a></em>
					</c:forEach>
				</ul>
			</div>
		</div>
		
	<c:if test="${!empty error }">
	<script type="text/javascript">
	 alert("${error}");
	 <c:remove var="error"/>
	</script>
	</c:if>	
   
	<!-- 移除msgObject对象，保证每次到达该页面的数据都是最新的 -->
	<c:remove var="msgObject"/>
	
</body>
</html>