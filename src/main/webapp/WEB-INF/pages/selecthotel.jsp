<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 16:11
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
    <table border="1" cellspacing="0">
        <tr>
            <td>公司</td>
            <td>月薪</td>
            <td>发布时间</td>
            <td>职位</td>
            <td>要求</td>
            <td>投递简历</td>
        </tr>
        <c:forEach items="${sessionScope.hotel}" var="hotel">
            <tr>
                <td>${hotel.HOT_TITLE}</td>
                <td>${hotel.HOT_MONEY}</td>
                <td>${hotel.HOT_REL_TIME}</td>
                <td>${hotel.HOT_POST}</td>
                <td>${hotel.HOT_REQUIRE}</td>
                <td>
                    <form method="post" action="addrecruit">
                            <select name="RES_TITLE">
                                <c:forEach items="${sessionScope.resume}" var="resume">
                                <option>${resume.RES_TITLE}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="RE_JOB" value="${hotel.HOT_POST}"/>
                            <input type="submit" value="投递"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
<a href="skip">返回</a>
</body>
</html>