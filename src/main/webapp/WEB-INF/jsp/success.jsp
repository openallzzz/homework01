<%--
  Created by IntelliJ IDEA.
  User: 18028
  Date: 2023/3/2
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示合法的学生信息</title>
</head>
<body>

    <table>
        <th>学生信息展示</th>
        <jsp:useBean id="userList" scope="request" type="java.util.List"/>

        <c:forEach items="${userList}" var = "user">
            <tr>
                <td> [id = ${user.id}, </td>
                <td> username = ${user.username}, </td>
                <td> age = ${user.age}, </td>
                <td> birthDay = ${user.birthDay}, </td>
                <td> sex = ${user.sex}] </td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
