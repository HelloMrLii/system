<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
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
        <legend>注册界面</legend>
        <form action="register" method="post">
            姓名：<input type="text" name="U_NAME"/><br>
            密码：<input type="text" name="U_PASS"/><br>
            <input type="submit" value="注册">
        </form>
    </fieldset>
</body>
</html>