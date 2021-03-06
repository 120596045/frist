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
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li class="current"><a href="news.jsp">新闻</a></li>
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
				<dd><em><a href="user-add.jsp">新增</a></em><a href="user.jsp">用户管理</a></dd>
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
		<h2>修改新闻</h2>
		<div class="manage">
						<form action="../NewsServlet" method="post">
				
				<table class="form">		
					<tr>
						<td class="field">新闻标题：</td>
						<input type="hidden" name="opr" value="update"/>
						<input type="hidden"  name="n_id" value="${objNews.n_id }"/>
						<%-- <td><input type="text" class="text" name="${n.n_title }" value=""></td> --%>
 						<td><input type="text" class="text" name="n_title" value="${objNews.n_title }"/></td>
 					<td></td>
 					</tr>
					<tr>
						<td class="field">新闻内容：</td>
						<%-- <td><textarea name="${n.n_content }" value=""></textarea></td> --%>
						<td><textarea name="n_content" value="">${objNews.n_content }</textarea></td>
					</tr>
					<tr>
						<td class="field">新闻时间：</td>
						
						<td><input type="text" class="text" name="n_create_date" value="${objNews.n_create_date }"></td>
					</tr>
					<tr>
						<td></td>
					 <td><input type="submit" value="提交"/></td> 
						 <!-- <td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td> --> 
					</tr>
			
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>