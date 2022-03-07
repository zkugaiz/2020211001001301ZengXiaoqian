<%--
  Created by IntelliJ IDEA.
  User: ljmzxq
  Date: 2022/3/7
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        input{
            height: 40px;
            margin-bottom: 5px;
        }
    </style>
</head>
<body style="background-image: url('images/bg.jpg');background-size: cover;">
<form style="width:25vw;height:auto;margin-top: 15%;margin-left:37%;display: flex;flex-direction: column;" onsubmit="return check()">
    <input name="username" type="text" placeholder="Username" required>
    <input name="password" type="password" placeholder="Passwords" required id="pwd">
    <input name="email" type="email" placeholder="Email" required>
    <input name="birthdate" type="date" placeholder="Date of Birth (yyyy-mm-dd)" required>
    <input name="submit" type="submit" value="submit">
    <input name="reset" type="reset" value="reset">
</form>
<script>
    function check() {
        var pwd = document.getElementById('pwd').value
        console.log(pwd)
        if (pwd.length <8) {
            return false;
        }
        else {
            return  true;
        }
    }
</script>
</body>
</html>
