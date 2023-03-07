<%--
  Created by IntelliJ IDEA.
  User: 18028
  Date: 2023/3/2
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>显示信息的JSON格式</title>
</head>
<body>


<%--@elvariable id="user" type="org.zzzzzz.pojo.User"--%>
<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/students/show">

    <table border="0" cellspacing="" cellpadding="">
        <tr>
            <td width="50px">学号：</td><td align="left"><form:input type="text" path="id"/></td>
        </tr>

        <tr>
            <td width="50px">姓名：</td><td align="left"><form:input type="text" path="username"/></td>
        </tr>

        <tr>
            <td width="50px">年龄：</td><td align="left"><form:input type="text" path="age"/></td>
        </tr>

        <tr>
            <td width="50px">生日：</td><td align="left"><form:input type="text" path="birthDay"/>（格式：yyyy-MM-dd）</td>
        </tr>

        <tr>
            <td width="50px">性别：</td><td align="left"><form:input type="text" path="sex"/></td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="提交">
            </td>

            <td>
                <input type="reset" value="重置">
            </td>
        </tr>

    </table>
</form:form>

</body>
</html>
