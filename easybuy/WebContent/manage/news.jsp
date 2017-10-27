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
     <!-- 判断对象是否为空，若果为空则跳转控制器PageServlet，传参opr值pages -->
	 <c:if test="${empty pageObjns}">
		<jsp:forward page="PageServlet">
			<jsp:param value="pages" name="opr" />
		</jsp:forward>
	</c:if> 
	
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.html">用户</a></li>
			<li><a href="product.html">商品</a></li>
			<li><a href="order.html">订单</a></li>
			<li><a href="guestbook.html">留言</a></li>
			<li class="current"><a href="news.html">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="user.html">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="productClass-add.html">新增</a></em><a href="productClass.html">分类管理</a></dd>
				<dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.html">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.html">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.html">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>新闻管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>新闻标题</th>
					<th>操作</th>
				</tr>
							<c:forEach items="${pageObjns.pageObj }" var="n" varStatus="s">
						<tr
							<c:if test="${s.index %2==0 }">style="background-color:pink"</c:if>>
							<td>${n.n_id }</a></td>
							<td>${n.n_title }</a></td>

							<td><a href="../NewsServlet?opr=toUpdate&id=${n.n_id }">修改</a>
								&nbsp;&nbsp;<a href="javascript:void(0)" onclick="del(${n.n_id });">删除</a></td>

						</tr>
					</c:forEach>
				</table>
				<div class="pages" style="margin: 0 auto; text-align: center;">
					【${pageObjns.pageIndex }/${pageObjns.pageTotal }】
					<c:if test="${pageObjns.pageIndex>1 }">
						<a href="PageServlet?opr=pages&i=1">首页</a>&nbsp;
			    <a href="PageServlet?opr=pages&i=${pageObjns.pageIndex-1 }">上一页</a>&nbsp;
			</c:if>

					<c:if test="${pageObjns.pageIndex<pageObjns.pageTotal }">
						<a href="PageServlet?opr=pages&i=${pageObjns.pageIndex+1 }">下一页</a>&nbsp;
				<a href="PageServlet?opr=pages&i=${pageObjns.pageTotal }">尾页</a>
					</c:if>
				</div>
			</div>

		</div>
		<div class="clear"></div>
	</div>
	<c:remove var="pageObjns" />
<div id="footer">
	Copyright &copy; 2013 云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<script>
function del(id){
	if(confirm("确定要删除吗？")){
		location.href="../NewsServlet?id="+id+"&opr=del";
	}
}
</script>
</html>