<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 15.07.2020
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pl-PL">
<head>

    <title>Zarejestruj się</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="/WEB-INF/include/header.jsp" %>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form autocomplete="off" action="#" method="post"
               modelAttribute="user">
        <div class="form-group">
            <label for="firstNameId">Imię: </label>
            <form:input type="text" path="firstName" id="firstNameId" name="firstName" placeholder="imię"
                        required="true"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="lastNameId">Nazwisko: </label>
            <form:input type="text" path="lastName" id="lastNameId" name="lastName" placeholder="nazwisko"
                        required="true"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="emailId">Email: </label>
            <form:input type="email" path="email" id="emailId" name="email" placeholder="email"
                        required="true"/>
            <form:errors path="email" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="passwordId">Hasło: </label>
            <form:input type="password" path="password" id="passwordId"
                        placeholder="hasło"  required="true"/>
            <form:errors path="password" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="confirmPasswordId" >Potwierdź hasło: </label>
            <form:input type="password" path="confirmPassword" id="confirmPasswordId"
                        placeholder="potwierdź hasło"  required="true"/>
            <form:errors path="" cssClass="error"/>
        </div>

        <div class="form-group form-group--buttons">
<%--            <a href="login.html" class="btn btn--without-border">Zaloguj się</a> --%>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="/WEB-INF/include/footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
