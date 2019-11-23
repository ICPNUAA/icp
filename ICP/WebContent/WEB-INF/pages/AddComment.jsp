<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>新增评论</title>
    <style type="text/css">
    body{
    background-color: #F0F8FF;
    background-image: -webkit-gradient(linear,left top,right bottom,
        from(white),to(#F0F8FF));
    }
    ul {
    list-style-type: none;
    margin: 0;
    padding: 0;

    background-color: grey;
    text-align:center
    border: 1px solid #555;
    width: 15%;
    height: 100%;/*  全屏高度 */
    position: fixed;
    overflow: auto; /* 如果导航栏选项多，允许滚动 */
    }
    a   {
    display:block;
    width:150px;
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
    input{
    border: 1px #c0d8ef solid;
    border-radius: 2px;
    margin-left: 15px;
    }

    button{
    border: 1px #cccccc solid;
    border-radius: 2px;
    }
    </style>
    <style>
    .left{
    float: left;
    width: 20%;
    height: 666px;
    }
    .right{
    float: right;
    width: 80%;
    height: 666px;
    }
    .right1{
    height: 15%;
    width: 100%;
    }
    .right2{
    width: 93%;
    /*height: 150%;*/
    /*background-color: #808080;*/
    }
    .chara1{
    font-size: 20px;
    }
    .search{
    display: block;
    border: 1px solid rgba(255,255,255,1);
    background:rgba(255,255,255,0.9);
    border-radius: 0.2em;
    width:60px;
    height: 25px;
    color: #333;
    font-size: 18px;
    font-weight: 700px;

    z-index=1;
    font-family: Courier;
    transition: width 0.5s,margin-left 0.5s;
    -webkit-appearance: button;

    }
    .search:hover{
    cursor: pointer;
    opacity: 1;
     background-color: #483D8B;
    }
    .left1{

    }
    .left2{
    background-color: grey;
    position: absolute;
    left: 0px;
    top: 100px;
    height: 250px;
    width: 15%;
    }
    .left3{
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
        <div style="width: 40%;height: 40%;position: relative;left: 20%;top: 40%">
        <form action="#" method="get" align="center">
            <table border="0px">
               <tr height="35px">
                    <td width="400px">
                       <input style="width: 300px;height:25px; " type="text" id="searchdiv" size="30px" placeholder="search" />
                    </td>
                    <td>
                     <button class="search" id="search">搜索</button>
                     </td>
                </tr>
            </table>
         </form>
        </div>
    </div>
    <!--通知展示框-->
    <div class="right2">
        <div class="lay-blog" style="position: relative;top: -100px;">
            <div class="container-wrap">
                <div class="container container-message container-details">
                    <div class="contar-wrap">
                        <div class="item">
                            <div class="item-box  layer-photos-demo1 layer-photos-demo">
                                <h3><a href="#">${announcementTitle}</a></h3>
                                <h5>发布于：<span>${publishTime}</span></h5>
                                <p>${announcementContent}</p>
                                <div class="count layui-clear">
                                    <span class="pull-right">阅读 <em>${readAmount}</em></span>
                                    
                                </div>
                            </div>
                        </div>
                        <form class="layui-form" action="">
                            <div class="layui-form-item layui-form-text">
                                <textarea  class="layui-textarea"  style="resize:none" placeholder="写点什么啊"></textarea>
                            </div>
                            <div class="btnbox" style="position: relative;left: 90%">
                                <a href=""  id="sure">
                                    确定
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="css&js/res/layui/layui.js">
        </script>
        <script>
            layui.config({
                base: 'css&js/res/static/js/'
            }).use('blog');
        </script>
        <script id="LAY-msg-tpl" type="text/html">
            <div class="info-box">
                <div class="info-item">
                    <img class="info-img" src="{{ d.avatar }}" alt="">
                    <div class="info-text">
                        <p class="title">
                            <span class="name">{{ d.username }}</span>
                            <span class="info-img">
					  	<i class="layui-icon layui-icon-praise"></i>
					  	{{ d.praise }}
					 	</span>
                        </p>
                        <p class="info-intr">
                            {{ d.content }}
                        </p>
                    </div>
                </div>
            </div>
        </script>
    </div>
</div>
<!--左边栏-->
<div class="left">
    <!--title-->
    <div class="left1">
        <h1 style="font-size:45px;font-family:黑体; color:black; font-weight:5px;">NUAA信息分享</h1>
    </div>
    <!--id-->
    <div class="left2">
        <form >
            <h5 style="font-size:17px;font-family:黑体; color:white; font-weight:5px;">登录时间：2018/11/22/17：12</h5>

            <h5 style="font-size:23px;font-family:黑体; color:white; font-weight:5px;">XXX,欢迎你！</h5>
        </form>
    </div>
    <!--导航-->
    <div class="left3">
                <ul>

                  <li><a href="#home" class="chara1">主页</a></li>
                  <li><a href="#news" class="chara1">信息类目</a></li>
                  <li><a href="#contact" class="chara1">近期热门</a></li>
                  <li><a href="#announcement" class="chara1">我的通知</a></li>
                  <li><a href="#myinfo" class="chara1">我的个人信息</a></li>
                  <li><a href="#return" class="chara1">网站问题反馈</a></li>
                </ul>
    </div>
</div>
</body>
</html>