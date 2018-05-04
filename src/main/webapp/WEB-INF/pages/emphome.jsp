<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 9:59
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
    <legend>通知</legend>
    <c:forEach items="${train}" var="train">
        <c:if test="${train!=null}">
            培训时间：${train.t_start_time}结束时间:${train.t_over_time}培训地点:${train.t_site}培训部门：${train.t_dept}培训内容：${train.t_content}
        </c:if>
    </c:forEach>
</fieldset>


</body>
</html>