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
            <td>公司地址</td>
            <td>福利</td>
            <td>公司简介</td>
            <td>上班时间</td>
            <td>投递简历</td>
        </tr>
        <c:forEach items="${sessionScope.hotel}" var="hotel">
            <tr>
                <td>${hotel.hot_title}</td>
                <td>${hotel.hot_money}</td>
                <td>${hotel.hot_rel_time}</td>
                <td>${hotel.hot_post}</td>
                <td>${hotel.hot_require}</td>
                <td>${hotel.hot_site}</td>
                <td>${hotel.hot_welfare}</td>
                <td>${hotel.hot_intro}</td>
                <td>${hotel.hot_work_time}</td>
                <td>
                    <form method="post" action="addrecruit">
                            <select name="res_title">
                                <c:forEach items="${sessionScope.resume}" var="resume">
                                <option>${resume.res_title}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="re_job" value="${hotel.hot_post}"/>
                            <input type="submit" value="投递"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
<a href="skip">返回</a>
</body>
</html>