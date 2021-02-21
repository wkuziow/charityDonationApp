<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 12.07.2020
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pl-PL">
<head>

    <title>Przekaż dary</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="/WEB-INF/include/header.jsp" %>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Oddaj rzeczy, których już nie chcesz<br/>
            <span class="uppercase">potrzebującym</span>
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span>Wybierz rzeczy</span></div>
                </li>
                <li>
                    <div><em>2</em><span>Spakuj je w worki</span></div>
                </li>
                <li>
                    <div><em>3</em><span>Wybierz fundację</span></div>
                </li>
                <li>
                    <div><em>4</em><span>Zamów kuriera</span></div>
                </li>
            </ul>
        </div>
    </div>
</div>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">

        <c:choose>
            <c:when test="${not empty errors}">
                <div class="error">
                    <c:forEach items="${errors}" var="err">
                        ${err}
                        <br>
                    </c:forEach>
                </div>
            </c:when>
        </c:choose>

        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <c:forEach var="category" items="${categoriesList}">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input
                                    type="checkbox"
                                    name="categories"
                                    value="${category.id}"
                            />
                            <span class="checkbox"></span>
                            <span class="description">${category.name}</span
                            >
                        </label>
                    </div>
                </c:forEach>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba worków:
                        <input type="number" id="numberOfBags" name="bags" step="1" min="1"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>


            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>
                <c:forEach var="instittutions" items="${institutionList}">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="organization" id="institutionId" value="${instittutions.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                  <div class="title" id="institutionName">${instittutions.name}</div>
                  <div class="subtitle">
                          ${instittutions.description}
                  </div>
                </span>
                        </label>
                    </div>
                </c:forEach>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <input type="text" name="address" id="adress"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <input type="text" name="city" id="city"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <input type="text" name="postcode" id="postcode"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <input type="phone" name="phone" id="phone"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <input type="date" name="data" id="date"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <input type="time" name="time" id="time"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <textarea name="more_info" rows="5" id="comment"></textarea>
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step" id="summaryButton">Podsumowanie</button>
                </div>
            </div>


            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">


                        <h4>Oddajesz:</h4>
                        <form:form method="post">
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                     <input type="hidden" id="numberOfBagsSummaryHidden" name="numberOfBagsSummary"
                                            value="">
                                    <input type="hidden" id="categorriesSummaryHidden" name="categorriesSummary"
                                           value="">
                                    <div id="numberOfBagsSummary"></div>
                                </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <input type="hidden" id="institutionSummaryHidden" name="institutionSummary"
                                       value="">
                                <span class="summary--text"> <div id="institutionSummary"></div></span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="adressSummary"></li>
                                <input type="hidden" id="adressSummaryHidden" name="adressSummary"
                                       value="">
                                <li id="citySummary"></li>
                                <input type="hidden" id="citySummaryHidden" name="citySummary"
                                       value="">
                                <li id="postCodeSummary"></li>
                                <input type="hidden" id="postCodeSummaryHidden" name="postCodeSummary"
                                       value="">
                                <li id="phoneSummary"></li>
                                <input type="hidden" id="phoneSummaryHidden" name="phoneSummary"
                                       value="">
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="pickUpDateSummary"></li>
                                <input type="hidden" id="pickUpDateSummaryHidden" name="pickUpDateSummary"
                                       value="">
                                <li id="pickUpTimeSummary"></li>
                                <input type="hidden" id="pickUpTimeSummaryHidden" name="pickUpTimeSummary"
                                       value="">
                                <li id="pickUpCommentsSummary"></li>
                                <input type="hidden" id="pickUpCommentsSummaryHidden" name="pickUpCommentsSummary"
                                       value="">
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
                </form:form>
            </div>
        </form>
    </div>
</section>


<%@include file="/WEB-INF/include/footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

