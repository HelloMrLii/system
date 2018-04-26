<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/26
  Time: 13:37
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
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $('#dept').change(function () {
                $.ajax({
                    type:"post",
                    url:"selectpost",
                    data:{"dept_name":$(this).val()},
                    success:function (obj) {
                        console.log(obj);
                        for (var i=0;i<obj.length;i++){
                            $('#post').append("<option value='"+obj[i].post_name+"'>"+obj[i].post_name+"</option>")
                        }
                    }
                });
            })
        })
    </script>


</head>
<body>
<form action="inserthotel" method="post">
    公司：<input type="text" name="hot_title"/><br>
    月薪：<input type="number" name="hot_money"/><br>
    工作岗位：<br>
    部门：<select id="dept" name="dept">
    <c:forEach items="${depts}" var="dept">
        <option>-请选择部门-</option>
        <option value="${dept.dept_name}">${dept.dept_name}</option>
    </c:forEach>
</select>
    职位：<select id="post" name="post">
</select><br>
    要求：<input type="text" name="hot_require"/><br>
    公司地址：<input type="text" name="hot_site"/><br>
    福利：<input type="text" name="hot_welfare"/><br>
    公司简介：<input width="50px" height="100px" type="text" name="hot_intro"/><br>
    上班时间：<input type="text" name="hot_work_time"/><br>
    <input type="submit" value="提交"/>
</form>

</body>
</html>