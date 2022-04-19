<%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/4/19
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>

<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="update" style="width:25vw;height:auto;margin-top: 15%;margin-left:37%;display: flex;flex-direction: column;" onsubmit="return check()">
    <input type="hidden" name="id" placeholder="Userid" value="<%=u.getUserid()%>">
    <input name="username" type="text" placeholder="Username" value="<%=u.getUsername()%>" required>
    <input name="password" type="password" placeholder="Passwords" value="<%=u.getPassword()%>" required id="pwd">
    <input name="email" type="email" placeholder="Email" value="<%=u.getEmail()%>" required>
    Gender:<input name="gender" type="radio"  value="Male" <%="Male".equals(u.getGender())?"checked":""%>>Male
           <input name="gender" type="radio"  value="Female"<%="Female".equals(u.getGender())?"checked":""%> >Female
    <input name="birthdate" type="date" placeholder="Date of Birth (yyyy-mm-dd)" value="<%=u.getBirthdate()%>" required>
    <input name="submit" type="submit" value="Save Changes">

</form>
<%@include file="footer.jsp"%>