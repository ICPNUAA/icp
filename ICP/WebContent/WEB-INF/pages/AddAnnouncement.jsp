<%@ page import="icp.web.UI.AddAnnouncementUI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>发送通知</title>
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
	height: 10%;
	width: 100%;
}

.right2 {
	width: 93%;
	height: 100%;
	vertical-align: text-bottom;
	background-color: #808080;
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
</head>

<!--文本编辑器-->
<script charset="utf-8" src="/ICP/css&js/kindeditor.js"></script>
<script charset="utf-8" src="/ICP/css&js/lang/zh-CN.js"></script>
<link rel="stylesheet" href="/ICP/css&js/themes/default/default.css">
<script>
	KindEditor.ready(function(K) {
		window.editor = K.create('#editor_id');
	});

	var options = {
		cssPath : '/ICP/css&js/themes/default/default.css',
		filterMode : true
	};
	var editor = K.create('textarea[name="content"]', options);
	// 取得HTML内容
	html = editor.html();

	// 同步数据后可以直接取得textarea的value
	editor.sync();
	html = document.getElementById('editor_id').value; // 原生API
	html = K('#editor_id').val(); // KindEditor Node API
	html = $('#editor_id').val(); // jQuery

	// 设置HTML内容
	editor.html('HTML内容');

	// 关闭过滤模式，保留所有标签
	KindEditor.options.filterMode = false;

	KindEditor.ready(function(K) {
		K.create('#editor_id');
	})
</script>

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
		<!--文本编辑器-->
		<div class="right2">
			<form action="${pageContext.request.contextPath}/AddAnnouncement">
				<p
					style="font-size: 18px; font-weight: 700px; color: white; position: relative; top: 10px; left: 5px">
					输入标题： <input name="title" type="text"
						style="width: 300px; height: 20px"> 选择版块： <select
						name="announcementType">
						<option value="">
						<option value="组织机构">组织机构</option>
						<option value="体育赛事">体育赛事</option>
						<option value="文娱艺术">文娱艺术</option>
						<option value="学术科研">学术科研</option>
					</select>
				</p>
				<p
					style="font-size: 18px; font-weight: 700px; color: white; position: relative; top: 10px; left: 5px">
					添加标签： <select name="myTags">
						<option value=""></option>
						<%=AddAnnouncementUI.GetTagsOptionByUserID(session.getAttribute("userID").toString())%>
					</select> <input name="tags" type="search"
						style="width: 300px; height: 20px">用#号分隔
				</p>
				<textarea id="editor_id" name="content"
					style="width: 95%; height: 480px;" placeholder="输入通知内容"></textarea>
				<input type="checkbox" name="commentAllowed" checked="checked"
					id="checkcomment" /> <label for="checkcomment">允许评论</label>
				<button id="submit"
					style="position: relative; top: 10px; left: 45%;">提交</button>
				<%
					request.getSession().setAttribute("token", true);
				%>
			</form>
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
				<li><a href="/ICP/UserCenterUI" class="chara1">我的个人信息</a></li>
			</ul>
		</div>
	</div>
</body>
</html>