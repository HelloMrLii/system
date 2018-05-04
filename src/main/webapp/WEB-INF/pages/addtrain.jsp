<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 0:15
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
    <script type="text/javascript" src="<%=basePath%>/js/wdatePicker.js"></script>
    <script>
        document.getElementById('t_start_time').valueAsDate = new Date();
        document.getElementById('t_over_time').valueAsDate = new Date();
    </script>
</head>
<body>
<form method="post" action="inserttrain">
    <table cellspacing="0" border="1">
        <tr>
            <td>开始时间</td>
            <td><input type="datetime-local" name="start_Time" id="t_start_time"/></td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td>
                <input type="datetime-local" name="over_Time" <%--value="2015/03/27 10:41"--%> id="t_over_time"/>
            </td>
        </tr>
        <tr>
            <td>
                地点
            </td>
            <td>
                <input type="text" name="t_site"/>
            </td>
        </tr>
        <tr>
            <td>
                参加培训部门
            </td>
            <td>
                <select name="t_dept">
                    <c:forEach items="${dept}" var="dept">
                        <option value="${dept.dept_name}">${dept.dept_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                培训内容
            </td>
            <td>
                <input type="text" name="t_content"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="提交">
    <a href="adminhome">返回</a>
</form>
</body>
</html>