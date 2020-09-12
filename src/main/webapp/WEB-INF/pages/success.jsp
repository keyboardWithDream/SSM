<%--
  Created by IntelliJ IDEA.
  User: Harlan
  Date: 2020/9/12
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>运行成功!</title>
</head>
<body>
<h1>运行成功</h1>
<c:forEach items="${accounts}" var="account">
     ${account.toString()}
    <br>
</c:forEach>
</body>
</html>
