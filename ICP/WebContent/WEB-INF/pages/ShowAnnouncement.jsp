<%@page import="icp.web.UI.ShowAnnouncementUI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>通知展示</title>
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
	width: 150px;
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

input {
	border: 1px #c0d8ef solid;
	border-radius: 2px;
	margin-left: 15px;
}

button {
	border: 1px #cccccc solid;
	border-radius: 2px;
}
</style>
<style>
.left {
	float: left;
	width: 20%;
	height: 666px;
}

.right {
	float: right;
	width: 80%;
	height: 666px;
}

.right1 {
	height: 15%;
	width: 100%;
}

.right2 {
	width: 93%;
	/*height: 150%;*/
	/*background-color: #808080;*/
}

.chara1 {
	font-size: 20px;
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

.left1 {
	
}

.left2 {
	background-color: grey;
	position: absolute;
	left: 0px;
	top: 100px;
	height: 250px;
	width: 15%;
}

.left3 {
	position: absolute;
	left: 0px;
	top: 350px;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css&js/res/layui/css/layui.css">
<link rel="stylesheet" href="css&js/res/static/css/mian.css">
</head>

<body>
	<!--主体-->
	<div class="right">
		<!--搜索栏-->
		<div class="right1">
			<div
				style="width: 40%; height: 40%; position: relative; left: 20%; top: 40%">
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
							<td><input class="search" id="search" type="submit"
								value="搜索" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<!--通知展示框-->
		<div class="right2">
			<div class="lay-blog" style="position: relative; top: -100px;">
				<div class="container-wrap">
					<div class="container container-message container-details">
						<div class="contar-wrap">
							<div class="item">
								<div class="item-box  layer-photos-demo1 layer-photos-demo">
									<h3>${announcementTitle}</h3>
									<h5>
										标签： <span style="color: gold">${officialTags}</span> <span>${normalTags}</span>
									</h5>
									<h5>
										发布于：<span>${publishTime}</span>
									</h5>
									<p>${announcementContent}</p>
									<div class="count layui-clear">
										<span class="pull-right">阅读 <em>${readAmount}</em></span>

									</div>
								</div>
							</div>

							<div id="LAY-msg-box">
								<%=ShowAnnouncementUI.ShowComment()%>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script src="css&js/res/layui/layui.js">
				
			</script>
			<script>
				layui.config({
					base : 'css&js/res/static/js/'
				}).use('blog');
			</script>
		</div>
	</div>
	<!--左边栏-->
	<div class="left">
		<!--title-->
		<div class="left1">
			<h1
				style="font-size: 45px; font-family: 黑体; color: black; font-weight: 5px;">NUAA信息分享</h1>
		</div>
		<!--id-->
		<div class="left2">
			<form>
				<h5
					style="font-size: 23px; font-family: 黑体; color: white; font-weight: 5px;"><%=session.getAttribute("userID")%>，欢迎你！
				</h5>
			</form>
		</div>
		<!--导航-->
		<div class="left3">
			<ul>
				<li><a href="/ICP/IndexUI" class="chara1">主页</a></li>
				<li><a href="/ICP/MyAnnouncementUI" class="chara1">我发布的通知</a></li>
				<li><a href="/ICP/UserCenterUIServlet" class="chara1">我的个人信息</a></li>
			</ul>
		</div>
	</div>
</body>
</html>