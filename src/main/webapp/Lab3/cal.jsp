<%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/5/31
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    String firstVal="";
    String secondVal="";
    String name="";
    String length="";
    String result="";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("firstVal")){
                firstVal=cookie.getValue();
            }
            if (cookie.getName().equals("secondVal")){
                secondVal=cookie.getValue();
            }
            if (cookie.getName().equals("name")){
                name=cookie.getValue();
            }
            if (cookie.getName().equals("length")){
                length=cookie.getValue();
            }
            if (cookie.getName().equals("result")){
                result=cookie.getValue();
            }
        }
    }
    //update 5 user basepath
%>
<form action="<%=request.getContextPath()+"/CalServlet" %>" method="post">
    First val:  <input type="number" name="firstVal" value="<%=firstVal%>">
    Enter a name:<input type="text" name="name" value="<%=name%>"><br>
    Second val: <input type="number" name="secondVal" value="<%=secondVal%>">
    Length:     <input type="number" name="length" value="<%=length%>" readonly><br>
    result:     <input type="number" name="result" value="<%=result%>" readonly><br>
    <button type="hidden" name="action" value="add">Add</button>
    <button type="hidden" name="action" value="subtract">Subtract</button>
    <button type="hidden" name="action" value="multiply">Multiply</button>
    <button type="hidden" name="action" value="divide">Divide</button>
    <button type="hidden" name="action" value="computerLength">Computer Length</button>
    <input type="reset" name="Reset">
</form>
</body>
</html>
