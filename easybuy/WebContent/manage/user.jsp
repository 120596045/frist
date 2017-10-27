<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li class="current"><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
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
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<!-- 把查询到东西放到对象里，从对象取得数据放到下边页面 -->
				<c:if test="${empty ObjUser}">
				<jsp:forward page="Manage">
				 <jsp:param value="sall" name="opr"/>
				</jsp:forward>
				</c:if>
				<c:forEach items="${ObjUser.pageObj }" var="u">
				<tr>
					<td class="first w4 c">${u.u_name }</td>
					<td class="w1 c">${u.u_real_name}</td>
					<td class="w2 c">${u.u_sex}</td>
					<td>${u.u_email }</td>
					<td class="w4 c">${u.u_phone }</td>
					<td class="w1 c">
					<a href="user-modify.jsp?u_name=${u.u_name }&u_real_name=${u.u_real_name}
					&u_sex=${u.u_sex}&u_email=${u.u_email}&u_phone=${u.u_phone}">修改</a> &nbsp;<a class="manageDel" href="Manage?opr=del&id=${u.u_id }">删除</a></td>
				</tr>
				</c:forEach>
				

	<!-- 			<tr>
					<td class="first w4 c">jack</td>
					<td class="w1 c">杨二郎</td>
					<td class="w2 c">男</td>
					<td>fengsan.zhang@prd.com</td>
					<td class="w4 c">13888888888</td>
					<td class="w1 c"><a href="user-modify.html">修改</a> <a class="manageDel" href="javascript:void(0)">删除</a></td>
				</tr> -->
			</table>
		</div>
	</div>
	<div class="clear"></div>
     <div class="pager">
				<ul class="clearfix">	
					    <c:if test="${ObjUser.pageIndex>1}">
							<a href="Manage?opr=sall&pageIndex=1">首页</a>
							<a href="Manage?opr=sall&pageIndex=${ObjUser.pageIndex-1}">上一页</a>
						</c:if>
						<c:if test="${ObjUser.pageIndex<ObjUser.pageTotal}">

							<a href="Manage?opr=sall&pageIndex=${ObjUser.pageIndex+1}">下一页</a>
							<a href="Manage?opr=sall&pageIndex=${ObjUser.pageTotal}">末页</a>
						</c:if>
						当前页数:[${ObjUser.pageIndex}/${ObjUser.pageTotal}]&nbsp;
				</ul>
  </div>
</div>
<div id="footer">
	Copyright &copy; 2013 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<c:remove var="ObjUser"/>
</html>