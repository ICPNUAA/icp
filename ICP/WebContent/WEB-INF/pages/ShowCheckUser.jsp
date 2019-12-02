
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>待审核用户信息</title>
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

.divadd {
	background-color: grey;
	position: absolute;
	left: 80%;
	top: 15%;
	height: 60px;
	width: 110px;
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
			<li><a href="/ICP/AdminCheckUsersUI">待审核用户信息</a></li>
			<li><a href="/ICP/AdminCheckTagsUI">待审核标签</a></li>
			<li><a href="/ICP/ManageUserUI">管理用户</a></li>
			<li><a href="/ICP/ManageAnnouncementsUI">管理通知</a></li>
		</ul>
	</div>

	<div class="div1">
		<form>
			<h5
				style="font-size: 23px; font-family: 黑体; color: white; font-weight: 5px;">管理员,欢迎你！</h5>
		</form>
	</div>
	<form>
		<table border="1px" align="center">
			<tr height="15px">
				<td width="300px">
					<h5
						style="font-size: 20px; font-family: 黑体; color: black; font-weight: 5px;">姓名</h5>
				</td>
				<td><h5 name="userID">${userID}</h5></td>
			</tr>
			<tr height="50px">
				<td width="350px">
					<h5
						style="font-size: 20px; font-family: 黑体; color: black; font-weight: 5px;">校园卡图片</h5>
				</td>
				<td width="350px">${cpMessage}</td>
			</tr>
			<tr height="15px">
				<td width="350px">
					<h5
						style="font-size: 20px; font-family: 黑体; color: black; font-weight: 5px;">需验证身份</h5>
				</td>
				<td><h5 name="VeriTag">${VeriTags}</h5></td>
			</tr>
			<tr height="50px">
				<td width="350px">
					<h5
						style="font-size: 20px; font-family: 黑体; color: black; font-weight: 5px;">身份验证图</h5>
				</td>
				<td width="350px">${vpMessage}</td>
			</tr>
			<tr height="50px">
				<td width="500px"></td>
				<td width="50px"><input type="submit" id="" value="通过验证"
					align="right" /> <input type="submit" id="" value="拒绝验证" /></td>


			</tr>
		</table>
	</form>


</body>
</html>