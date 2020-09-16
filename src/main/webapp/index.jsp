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
    <title>SSM</title>
    <script src="js/jquery-3.5.1/jquery-3.5.1.js" type="text/javascript"></script>
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
<h1 id="show"></h1>
<form>
    <input id="num" type="number" name="num">
    <input id="submit" type="button" value="GO">
</form>
<script>
    $(function () {
        $("#submit").click(function () {
            const num = $("#num").val();
            $.post("/account/guess", {num}, function callback(data){
                $("#show").html(data);
            })
        })
    })
</script>
</body>
</html>
