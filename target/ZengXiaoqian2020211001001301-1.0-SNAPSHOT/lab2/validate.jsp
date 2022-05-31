<%@ page import="jdk.nashorn.internal.objects.Global" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="Login" class="com.zengxiaoqian.Lab2.Login" scope="request" ></jsp:useBean>
    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="Login" property="username" value="admin"/>
<jsp:getProperty name="Login" property="password" />


<%
   //todo 3: use if check username is admin and password is admin
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    if(username.equals("admin") && password.equals("admin"))
    {
        session.setAttribute("login",Login.getUsername());
        request.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);
    }
    else{
       // out.println("<h1>Username or Password Error Massage</h1>");
        //request.getRequestDispatcher("lab2/login.jsp").forward(request,response);


%>
    <%--todo 4: use jsp:forward to welcome.jsp page--%>

    <%--todo 5: else part{ --%>

<%
// todo 6: print username or password error message
    out.println("<h1>Username or Password Error Massage</h1>");

%>
    <%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp" ></jsp:include>
    <%--todo 8: close else --%>
<%
    }
%>
</body>
</html>