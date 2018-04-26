<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 0:19
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
    <script>
        function doValidate() {
            var state="未阅读";
            if (!state.test(document.forma.res_read_state.value)){
                alert('此简历尚未批阅，无法删除');
                document.forma.res_read_state.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<table border="1" cellspacing="0">
    <tr>
        <td>标题</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>学历</td>
        <td>工作经验</td>
        <td>电话号码</td>
        <td>身份证号码</td>
        <td>是否投递</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${sessionScope.resume}" var="resume">
        <tr>
            <td>${resume.res_title}</td>
            <td>${resume.res_name}</td>
            <td>${resume.res_sex}</td>
            <td>${resume.res_old}</td>
            <td>${resume.res_education}</td>
            <td>${resume.res_suffer}</td>
            <td>${resume.res_phone}</td>
            <td>${resume.res_idnumber}</td>
            <td>${resume.res_state}</td>
            <td>
                <form method="post" action="delectresume" name="forma" onsubmit="return doValidate()">
                    <input value="${resume.res_id}" type="hidden" name="res_id"/>
                    <input name="res_read_state" value="${resume.res_read_state}" type="hidden"/>
                    <input type="submit" value="删除">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="skip">返回</a>
</body>
</html>