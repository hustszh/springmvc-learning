<%--
  Created by IntelliJ IDEA.
  User: suzh
  Date: 8/30/2017
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form commandName="user">

    <%--<form:errors path="*" cssStyle="color:red"></form:errors><br/>--%>

    username:<form:input path="username"/>
    <!-- form:errors path="username"：表示只显示username字段的错误信息；-->
    <form:errors path="username" cssStyle="color:red"></form:errors>
    <br/>

    password:<form:password path="password"/>
    <form:errors path="password" cssStyle="color:red"></form:errors>
    <br/>
    <input type="submit" value="注册"/>
</form:form>
</body>
</html>
