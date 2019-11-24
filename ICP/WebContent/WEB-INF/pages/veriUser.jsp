 <!-- 验证学生的官方身份 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>个人官方验证</title>
        <style type="text/css">
		body{
		background-color: #B0C4DE;
		background-image: -webkit-gradient(linear,left top,right bottom,
			from(#00CACA),to(#B0C4DE));
		}

.text{
		display: block;
		border: 1px solid rgba(255,255,255,1);
		border-radius: 0.2em;
		background:rgba(255,255,255,0.6);
		width:300px;
		height: 40px;
		
		color: #333;
		font-size: 20px;
		font-weight: 700px;
		font-family: Courier;
		
		margin-bottom: 5px;
		z-index=1;
	}
.text:hover{
		background: rgba(255,255,255,0.9);
		opacity: 1;
		transition: width 0.5s,margin-left 0.5s;
		transition: transform linear 1s;
	}
.text2{
		display: block;
		border: 1px solid rgba(255,255,255,1);
		border-radius: 0.2em;
		background:rgba(255,255,255,0.6);
		width:300px;
		height: 100px;
		
		color: #333;
		font-size: 20px;
		font-weight: 700px;
		font-family: Courier;
		
		margin-bottom: 5px;
		z-index=1;
	}

		.login{
		display: block;
		border: 1px solid rgba(255,255,255,1);
		background:rgba(255,255,255,0.6);
		border-radius: 0.2em;
		width:302px;
		height: 40px;
		color: #333;
		font-size: 18px;
		font-weight: 700px;
		margin-left: 550 px;
		margin-bottom: 5px;
		z-index=1;
		font-family: Courier;
		transition: width 0.5s,margin-left 0.5s;
        -webkit-appearance: button;

	}
.login:hover{
		cursor: pointer;
		opacity: 1;
		background:rgba(255,255,255,0.9);
	}


	</style>
</head>
<body>


<h1 style="font-size:45px;font-family:Courier;text-align:center;color:white;">官方身份验证</h1>

        <form action="${pageContext.request.contextPath}/VeriUser" method="post" enctype="multipart/form-data">
            <table border="0px" align="center">
                                 
                 <tr height="35px" align="center" >
                    <td>待验证的Tag身份</td>
                    <td>
                       <input type="text" name="VeriTag" value="" class="text" placeholder="需验证的官方身份" />
                    </td>                  
                 </tr>
                  <tr height="35px" align="center">
                       <td>上传身份证明相关材料</td>
                       <div style="position: relative;left: 41%">
                           <input type="file" name="VeriImage" />
                           <!--<input type="file" name="image" accept=""/>-->
                           <!--<img src="" width="200px" height="200px" id="img-change">-->
                       </div>
                 </tr>
                 
                    <td colspan="2" align="center" >
                        <input type="submit" id="" value="点击上传验证信息" class="login" style="margin-left:-25px;position: relative;top: 70px;"/>
                    </td>

            </table>
        </form>
        

</body>
</html>