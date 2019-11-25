<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>用户注册页面</title>
        <style type="text/css">
body{
		background-color: #B0C4DE;
		background-image: -webkit-gradient(linear,left top,right bottom,
			from(#00CACA),to(#B0C4DE)); 
		}
		/*文本框格式*/
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
/*按钮格式*/
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
<h1 style="font-size:45px;font-family:Courier;text-align:center;color:white;">SIGN IN</h1>

        
        <form action="${pageContext.request.contextPath}/Register" method="post">
            <table border="0px" align="center">
                <!-- 输入姓名栏 -->
                <tr height="35px">
                    <td>用户名</td>
                    <td width="400px">
                        <input type="text" name="userid" id="uname" value="" class="text" />
                    </td>
                 </tr>
                <!-- 输入密码栏 -->
                <tr height="35px">
                    <td>密码：</td>
                    <td>
                        <input type="password" name="password" id="pwd" value="" class="text" />
                    </td>
                </tr>
                <!-- 输入密码栏 -->
                <tr height="35px">
                    <td>请再次输入密码：</td>
                    <td>
                        <input type="password" name="password2" id="pwd2" value="" class="text" />
                    </td>
                </tr>
               
                <!--按钮-->
                <tr>
                    <td colspan="2" align="center" >
                        <input type="submit" id="" value="注册" class="login" style="margin-left:-25px"/>
                    </td>
                    
                </tr>
                <h5 id="message" style="font-size:10px;font-family:宋体; color:red; font-weight:2px;">${message}</h5>
            </table>
        </form>
        <script language="javascript">
        	function ale() {
        		//这个基本没有什么说的，就是弹出一个提醒的对话框	
        		alert();	
        		}	
        	function firm() 
        	{//利用对话框返回的值 （true 或者 false）
        		if (confirm("确定去这个地址？")) 
        		{
        			//如果是true ，那么就把页面转向https://blog.csdn.net/h2503652646			
        			location.href = "https://blog.csdn.net/h2503652646";		
        		} 
        		else {			
        			alert("你取消了。");		
        			}	
        	}	
        	</script>
    </body>
</html>