<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>管理员审核</title>
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
a
{
    display:block;
    width:100px;
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
.text1{
		display: block;
		border: 1px solid rgba(255,255,255,1);
		border-radius: 0.2em;
		background:rgba(255,255,255,0.6);
		width:200px;
		height: 30px;
		
		color: #333;
		font-size: 20px;
		font-weight: 700px;
		font-family: Courier;
		
		margin-bottom: 5px;
		z-index=1;
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

.text{
        display: block;
        border: 1px solid rgba(255,255,255,1);
        border-radius: 0.2em;
        background:rgba(255,255,255,0.6);
        width:80%;
        height: 25px;
        
        color: #333;
        font-size: 15px;
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

        .location1{
position: absolute;
    left: 400px;
    top: 30px;

        }
        .location2{
position: absolute;
    left: 0px;
    top: 350px;

        }
        .div1{
        background-color: grey;
position: absolute;
    left: 0px;
    top: 100px;
    height: 250px;
    width: 15%;
        }
    .divadd{
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
	<h1 style="font-size:45px;font-family:黑体; color:black; font-weight:5px;">NUAA信息分享</h1>
	</div>
 <form action="#" method="get" align="center">
            <table border="0px" class="location1">
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
<div class="location2">
                    <ul>
                      <li><a href="#home" class="chara1">主页</a></li>
                      <li><a href="#news">信息类目</a></li>
                      <li><a href="#contact">近期热门</a></li>
                      <li><a href="#myinfo" class="chara1">审核信息</a></li>
                    </ul>
        </div>

        <div class="div1">
            <form >
             <h5 style="font-size:17px;font-family:黑体; color:white; font-weight:5px;">登录时间：2018/11/22/17：12</h5>
            
           <h5 style="font-size:23px;font-family:黑体; color:white; font-weight:5px;">管理员,欢迎你！</h5>   
        </form>
    </div>
 <form >
    <table border="1px" align="center" margin-left="100px">
    <c:forEach items="${requestScope.applicant} " var="applicant">
        <tr height="70px">
                <td width="500px">
                    <c:out value="${applicant} "/>
                </td>
                <td width="100px">
                <button type="submit" >点击查看</button>
                </td>
            </tr>
	</c:forEach>
        </table>
    </form>
<div style="height:px;margin-left:100px ;">
<span id="spanFirst">第一页</span>
<span id="spanPre">上一页</span>
<span id="spanNext">下一页</span>
<span id="spanLast">最后一页</span>
第<span id="spanPageNum"></span>页/共
<span id="spanTotalPage"></span>页
</div>
</div>
<script type="text/javascript">
var theTable = document.getElementById("table");
var totalPage = document.getElementById("spanTotalPage");
var pageNum = document.getElementById("spanPageNum");
var spanPre = document.getElementById("spanPre");
var spanNext = document.getElementById("spanNext");
var spanFirst = document.getElementById("spanFirst");
var spanLast = document.getElementById("spanLast");
var numberRowsInTable = theTable.rows.length;
var pageSize = 5;
var page = 5;
//下一页
function next() {
hideTable();
currentRow = pageSize * page;
maxRow = currentRow + pageSize;
if ( maxRow > numberRowsInTable )
maxRow = numberRowsInTable;
for ( var i = currentRow; i< maxRow; i++ ) {
theTable.rows[i].style.display = '';
}
page++;
if ( maxRow == numberRowsInTable ){
nextText();
lastText();
}
showPage();
preLink();
firstLink();
}
//上一页
function pre() {
hideTable();
page--;
currentRow = pageSize * page;
maxRow = currentRow - pageSize;
if ( currentRow > numberRowsInTable )
currentRow = numberRowsInTable;
for ( var i = maxRow; i< currentRow; i++ ) {
theTable.rows[i].style.display = '';
}
if ( maxRow == 0) {
preText();
firstText();
}
showPage();
nextLink();
lastLink();
}
//第一页
function first() {
hideTable();
page = 1;
for ( var i = 0; i<pageSize; i++ ) {
theTable.rows[i].style.display = '';
}
showPage();
preText();
nextLink();
lastLink();
}
//最后一页
function last() {
hideTable();
page = pageCount();
currentRow = pageSize * (page - );
for ( var i = currentRow; i<numberRowsInTable; i++ ) {
theTable.rows[i].style.display = '';
}
showPage();
preLink();
nextText();
firstLink();
}
function hideTable() {
for ( var i = ; i<numberRowsInTable; i++ ) {
theTable.rows[i].style.display = 'none';
}
}
function showPage() {
pageNum.innerHTML = page;
}
//总共页数
function pageCount() {
var count = ;
if ( numberRowsInTable%pageSize != ) count = ; 
return parseInt(numberRowsInTable/pageSize) + count;
}
//显示链接
function preLink() { spanPre.innerHTML = "<a href='javascript:pre();'>上一页</a>"; }
function preText() { spanPre.innerHTML = "上一页"; }
function nextLink() { spanNext.innerHTML = "<a href='javascript:next();'>下一页</a>"; }
function nextText() { spanNext.innerHTML = "下一页"; }
function firstLink() { spanFirst.innerHTML = "<a href='javascript:first();'>第一页</a>"; }
function firstText() { spanFirst.innerHTML = "第一页"; }
function lastLink() { spanLast.innerHTML = "<a href='javascript:last();'>最后一页</a>"; }
function lastText() { spanLast.innerHTML = "最后一页"; }
//隐藏表格
function hide() {
for ( var i = pageSize; i<numberRowsInTable; i++ ) {
theTable.rows[i].style.display = 'none';
}
totalPage.innerHTML = pageCount();
pageNum.innerHTML = '';
nextLink();
lastLink();
}
hide();
</script>

	</body>
</html>