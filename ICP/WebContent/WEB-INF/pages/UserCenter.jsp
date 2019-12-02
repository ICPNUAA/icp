<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>用户个人中心</title>
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
.button {
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

.button:hover {
	cursor: pointer;
	opacity: 1;
	background: rgba(255, 255, 255, 0.9);
}
</style>
</head>
<body>
	<h1
		style="font-size: 45px; font-family: Courier; text-align: center; color: white;">User
		Center</h1>


	<form method="post">
		<table border="0px" align="center">
			<tr height="35px">
				<td colspan="2" align="center"><input type="button"
					name="FillStu" id="FillStu" value="验证学生身份" class="button"
					onclick="window.location.href='${pageContext.request.contextPath}/VerifyCampusCardUI'" />
				</td>
			</tr>
			<tr height="35px">
				<td colspan="2" align="center"><input type="button"
					name="VeriStu" id="VeriStu" value="验证官方标签" class="button"
					onclick="window.location.href='${pageContext.request.contextPath}/VerifyTagsUI'" />
				</td>
			</tr>
			<tr height="35px">
				<td colspan="2" align="center"><input type="button"
					name="EditTag" id="EditTag" value="管理我的标签" class="button"
					onclick="window.location.href='${pageContext.request.contextPath}/ManageMyTagsUI'" />
				</td>
			</tr>
			<tr height="35px">
               <td colspan="2" align="center" >
                   <input type="button" name="EditTag" id="EditTag" value="注销账户" class="button" 
                    onclick="window.location.href='${pageContext.request.contextPath}/DeleteUser'"/>
               </td>
            </tr>
		</table>
	</form>

</body>
</html>