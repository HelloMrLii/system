<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 23:02
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
<form method="post" action="insertrewpunadmin">
    <table>
        <tr>
            <td>员工</td>
            <td>
                <select name="emp_id">
                    <c:forEach items="${emp}" var="emp">
                        <option value="${emp.emp_id}">${emp.emp_real_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>原因</td>
            <td>
                <input type="text" name="rewpun_reason"/>
            </td>
        </tr>
        <tr>
            <td>奖惩金额</td>
            <td>
                <input type="text" name="rewpun_money"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="确定"/>
    <a href="adminhome">返回</a>
</form>
</body>
</html>