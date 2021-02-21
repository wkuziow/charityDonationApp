<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 15.07.2020
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl-PL">
<head>

    <title>Dziękujemy za rejestrację</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="/WEB-INF/include/header.jsp" %>


<div class="slogan container container--90">
    <h2>
        Dziękujemy za rejestrację w naszej aplikacji.
    </h2>
</div>

<%@include file="/WEB-INF/include/footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
