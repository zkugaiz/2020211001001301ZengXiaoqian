<%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/4/5
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Username:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>Username:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>Username:</td><td><%=request.getAttribute("gender")%></td></tr>
    <tr><td>Username:</td><td><%=request.getAttribute("birthdate")%></td></tr>

</table>
<%@include file="footer.jsp"%>