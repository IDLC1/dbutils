<%--
  Created by IntelliJ IDEA.
  User: digispark
  Date: 2020/4/16
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>登录</h3>
<%--    <form action="/user/login" method="post" >--%>
    <div>
        账号：<input type="text" name="account" id="acc"/><br/>
        密码：<input type="text" name="password" id="pwd" /><br/>
<%--        <input type="submit" value="提交">--%>
        <button id="loginBtn">登录</button>
    </div>
    <a href="/user/reg">注册</a>

</body>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/common.js"></script>
</html>
