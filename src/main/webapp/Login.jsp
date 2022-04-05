<%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/3/29
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(!(request.getAttribute("message")==null)){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<html>
<head>
    <title>Login</title>
    <style>
        input{
            height: 40px;
            margin-bottom: 5px;
        }
    </style>
</head>
<body style="background-image: url('images/bg.jpg');background-size: cover;">
<form method="post" action="/ZengXiaoqian2020211001001301/Login" style="width:25vw;height:auto;margin-top: 15%;margin-left:37%;display: flex;flex-direction: column;" onsubmit="return check()">
    <input name="username" type="text" placeholder="Username" required>
    <input name="password" type="password" placeholder="Passwords" required id="pwd">
    <input name="submit" type="submit" value="Login">
    <input name="reset" type="reset" value="reset">
</form>
</body>
</html>
<%@include file="footer.jsp"%>
