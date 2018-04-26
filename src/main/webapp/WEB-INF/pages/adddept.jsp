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
    <script type="text/javascript" src="pages/jquery-3.1.0.js"></script>
    <script>
        function a() {
            $("#_input").val($("#select option:selected").text());
        }
    </script>
    <style>
        *{
            margin: 0px auto;
            padding: 0px auto;
        }
    </style>
</head>
<body>

    <div style="text-align: center;margin-top: 10px">
        <select id="select" onchange="a()">
            <c:forEach items="${dept}" var="dept">
                <option>${dept.dept_name}</option>
            </c:forEach>
        </select>
    </div>
    <form action="insertdept" method="post">
        部门： <input type="text" id="_input" name="dept_name"/>
        职位:<input type="text" name="post_name"/>
        <input type="submit" value="添加">
</form>

</body>
</html>