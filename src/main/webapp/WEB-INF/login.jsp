<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/24
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <style type="text/css">
        .a {
            background-color: rgba(255, 255, 255, 0.2);
            border: 1px solid rgba(255, 255, 255, 0.4);
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius:10px;
            height: 200px;
            width: 500px;
            padding: 20px;

            -webkit-transition-duration: 0.25s;
            transition-duration: 0.25s;
        }

    </style>
</head>
<body style="background-image: url('/images/background.jpg'); height: 749px;">
<header>
    <h1 style="color:#f1951d; font-family: 'Times New Roman';">&nbsp;&nbsp; <span class="auto-style1"><strong style="font-size: 40px">iShare</strong></span></h1>
</header>
<br /><div class="a" style="height: 488px; width: 390px; margin-left: 700px; margin-top: 20px;">
    <br /><br />
    <div style="text-align: center">
        登录</div>
    <br />
    <div style="height: 69px" aria-sort="none">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;手机号 或 Email<br />
        <input id="Text1" type="text" /></div>
    <div style="height: 72px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 密码<br />
        <input id="Password1" type="password" /></div>
    <br />
    <div style="height: 58px">
        <input id="Button1" type="button" value="登录" /></div>
    <br />
    <div style="text-align: center">第三方账号登录</div>
    <br />
    <div><img alt="" src="/images/weibo.png" style="width: 123px; margin-left: 10px; " /><img alt="" src="/images/weichat.png" style="width: 123px;" /><img alt="" src="../images/qq.png" style="width: 123px;" /></div>


</div>
<br />
<br />
<br />
<footer style="text-align: center">Copyright © 2018 iShare 版权所有</footer>
</body>
</html>
