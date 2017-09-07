<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!--需要导入jstl.jar包-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
    <form method="post">
        username:<input type="text" name="name" value="${user.username}"><br/>
        password:<input type="password" name="password"><br/>
        city:<select>
        <c:forEach items="${cityList}" var="city">
            <option>${city}</option>
        </c:forEach>
    </select><br/>
        <input type="submit" value="Register"/>
        <!-- 该提交按钮的作用是取消，因为name="_cancel"，即请求后会有一个名字为_cancel的参数，因此会执行onCancel功能处理方法。-->
        <input type="submit" name="_cancel" value="Cancel"/>
    </form>
</body>
</html>