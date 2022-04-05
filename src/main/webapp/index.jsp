<%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/4/5
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h2>Welcome to My Online Shop Home Page.</h2><br>
<form method="get" target="_blank" action="search">
<input type="text" name="txt" size="30"/>
<select name="search">
    <option value="baidu">Baidu</option>
    <option value="bing">Bing</option>
    <option value="google">Google</option>
</select>
<input type="submit" value="Search"/>
</form>
</body>
</html>
<%@include file="footer.jsp"%>
