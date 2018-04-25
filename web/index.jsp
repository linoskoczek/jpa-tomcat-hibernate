<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 4/24/18
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Please log in</title>
</head>
<body>
<form method="POST" action="/login">
  <input type="text" placeholder="Login" name="login" />
  <input type="password" placeholder="Password" name="password" />
  <input type="submit" value="Log in" />
</form>
</body>
</html>
