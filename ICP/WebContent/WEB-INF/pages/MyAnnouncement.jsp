<%@page import="icp.web.UI.MyAnnouncementUI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>我发布的通知</title>
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

.input {
	border: 1px #c0d8ef solid;
	border-radius: 2px;
	margin-left: 15px;
}

.button {
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

.divadd {
	position: absolute;
	left: 80%;
	top: 15%;
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
					type="text" id="searchdiv" size="30px"
					name="keyWord" /></td>
				<td><input class="search" id="search" type="submit" value="搜索" />
				</td>
			</tr>
		</table>
	</form>

	<div class="location2">
		<ul>
			<li><a href="/ICP/IndexUI" class="chara1">主页</a></li>
			<li><a href="/ICP/MyAnnouncementUI" class="chara1">我发布的通知</a></li>
			<li><a href="/ICP/UserCenterUI" class="chara1">我的个人信息</a></li>
		</ul>
	</div>

	<div class="div1">
		<form>
			<h5
				style="font-size: 23px; font-family: 黑体; color: white; font-weight: 5px;"><%=session.getAttribute("userID")%>，欢迎你！
			</h5>
		</form>
	</div>
	<!-- 显示已发送通知，使用表格 -->
	<div style="height: 600px; overflow-y: scroll">
		<form style="position: relative; left: 50px">
			<table border="0px" align="center">
				<tr height="55px">
					<td width="1000px">
						<h5 style="font-size: 25px; font-family: 黑体; color: black; font-weight: 5px;">我已发布的通知</h5>
					</td>
				</tr>
				<!-- 中间正文 -->
				<%=MyAnnouncementUI.ShowMyAnnouncement(session.getAttribute("userID").toString())%>
			</table>
		</form>
	</div>
	<!-- 右上按钮 -->
	<div class="divadd">
		<form action="${pageContext.request.contextPath}/AddAnnouncementUI">
			<input style="font-size: 17px; font-family: 黑体; color: black; font-weight: 5px;" value="+添加通知" type="submit">
		</form>
	</div>
</body>
</html>