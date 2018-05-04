<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 15:26
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
    <a href="selectrecruit">查看邮箱</a>
    <a href="selectinviteda">宣布面试结果</a>
    <a href="adddept">添加部门</a>
    <a href="addhotel">添加招聘信息</a>
    <a href="selecthotela">查看招聘信息</a>
    <a href="addtrain">添加培训</a>
    <a href="selecttrain">查看培训信息</a>
    <a href="updatedept">岗位调动</a>
    <a href="selectrewpun">查看奖惩</a>
    <a href="addrewpunadmin">添加奖惩</a>
    <a href="returnlogin">返回登录界面</a>
</body>
</html>