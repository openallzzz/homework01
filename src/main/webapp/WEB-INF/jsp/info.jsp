<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>输入用户信息</title>
</head>
<body>
<%--@elvariable id="user" type="org.zzzzzz.pojo.User"--%>
<form:form modelAttribute="user" method="post"
           action="${pageContext.request.contextPath}/students/save-of-one">

    <table border="0" cellspacing="" cellpadding="">
        <tr>
            <td>学号：</td>
            <td><form:input type="text" path="id"/></td>
            <td><font color="red"><form:errors path = "id"/></font></td>
        </tr>

        <tr>
            <td>姓名：</td>
            <td><form:input type="text" path="username"/></td>
            <td><font color="red"><form:errors path = "username"/><br></font></td>
        </tr>

        <tr>
            <td>年龄：</td>
            <td><form:input type="text" path="age"/></td>
            <td><font color="red"><form:errors path = "age"/><br></font></td>

        </tr>

        <tr>
            <td>生日：</td>
            <td><form:input type="text" placeholder="格式：yyyy-MM-dd" path="birthDay"/></td>
        </tr>

        <tr>
            <td>性别：</td>
            <td><form:input type="text" path="sex"/></td>
            <td><font color="red"><form:errors path = "sex"/><br></font></td>
        </tr>

        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>

    </table>

</form:form>
</body>
</html>
