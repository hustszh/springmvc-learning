<%--
  Created by IntelliJ IDEA.
  User: suzh
  Date: 8/29/2017
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    所在城市：<select name="workInfo.city">
    <c:forEach items="${cityList }" var="city">
        <option value="${city }"
                <c:if test="${user.workInfo.city eq city}">selected="selected"</c:if>
        >
                ${city}
        </option>
    </c:forEach>
</select><br/>
    职位：<input type="text" name="workInfo.job" value="${user.workInfo.job}"/><br/>
    工作年限：<input type="text" name="workInfo.year" value="${user.workInfo.year}"/><br/>
    <input type="submit" name="_target1" value="上一步"/>
    <input type="submit" name="_finish" value="完成"/>
    <input type="submit" name="_cancel" value="取消"/>
    <!--
    当前页码为2；
    name="_target1"：上一步，表示向导上一步要显示的页面的页码为1；
    name="_finish"：向导完成，表示向导成功，将会调用向导控制器的processFinish方法；
    name="_cancel"：向导取消，表示示向导被取消，将会调用向导控制器的processCancel方法；
    -->
</form>
</body>
</html>
