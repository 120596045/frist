<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>

	<c:if test="${empty pageMessage}">
		<jsp:forward page="manageServlet">
			<jsp:param value="managepage" name="opr" />
		</jsp:forward>
	</c:if> 
	
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li class="current"><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="user.jsp">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="productClass.jsp">分类管理</a></dd>
				<dd><em><a href="product-add.jsp">新增</a></em><a href="product.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.jsp">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageMessage.pageObj}" var="n">
						<tr>
							<td class="first w4 c">${n.m_id}</td>
							<td class="w1 c">${n.u_name}</td>
							<td>${n.m_content}</td>
							<td class="w1 c">${n.m_state}</td>
							<td class="w1 c"><a href="manageServlet?id=${n.m_id}&name=${n.u_name}&content=${n.m_content}&opr=modify">回复</a>
				<a class="manageDel" href="manageServlet?opr=delete&id=${n.m_id}">删除</a></td>
						</tr>
					</c:forEach>
				</table>


				<div class="pager">
					<ul class="clearfix">

						<c:if test="${pageMessage.pageIndex > 1 }">
							<li><a href="manageServlet?opr=managepage&j=1">首页</a></li>
							<li><a
								href="manageServlet?opr=managepage&j=${pageMessage.pageIndex-1}">上一页</a></li>
						</c:if>

                        <c:if test="${pageMessage.pageIndex == 1 }">
                             <li>首页</li> 
                             <li>上一页</li> 
                        </c:if>

                        <c:if test="${pageMessage.pageIndex == pageMessage.pageTotal}">
                            <li>下一页</li>
                            <li>尾页</li>
                        </c:if>

						<c:if test="${pageMessage.pageIndex < pageMessage.pageTotal }">
							<li><a
								href="manageServlet?opr=managepage&j=${pageMessage.pageIndex+1}">下一页</a></li>
							<li><a
								href="manageServlet?opr=managepage&j=${pageMessage.pageTotal }">尾页</a></li>
						</c:if>
						<li>[ ${pageMessage.pageIndex } / ${pageMessage.pageTotal } ]</li>
					</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<c:remove var="pageMessage"/> 
</html>