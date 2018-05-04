<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/2
  Time: 19:12
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
        <td>公司地址</td>
        <td>福利</td>
        <td>公司简介</td>
        <td>上班时间</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${hotel}" var="hotel">
    <form action="updatehotel" method="post">
        <tr>
            <td>${hotel.hot_title}</td>
            <td><input type="text" value="${hotel.hot_money}" name="hot_money"></td>
            <td>${hotel.hot_rel_time}</td>
            <td>${hotel.hot_post}</td>
            <td><input type="text" value="${hotel.hot_require}" name="hot_require"/></td>
            <td><input type="text" value="${hotel.hot_site}" name="hot_site"/></td>
            <td><input type="text" value="${hotel.hot_welfare}" name="hot_welfare"/></td>
            <td><input type="text" value="${hotel.hot_intro}" name="hot_intro"></td>
            <td><input type="text" value="${hotel.hot_work_time}" name="hot_work_time"></td>
            <td>
                <input type="hidden" value="${hotel.hot_id}" name="hot_id"/>
                <input type="hidden" value="${hotel.hot_title}" name="hot_title"/>
                <input type="hidden" value="${hotel.hot_rel_time}" name="hot_rel_time">
                <input type="hidden" value="${hotel.hot_post}" name="hot_post"/>
                <input type="submit" value="修改"/>
            </td>
    </form>
        <td>
            <form method="post"action="delecthotel">
                <input type="hidden" value="${hotel.hot_id}" name="hot_id"/>
                <input type="submit" value="删除"/>
            </form>
        </td>
        </c:forEach>
</table>
<a href="adminhome">返回</a>
</body>
</html>