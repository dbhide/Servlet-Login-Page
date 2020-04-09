<%--
  Created by IntelliJ IDEA.
  User: Bhide
  Date: 08-04-2020
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<h1>Hi <%= request.getAttribute("userName")%>, Login Successful</h1>
<a href="login.html">Login Page</a>
</body>
</html>
