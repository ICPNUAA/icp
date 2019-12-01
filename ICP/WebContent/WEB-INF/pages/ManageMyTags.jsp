<%@ page import="icp.web.UI.ManageMyTagsUI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理我的标签</title>
<style type="text/css">
body {
	background-color: #B0C4DE;
	background-image: -webkit-gradient(linear, left top, right bottom, from(#00CACA),
		to(#B0C4DE));
}

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

.text2 {
	display: block;
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(255, 255, 255, 0.6);
	width: 300px;
	height: 100px;
	color: #333;
	font-size: 20px;
	font-weight: 700px;
	font-family: Courier;
	margin-bottom: 5px;
	z-index
	=1;
}

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
		style="font-size: 45px; font-family: Courier; text-align: center; color: white;">管理我的个人标签</h1>
	<div style="text-align: center;font-size: 25px;">
		<h5>我的标签：</h5>
		<table border="1px" align="center">
			<%=ManageMyTagsUI.ShowMyTags(session.getAttribute("userID").toString()) %>
		</table>
	</div>
	<div style="text-align: center;font-size: 25px;">
		<h5>添加标签（一次限添加一个）：</h5>
		<form action="/ICP/AddUserTag">
			<input type="text" placeholder="输入想添加的标签名" name="newTagName">
			<input type="submit" value="确认添加">
		</form>
	</div>
</body>
</html>