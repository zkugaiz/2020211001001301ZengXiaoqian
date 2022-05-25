<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/5/18
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    String name=request.getParameter("name");
    String  Class=request.getParameter("clas");
    String id=request.getParameter("id");
    String submit=request.getParameter("submit");
    PrintWriter writer=response.getWriter();
    writer.println("<h1>using servlet and JSP<br></h1>");
    writer.println("<br>name:"+name);
    writer.println("<br>class:"+Class);
    writer.println("<br>id:"+id);
    writer.println("<br>submit:"+submit);
    //writer.close();

%>
<br><h1>use EL</h1><br>
name:${param.name}<br>
class:${param.clas}<br>
id:${param.id}<br>
submit${param.submit}
</body>
</html>
