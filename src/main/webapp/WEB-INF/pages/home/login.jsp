<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
欢迎${userName}进入，现在数据库中有如下用户：
<br/>
<table >
    <thead>
    <tr role="row">
        <th  style="width: 150px;color: black;">用户</th>
        <th  style="width: 150px;color: black;">用户IP地址</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allUser}" var="user">
        <tr  role="row">
            <td>
                <c:out value="${user.userName}"/>
            </td>
            <td>
                <c:out value="${user.userIp}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>