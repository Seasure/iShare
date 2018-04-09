<%--
  Created by IntelliJ IDEA.
  User: Starrier
  Date: 2018/3/23
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register<sx:head></sx:head></title>
</head>
<body>
<s:form action="register" method="POST">
    <s:textfield name="loginUser.account" label="请输入用户名"/>
    <s:password name="loginUser.password" label="请输入密码"/>

    <s:submit value="注册"></s:submit>
    <s:reset value="重置"/>
</s:form>

</body>
</html>
