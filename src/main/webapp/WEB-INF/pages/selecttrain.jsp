<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 13:19
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
    <table border="1" cellspacing="0">
        <tr>
            <td>培训开始时间</td>
            <td>培训结束时间</td>
            <td>培训地点</td>
            <td>培训部门</td>
            <td>培训内容</td>
            <td>进展情况</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${train}" var="train">
        <form action="updatetrain" method="post">
            <tr>
                <td><fmt:formatDate value="${train.t_start_time}" pattern="yyyy-MM-dd HH:mm"/> </td>
                <td><fmt:formatDate value="${train.t_over_time}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td><input type="text" value="${train.t_site}" name="t_site"/></td>
                <td><input type="text" value="${train.t_dept}" name="t_Dept"/></td>
                <td><input type="text" value="${train.t_content}" name="t_content"/></td>
                <td>${train.t_ps}</td>
                <td>
                  <input type="hidden" value="${train.t_ps}" name="t_ps"/>
                    <input type="hidden" value="${train.t_id}" name="t_id">
                    <input value="${train.t_start_time}" type="hidden" name="t_start_time"/>
                    <input type="hidden" value="${train.t_over_time}" name="t_over_time">
                    <input type="submit" value="确认">
                </td>
        </form>
            <td>
                <form method="post" action="delecttrain">
                    <input type="hidden" name="t_id" value="${train.t_id}"/>
                    <input type="hidden" name="t_ps" value="${train.t_ps}"/>
                    <input value="删除" type="submit"/>
                </form>
            </td>
            </tr>
        </c:forEach>
    </table>
<a href="adminhome">返回</a>
</body>
</html>