<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 17.07.2020
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li class="nav-item">
    <form action="<c:url value="/logout"/>" method="post">
        <a> <input type="submit" value="Wyloguj"></a>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</li>
