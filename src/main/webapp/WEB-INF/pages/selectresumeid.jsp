<%@ page import="com.iotek.model.Resume" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 16:09
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
        <td>姓名</td>
        <td>年龄</td>
        <td>学历</td>
        <td>工作经验</td>
        <td>电话号码</td>
        <td>身份证号码</td>
        <td>是否安排面试</td>
        <td>操作</td>
    </tr>
    <%
        Resume resume= (Resume) session.getAttribute("resumes");
    %>
    <tr>
        <td> <%=resume.getRES_NAME()%></td>
        <td><%=resume.getRES_OLD()%></td>
        <td><%=resume.getRES_EDUCATION()%></td>
        <td><%=resume.getRES_SUFFER()%></td>
        <td><%=resume.getRES_PHONE()%></td>
        <td><%=resume.getRES_IDNUMBER()%></td>
        <td>
            <form action="" method="post">

            </form>
        </td>
    </tr>
</table>
</body>
</html>