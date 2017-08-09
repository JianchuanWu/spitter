<%--
  Created by IntelliJ IDEA.
  User: wujianchuan
  Date: 2017/8/9
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Recent Spitters</title>
</head>
<body>
<c:forEach items="${spitterList}" var="spitter">
    <li id="spitter_<c:out value="spitter.id"/>">
        <div>
            <c:out value="${spitter.message}"/>
        </div>
        <div>
            <span class="spitterTime"><c:out value="${spitter.time}"/></span>
            <span class="spitterLocation">
                (<c:out value="${spitter.latitude}"/>,
                <c:out value="${spitter.longitude}"/>)
            </span>
        </div>
    </li>
</c:forEach>
</body>
</html>
