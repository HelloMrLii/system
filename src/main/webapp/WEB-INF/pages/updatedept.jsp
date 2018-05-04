<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 16:16
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
        function a() {
            console.log($("#select").val());
            $("#name").val($("#select").val())
        }
        $(function () {
            $('#dept').change(function () {
                $.ajax({
                    type:"post",
                    url:"selectpostid",
                    data:{"dept_id":$(this).val()},
                    success:function (obj) {
                        console.log(obj);
                        $('#post').empty();
                        for (var i=0;i<obj.length;i++){
                            $('#post').append("<option value='"+obj[i].post_id+"'>"+obj[i].post_name+"</option>")
                        }
                    }
                });
            })
        })
    </script>
</head>
<body>
<form action="updateempdept" method="post">
    姓名：<input type="text" id="name" name="emp_real_name"/>
    <select name="select"onchange="a()" id="select">
        <option>--请选择--</option>
    <c:forEach items="${emp}" var="emp">
        <option value="${emp.emp_real_name}">${emp.emp_real_name}</option>
    </c:forEach>
</select>
    调动部门：<select id="dept" name="dept_id">
    <option>--请选择--</option>
    <c:forEach items="${dept}" var="dept">

        <option value="${dept.dept_id}">${dept.dept_name}</option>
    </c:forEach>
</select>
    调动职位：<select id="post" name="post_id">
</select>
    <input value="提交" type="submit"/>
</form>


</select>
</body>
</html>