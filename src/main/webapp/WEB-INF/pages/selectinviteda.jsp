<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 19:11
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
            <td>面试地点</td>
            <td>面试时间</td>
            <td>邮件状态</td>
            <td>面试状态</td>
            <td>是否录用</td>
        </tr>
        <c:forEach items="${sessionScope.inviteda}" var="invited">
            <tr>
                <td>${invited.inv_site}</td>
                <td>${invited.inv_time}</td>
                <td>${invited.inv_state}</td>
                <td>${invited.inv_pass}</td>
                <td>
                    <div style="float: left;width: 50%">
                        <form action="addemp" method="post">
                            <input type="hidden" value="${invited.u_id}" name="u_id"/>
                            <input type="submit" value="是"/>
                        </form>
                    </div>
                    <div style="float: right;width: 50%">
                        <form action="updateinviteda" method="post">
                            <input type="hidden" value="${invited.inv_id}" name="inv_id"/>
                            <input type="hidden" name="res" value="否"/>
                            <input type="submit" value="否"/>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>