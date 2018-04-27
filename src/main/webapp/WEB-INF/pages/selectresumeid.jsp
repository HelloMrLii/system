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
    <script>
        function doValidate() {
             var reg =  /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
            if (!reg.test(document.forma.time.value)){
                alert('时间格式不正确,正确格式为: 2014-01-01');
                document.forma.time.focus();
                return false;
            }
            return true;
        }
    </script>
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
        <td>面试时间</td>
        <td>是否安排面试</td>
    </tr>
    <%
        Resume resume= (Resume) session.getAttribute("resumes");
    %>
    <tr>
        <td> <%=resume.getRes_name()%></td>
        <td><%=resume.getRes_old()%></td>
        <td><%=resume.getRes_education()%></td>
        <td><%=resume.getRes_suffer()%></td>
        <td><%=resume.getRes_phone()%></td>
        <td><%=resume.getRes_idnumber()%></td>
        <form action="insertinvite" method="post" name="forma" onsubmit="return doValidate()">
            <td>
                <input type="text" name="time"/>
            </td>
        <td>
               <input type="hidden" name="u_id" value="<%=resume.getU_id()%>"/>
                <input type="hidden" name="res_id" value="<%=resume.getRes_id()%>"/>
            <input value="发送邀请" type="submit"/>
        </td>
        </form>
    </tr>
</table>
<a href="selectrecruit">返回</a>
</body>
</html>