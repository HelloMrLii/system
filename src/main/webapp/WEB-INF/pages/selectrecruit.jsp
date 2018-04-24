<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 15:37
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
    <table cellspacing="0" border="1">
        <tr>
            <td>姓名</td>
            <td>求职岗位</td>
            <td>邮件状态</td>
            <td>操作</td>
            <td>是否面试</td>
        </tr>
        <c:forEach items="${sessionScope.recruit}" var="recruit">
            <tr>
                <td>${recruit.U_NAME}</td>
                <td>${recruit.RE_JOB}</td>
                <td>${recruit.RE_STATE}</td>
                <td>
                    <form action="selectresumeid" method="post">
                        <input name="RES_ID" type="hidden" value="${recruit.RES_ID}"/>
                        <input value="查看简历" type="submit"/>
                    </form>
                </td>
                <td>
                    <form method="post" action="">

                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>