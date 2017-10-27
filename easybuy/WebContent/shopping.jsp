<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<!-- <script type="text/javascript" src="js/jquery-3.1.1.js"></script> -->
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="shopping.jap" class="shopping">购物车X件</a><a href="login.jsp">登录</a><a href="register.jap">注册</a><a href="guestbook.jap">留言</a><a href="manage/index.jap">后台管理</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jap">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="address.jsp">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				
				<c:forEach var="car" items="${cList }">
				<tr id="product_id_0">
					<td class="thumb"><img src="images/product/0.jpg" /><a href="product-view.jsp"><c:out value="${car.g_name}"></c:out></a></td>
					<td class="price" id="price_id_0">
						<span>￥<c:out value="${car.max*car.g_price }"></c:out></span>
					</td>
					<td class="number">
                        <span name="del">-</span>
                        <input type="text" value="${car.max }" onchange="checkName(this,${car.g_id },${car.max });"/>
                        <span name="add">+</span>
					</td>
					<td class="delete"><a href="javascript:del(${car.g_id});">删除</a></td>
				</tr>
				</c:forEach>
				</table>
			<div class="total"><span>总价：￥ ${total }</span></div>
			<div class="button"><input type="submit" value="" /></div>
		</form>
		
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
		
		function del(id){
			if(confirm("你确定要删除吗？")){
				location.href="CarServlet?opr=del&id="+id;
			}
		}
		
		function checkName(input,id,oldNum){
			var number = input.value;
			alert("新数量："+number);
			alert("旧数量："+oldNum); 
			
			 //判断是否是正整数
			
			if(number < 0 || number != parseInt(number)){
				alert("请输入正整数！！");
				input.value = oldNum;
				return;
			}
			
			var b = window.confirm("确定要修改数量");
			if(b){
					if(number < oldNum){
						window.location.href="NumAjaxServlet?id="+id+"&num="+number;
					}
					if(number > oldNum){
						window.location.href="NumAddServlet?id="+id+"&num="+number+"&oldNum="+oldNum;
					}
			}
			
			/* $.ajax({
				url:"NumAjaxServlet",
				method:"get",
				async:true,
				data:"num="+number+"&id="+id,
				dataType:"text",
				success:function(data){
					if(data != -1){
						alter("修改成功！");
					}else{
						alter("修改失败！");
					}
					return;
				},
				error:function(data){
					   bl = 13;
					   alert("错误");
					   return;
				   }	 
			
			}); */
		}
	</script>
</div>
<div id="footer">
	Copyright &copy; 2013云和学院 All Rights Reserved. 京ICP证1000001号</div>
</body>
<c:remove var="cList" />
<c:remove var="total" />
</jsp>
