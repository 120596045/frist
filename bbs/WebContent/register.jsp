<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学士后 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
</head>
<script type="text/javascript">
	
</script>
<body>
<div id="regTitle" class="png"></div>
<div id="regForm" class="userForm png">

	<form action="login?action=regist" onsubmit = "return check()" method="post">
		<dl>
		    <div id="error"> </div>
			<dt>用 户 名：</dt>
			<dd><input type="text" name="username" /></dd>
			<dt>密　　码：</dt>
			<dd><input type="password" name="password" id="pswId"/></dd>
			<dt>确认密码：</dt>
			<dd><input  type="password" name="affirm" id="psdId"/></dd>
			<!-- <dt>邮　　箱：</dt>
			<dd><input type="text" name="email" /></dd> -->
			<dd>${msg }</dd> 
		</dl>
		<div class="buttons">
			<input class="btn-reg png" type="submit" name="register" value=" " />
			<input class="btn-reset png" type="reset" name="reset" value=" " />
		</div>
		<div class="goback"><a href="index.jsp" class="png">返回登录页</a></div>
	</form>
</div>

<script type="text/javascript">

/* 检查验证2次密码是否一致 */
/*   $(function(){
	$(".btn-reg").bind("click", function (){
		var input1 =document.getElementById("pswId").value;
		var input2 =document.getElementById("psdId").value;
		if(input1.value!=""){
			if(input1.value==input2.value){
				return true;
			}else{
				alert("2次密码不一致");
				return false;
			}
		}else{
			alert("密码不能为空");
			return false;
		} 
		return false;
	});
});  */

</script>
</body>
</html>
