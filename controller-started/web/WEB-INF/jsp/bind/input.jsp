<%--
  Created by IntelliJ IDEA.
  User: suzh
  Date: 8/30/2017
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 表单的命令对象名为dataBinder -->
<form:form commandName="dataBinder">
    <!--
    显示错误消息，当提交表单有错误时展示错误消息（数据绑定错误/数据不合法）
    -->
    <form:errors path="*" cssStyle="color:red"></form:errors><br/><br/>

    bool:<form:input path="bool"/><br/>
    phoneNumber:<form:input path="phoneNumber"/><br/>
    date:<form:input path="date"/><br/>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>
