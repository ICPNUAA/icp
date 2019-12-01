<%@page import="icp.web.UI.IndexUI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆</title>
<style type="text/css">
body {
	background-color: #F0F8FF;
	background-image: -webkit-gradient(linear, left top, right bottom, from(white),
		to(#F0F8FF));
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	background-color: grey;
	text-align: center border: 1px solid #555;
	width: 15%;
	height: 100%; /*  全屏高度 */
	position: fixed;
	overflow: auto; /* 如果导航栏选项多，允许滚动 */
}

a {
	display: block;
	width: 100px;
}

li a {
	display: block;
	color: white;
	padding: 8px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #555;
	color: white;
}

.active {
	background-color: #4CAF50;
	color: white;
}

.chara1: {
	font-size: 20px;
}

.text1 {
	display: block;
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(255, 255, 255, 0.6);
	width: 200px;
	height: 30px;
	color: #333;
	font-size: 20px;
	font-weight: 700px;
	font-family: Courier;
	margin-bottom: 5px;
	z-index
	=1;
}

input {
	border: 1px #c0d8ef solid;
	border-radius: 2px;
	margin-left: 15px;
}

button {
	border: 1px #cccccc solid;
	border-radius: 2px;
}

.search {
	display: block;
	border: 1px solid rgba(255, 255, 255, 1);
	background: rgba(255, 255, 255, 0.9);
	border-radius: 0.2em;
	width: 60px;
	height: 25px;
	color: #333;
	font-size: 18px;
	font-weight: 700px; z-index =1;
	font-family: Courier;
	transition: width 0.5s, margin-left 0.5s;
	-webkit-appearance: button;
}

.search:hover {
	cursor: pointer;
	opacity: 1;
	background-color: #483D8B;
}

.text {
	display: block;
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(255, 255, 255, 0.6);
	width: 80%;
	height: 25px;
	color: #333;
	font-size: 15px;
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

.location1 {
	position: absolute;
	left: 400px;
	top: 30px;
}

.location2 {
	position: absolute;
	left: 0px;
	top: 350px;
}

.div1 {
	background-color: grey;
	position: absolute;
	left: 0px;
	top: 100px;
	height: 250px;
	width: 15%;
}

.divcubeb1 {
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(221, 160, 221, 0.8);
	position: absolute;
	left: 20%;
	top: 20%;
	height: 29%;
	width: 32%;
}

.divcube1 {
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(255, 255, 255, 0.8);
	position: absolute;
	left: 20%;
	top: 28%;
	height: 21%;
	width: 32%;
}

.divcubeb2 {
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(85, 107, 47, 0.8);
	position: absolute;
	left: 58%;
	top: 20%;
	height: 29%;
	width: 32%;
}

.divcube2 {
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(255, 255, 255, 0.8);
	position: absolute;
	left: 58%;
	top: 28%;
	height: 21%;
	width: 32%;
}

.divcubeb3 {
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(205, 92, 92, 0.8);
	position: absolute;
	left: 58%;
	top: 60%;
	height: 29%;
	width: 32%;
}

.divcube3 {
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(255, 255, 255, 0.8);
	position: absolute;
	left: 58%;
	top: 68%;
	height: 21%;
	width: 32%;
}

.divcubeb4 {
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(0, 0, 128, 0.8);
	position: absolute;
	left: 20%;
	top: 60%;
	height: 29%;
	width: 32%;
}

.divcube4 {
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 0.2em;
	background: rgba(255, 255, 255, 0.8);
	position: absolute;
	left: 20%;
	top: 68%;
	height: 21%;
	width: 32%;
}
</style>
</head>

<body>
	<div>
		<h1
			style="font-size: 45px; font-family: 黑体; color: black; font-weight: 5px;">NUAA信息分享</h1>
	</div>
	<form action="/ICP/Search" method="get" align="center">
		<table border="0px" class="location1">
			<tr height="35px">
				<td><select name="searchType">
						<option value="通知">搜索通知</option>
						<option value="标签">搜索标签</option>
						<option value="用户">搜索用户</option>
				</select></td>
				<td width="400px"><input style="width: 300px; height: 25px;"
					type="text" id="searchdiv" size="30px" value="${keyWord}"
					name="keyWord" /></td>
				<td><input class="search" id="search" type="submit" value="搜索" />
				</td>
			</tr>
		</table>
	</form>
	<div class="location2">
		<ul>
			<li><a href="#" class="chara1">主页</a></li>
			<li><a href="#" class="chara1">近期热门</a></li>
			<li><a href="#" class="chara1">我发布的通知</a></li>
			<li><a href="#" class="chara1">我的个人信息</a></li>
			<li><a href="#" class="chara1">网站问题反馈</a></li>
		</ul>
	</div>

	<div class="div1">
		<form action="${pageContext.request.contextPath}/Login" method="post">
			<input name="username" type="text" class="text"
				placeholder="username" /> <input name="password" type="password"
				class="text" placeholder="password" />
			<input type="submit" name="button" value="登陆" />
			<a href="/ICP/RegisterUI">注册</a>
			<a href="">忘记密码</a>
		</form>
	</div>
	<div class="divcubeb1">
		<h3 style="font-size: 30px; font-family: 黑体; color: white;">组织机构</h3>
	</div>
	<div class="divcube1">
		<div style="float: right;">
			<a href="http://www.baidu.com">了解更多>></a>
		</div>
		<%=IndexUI.ShowAnnouncementByType("组织机构")%>
	</div>

	<div class="divcubeb2">
		<h3 style="font-size: 30px; font-family: 黑体; color: white;">体育赛事</h3>
	</div>
	<div class="divcube2">
		<div style="float: right;">
			<a href="http://www.baidu.com">了解更多>></a>
		</div>
		<%=IndexUI.ShowAnnouncementByType("体育赛事")%>
	</div>

	<div class="divcubeb3">
		<h3 style="font-size: 30px; font-family: 黑体; color: white;">学术科研</h3>
	</div>
	<div class="divcube3">
		<div style="float: right;">
			<a href="http://www.baidu.com">了解更多>></a>
		</div>
		<%=IndexUI.ShowAnnouncementByType("学术科研")%>
	</div>


	<div class="divcubeb4">
		<h3 style="font-size: 30px; font-family: 黑体; color: white;">文娱艺术</h3>
	</div>
	<div class="divcube4">
		<div style="float: right;">
			<a href="http://www.baidu.com">了解更多>></a>
		</div>
		<%=IndexUI.ShowAnnouncementByType("文娱艺术")%>
	</div>

</body>
</html>