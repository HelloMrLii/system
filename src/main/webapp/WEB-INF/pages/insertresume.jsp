<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 17:56
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
            var phoneNumReg = /^1[3|4|5|7|8]\d{9}$/
            if (!phoneNumReg.test(document.forma.RES_PHONE.value)){
                alert('手机号码有误，请重填，手机号码11位数字，目前支持前两位13、14、15、16、17、18手机号码');
                document.forma.RES_PHONE.focus();
                return false;
            }
             var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if (!reg.test(document.forma.RES_IDNUMBER.value)){
                alert('身份证输入不合法');
                document.forma.RES_IDNUMBER.focus()
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <form action="insertresume" method="post"name="forma" onsubmit="return doValidate()">
        标题：<input type="text" name="RES_TITLE"/><br>
        性名：<input type="text" name="RES_NAME"/><br>
        性别：男<input type="radio" name="RES_SEX" checked="checked"value="男"/>
        女<input type="radio" name="RES_SEX" checked="checked"value="女"/><br>
        年龄：
        <select name="RES_OLD">
            <%
                for (int i= 18;i<50;i++){
            %>
            <option>
                <%=i%>
            </option>
            <%
                }
            %>
        </select><br>
        学历：<select name="RES_EDUCATION">
        <option>小学</option><option>初中</option><option>中职</option><option>高中</option><option>大专</option><option>本科</option>
    </select><br>
        工作经验：<input name="RES_SUFFER" maxlength="50" type="text"><br>
        电话：<input type="text" maxlength="11" minlength="11" name="RES_PHONE"/><br>
        身份证号码：<input type="text" maxlength="18" minlength="18" name="RES_IDNUMBER">
        <input value="提交" type="submit"/>
    </form>
<a href="myself">返回</a>
</body>
</html>