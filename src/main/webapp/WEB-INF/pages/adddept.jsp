<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/26
  Time: 0:10
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
    <script type="text/javascript" src="js/jquery-3.1.0.js"></script>
    <script>
        function a() {
            console.log($('#select').val());
            $('#dept_name').val($('#select').val());
        }
    </script>
</head>
<body>
    <form action="insertdept" method="post" name="forml">

        部门： <input type="text" id="dept_name" name="dept_name"/>

        <select name="select" onchange="a()" id="select">
            <c:forEach items="${dept}" var="dept">
                <option value="${dept.dept_name}">${dept.dept_name}</option>
            </c:forEach>
        </select>

        职位:<input type="text" name="post_name"/>
        <input type="submit" value="添加">
</form>
<a href="adminhome">返回</a>
</body>
</html>