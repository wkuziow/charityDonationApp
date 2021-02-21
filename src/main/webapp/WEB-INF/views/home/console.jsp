<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 23.07.2020
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pl-PL">
<head>

    <title>Panel zarządzania</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="/WEB-INF/include/header.jsp" %>


<ul class="container container--70">
    <li><a href="/console/allInstitutions" class="btn btn--without-border">Lista fundacji</a></li>
    <li><a href="/addInstitution" class="btn btn--without-border">Dodaj nową fundację</a></li>
</ul>

<%@include file="/WEB-INF/include/footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
