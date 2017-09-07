<%--
  Created by IntelliJ IDEA.
  User: suzh
  Date: 8/29/2017
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    真实姓名:<input type="text" name="realname" value="${user.realname}"><br/>
    <input type="submit" name="_target1" value="下一步"/>
    <!-- 当前页码为0；name="_target1"：表示向导下一步要显示的页面的页码为1；-->
</form>
</body>
</html>
