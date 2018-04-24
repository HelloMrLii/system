<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
<fieldset>
    <legend>登录界面</legend>
    <form action="login" method="post">
        账号：<input name="U_NAME"><br>
        密码：<input name="U_PASS"><br>
        <input type="submit" value="登录">
    </form>
    <h4 style="color: red">${error}</h4>
</fieldset>
<a href="insert">注册</a>
</body>
</html>
