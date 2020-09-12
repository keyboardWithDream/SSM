<%--
  Created by IntelliJ IDEA.
  User: Harlan
  Date: 2020/9/12
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC</title>
</head>
<body>
<h1>测试查询</h1>
<a href="/account/findAll">测试查询</a>
<h1>测试保存</h1>
<form action="/account/saveAccount" method="post">
    <label for="name">姓名:</label><input type="text" name="name" id="name" placeholder="姓名">
    <label for="money">金额:</label><input type="number" name="money" id="money" placeholder="金额">
    <input type="submit" value="提交">
</form>
</body>
</html>
