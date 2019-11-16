<%@ page contentType="text/html;charset=GB2312"%>
<%@ page language="java" import="java.sql.*"%>
<html>
<head>
<title>Test</title>
</head>
<body>
<%
Class.forName("com.mysql.cj.jdbc.Driver");//¶¯Ì¬¼ÓÔØmysqlÇı¶¯
Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/icpdb?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","123456");
Statement stmt =conn.createStatement();
ResultSet RS_result=stmt.executeQuery("select* from userinfo");
String userid,userpassword,usertype;
while(RS_result.next())
{
	userid = RS_result.getString("userid");
	userpassword = RS_result.getString("userpassword");
	usertype = RS_result.getString("usertype");
%>
<P><%=userid%><%=userpassword%><%=usertype %></p>
<%
}
stmt.close();
conn.close();
%>
</body>
</html>
