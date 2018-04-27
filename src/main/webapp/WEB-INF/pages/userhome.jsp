<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 11:01
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
<a href="selecthotel">浏览招聘信息</a>
<a href="addresume">创建简历</a>
<a href="selectresume">浏览简历</a>
<a href="selectinvited">查看邮箱</a>
<a href="returnlogin">返回登录界面</a>
<fieldset>
    <legend>消息通知</legend>
    <c:if test="${sessionScope.emp!=null}">
        您已被本公司录用，您的员工账号为:${sessionScope.emp.emp_name}，密码为：${sessionScope.emp.emp_pass}
    </c:if>
</fieldset>
</body>
</html>