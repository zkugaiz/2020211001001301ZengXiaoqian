<%@ page import="com.zengxiaoqian.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/4/5
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
User u =(User)session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>BirthDate:</td><td><%=u.getBirthdate()%></td></tr>
    <tr><td><a href="update">Update</a></td></tr>
</table>
<%@include file="footer.jsp"%>