<%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/5/18
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  i am MyJsp<br>
<html>
<head>
    <title>MyJsp</title>
    <style>
    </style>
</head>
<body >
<form method="post" action="MyDearJsp.jsp" >

    <input name="name" type="text" placeholder="name" required><br>
    <input name="clas" type="text" placeholder="class" required ><br>
    <input name="id" type="text" placeholder="id" required><br>
    <input name="submit" type="submit" value="Send date to server">
    <input name="reset" type="reset" value="reset">
</form>
</body>
</html>


