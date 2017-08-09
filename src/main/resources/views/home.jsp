<%--
  Created by IntelliJ IDEA.
  User: wujianchuan
  Date: 2017/8/8
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Spitter</title>
</head>
<body>
<h1>Welcome To Spitter</h1>

<a href="<c:url value="/spitters"/> ">Spitters</a>
<a href="<c:url value="/spitter/register"/> ">Register</a>
</body>
</html>
