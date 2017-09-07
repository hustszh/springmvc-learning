<%--
  Created by IntelliJ IDEA.
  User: suzh
  Date: 8/29/2017
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/delegate?action=delete" method="post">
    用户名： <input type="text" name="username" value="${command.username}"/><br/>
    真实姓名：<input type="text" name="realname" value="${command.realname}"/><br/>
    <input type="submit" name="delete" value="删除"/>
</form>
</body>
</html>
