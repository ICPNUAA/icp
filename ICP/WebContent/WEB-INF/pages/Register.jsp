<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>用户注册页面</title>
<style type="text/css">
body {
	background-color: #B0C4DE;
	background-image: -webkit-gradient(linear, left top, right bottom, from(#00CACA),
		to(#B0C4DE));
}
/*文本框格式*/
.text {
	display: block;
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(255, 255, 255, 0.6);
	width: 300px;
	height: 40px;
	color: #333;
	font-size: 20px;
	font-weight: 700px;
	font-family: Courier;
	margin-bottom: 5px;
	z-index
	=1;
}

.text:hover {
	background: rgba(255, 255, 255, 0.9);
	opacity: 1;
	transition: width 0.5s, margin-left 0.5s;
	transition: transform linear 1s;
}
/*按钮格式*/
.login {
	display: block;
	border: 1px solid rgba(255, 255, 255, 1);
	background: rgba(255, 255, 255, 0.6);
	border-radius: 0.2em;
	width: 302px;
	height: 40px;
	color: #333;
	font-size: 18px;
	font-weight: 700px;
	margin-left: 550 px;
	margin-bottom: 5px; z-index =1;
	font-family: Courier;
	transition: width 0.5s, margin-left 0.5s;
	-webkit-appearance: button;
}

.login:hover {
	cursor: pointer;
	opacity: 1;
	background: rgba(255, 255, 255, 0.9);
}
</style>
</head>
<body>
	<h1
		style="font-size: 45px; font-family: Courier; text-align: center; color: white;">SIGN
		IN</h1>


	<form action="${pageContext.request.contextPath}/Register"
		method="post">
		<table border="0px" align="center">
			<!-- 输入用户名 -->
			<tr height="35px">
				<td>用户名</td>
				<td width="400px"><input type="text" name="userID" id="uname"
					class="text" /></td>
			</tr>
			<!-- 输入密码栏 -->
			<tr height="35px">
				<td>密码：</td>
				<td><input type="password" name="password" id="pwd"
					class="text" /></td>
			</tr>
			<!-- 输入密码栏 -->
			<tr height="35px">
				<td>请再次输入密码：</td>
				<td><input type="password" name="password2" id="pwd2"
					class="text" /></td>
			</tr>
			<!-- 输入姓名 -->
			<tr height="35px">
				<td>真实姓名：</td>
				<td><input type="text" name="realName" id="pwd2"
					class="text" /></td>
			</tr>
			<!-- 输入密码栏 -->
			<tr height="35px">
				<td>学号：</td>
				<td><input type="text" name="studentNumber" id="pwd2"
					class="text" /></td>
			</tr>

			<!--按钮-->
			<tr>
				<td colspan="2" align="center"><input type="submit" id=""
					value="注册" class="login" style="margin-left: -25px" /></td>

			</tr>
		</table>
	</form>
</body>
</html>