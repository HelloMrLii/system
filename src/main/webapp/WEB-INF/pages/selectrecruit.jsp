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
    <script>
        function fun(){
            if(confirm("Are you sure to delete it ？")){
                alert("delete successful")
            }
        }
    </script>
</head>
<body>
    <table cellspacing="0" border="1">
        <tr>
            <td>姓名</td>
            <td>求职岗位</td>
            <td>邮件状态</td>
            <td>操作</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${sessionScope.recruit}" var="recruit">
            <tr>
                <td>${recruit.u_name}</td>
                <td>${recruit.re_job}</td>
                <td>${recruit.re_state}</td>
                <td>
                    <form action="selectresumeid" method="post">
                        <input name="res_id" type="hidden" value="${recruit.res_id}"/>
                        <input value="查看简历" type="submit"/>
                    </form>
                </td>
                <td>
                    <form method="post" action="delectrecruit">
                        <input type="hidden" value="${recruit.re_id}" name="re_id"/>
                        <input type="hidden" value="${recruit.res_id}" name="res_id"/>
                        <input type="submit" onclick="return fun()" value="删除"></input>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
<a href="adminhome">返回</a>
</body>
</html>