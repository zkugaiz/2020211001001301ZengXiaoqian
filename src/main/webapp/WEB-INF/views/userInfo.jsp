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
User user =(User)request.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Username:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>Username:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Username:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Username:</td><td><%=user.getBirthdate()%></td></tr>

</table>
<%@include file="footer.jsp"%>