<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息完善界面</title>
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
		style="font-size: 45px; font-family: Courier; text-align: center; color: white;">上传校园卡图片</h1>

	<form action="${pageContext.request.contextPath}/VerifyCampusCard"
		enctype="multipart/form-data" encoding="multipart/form-data">
		<table border="0px" align="center">

			<tr height="35px" align="center">
				<td><input type="file" name="campuscard" /> 
				<!--<input type="file" name="image" accept=""/>-->
					<!--<img src="" width="200px" height="200px" id="img-change">--> 
					<input type="button" id="campusCard" value="上传" /></td>
			</tr>

			<tr align="center">
				<td><input type="submit" id="" value="提交申请" class="login"
					style="margin-left: -25px; position: relative; top: 70px;" /></td>
			</tr>

		</table>
	</form>


</body>
</html>