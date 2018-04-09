<%@ page import="org.starrier.ishare.entity.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Starrier
  Date: 2018/3/23
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
  <% UserBean user= (UserBean) (request.getAttribute("USER")); %>

   登录成功，欢迎！<% user.getUsername();%>!


</body>
</html>
