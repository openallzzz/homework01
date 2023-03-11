<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示合法的学生信息</title>
</head>
<body>

<h2 align="center" >学生信息展示</h2>
<c:if test="${userList != null && userList.size() > 0}">
<table align="center" border="1" cellspacing="0">
    <jsp:useBean id="userList" scope="request" type="java.util.List"/>
    <tr align="center">
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
        <th>性别</th>
    <tr>
    <c:forEach items="${userList}" var = "user">
        <tr>
            <td> id = ${user.id}</td>
            <td> username = ${user.username}</td>
            <td> age = ${user.age} </td>
            <td> birthDay = ${user.birthDay}</td>
            <td> sex = ${user.sex} </td>
        </tr>
    </c:forEach>
</table>
</c:if>

<br>
<div align="center">
    <button><a href="${pageContext.request.contextPath}/students/clear" style="color: red; text-decoration: none">清空学生信息</a></button>
    <button><a href="${pageContext.request.contextPath}/students/input" style="text-decoration: none; color: black">想继续添加？点击这里</a></button>
</div>
</body>
</html>
