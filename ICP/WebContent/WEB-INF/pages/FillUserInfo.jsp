<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>个人信息完善界面</title>
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


<h1 style="font-size:45px;font-family:Courier;text-align:center;color:white;">fill up</h1>

        <form action="${pageContext.request.contextPath}/FillUser" enctype="multipart/form-data" encoding="multipart/form-data">
            <table border="0px" align="center">
                <tr height="35px" align="center">
                 <td>选择你喜欢的标签</td>
                    <td width="400px" >
                        <input name="label1" type="checkbox" value="${label1}"  />${label1}
                        <input name="label2" type="checkbox" value="${label2}" />${label2}
                        <input name="label3" type="checkbox" value="${label3}" />${label3}
                        <input name="label4" type="checkbox" value="${label4}" />${label4}
                        <input name="label5" type="checkbox" value="${label5}" />${label5}
                        <input name="label6" type="checkbox" value="${label6}" />${label6}
                        <input name="label7" type="checkbox" value="${label7}" />${label7}
                        <input name="label8" type="checkbox" value="${label8}" />${label8}
                        <input name="label9" type="checkbox" value="${label9}" />${label9}
                        <input name="label10" type="checkbox" value="${label10}" />${label10}
                       
                    </td>
                </tr>
              <tr height="35px" align="center">
                    <td>+自定义标签</td>
                    <td width="150px">
                        <textarea name="intro" rows="8" cols="30" class="text2" placeholder="用'#'将它们间隔开，如#球类运动#"></textarea>
                    </td>
               </tr>
                
               <tr height="35px" align="center" >
                    <td>真实姓名</td>
                    <td>
                       <input type="text" name="realname" id="uname" value="" class="text" />
                    </td>                  
                </tr>
                <tr height="35px" align="center" >
                    <td>学生证号</td>
                    <td>
                    	<input type="text" name="studentnumber" id="uname" value="" class="text" />
                    </td>
                </tr>
                <tr height="35px" align="center">
                       <td>上传校园卡图片</td>
                       <div style="position: relative;top: 315px;left: 41%">
                           <input type="file" name="campuscard" />
                           <!--<input type="file" name="image" accept=""/>-->
                           <!--<img src="" width="200px" height="200px" id="img-change">-->
                           <input type="button" id="campusCard" value="提交">
                       </div>
                 </tr>
                 
                    <td colspan="2" align="center" >
                        <input type="submit" id="" value="点击完善个人信息" class="login" style="margin-left:-25px;position: relative;top: 70px;"/>
                    </td>

            </table>
        </form>
        

</body>
</html>