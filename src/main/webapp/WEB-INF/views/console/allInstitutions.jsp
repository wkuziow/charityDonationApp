<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 23.07.2020
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pl-PL">
<head>

    <title>Lista wszystkich fundacji</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="/WEB-INF/include/header.jsp" %>

<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Nazwa</td>
        <td>Opis</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allInstitutions}" var="institution">
        <tr>
            <td>${institution.id}</td>
            <td>${institution.name}</td>
            <td>${institution.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<ul>
    <li><a href="/console" class="btn btn--without-border">Panel zarządzania</a></li>
    <li><a href="/console/addInstitution" class="btn btn--without-border">Dodaj fundację</a></li>
</ul>


<%@include file="/WEB-INF/include/footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
