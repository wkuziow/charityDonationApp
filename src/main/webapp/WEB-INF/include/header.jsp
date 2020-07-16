<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <c:choose>
                <c:when test="${currentUserFullName != -1}">
                    <%@include file="/WEB-INF/views/welcome.jsp" %>
                    <%@include file="/WEB-INF/views/logout.jsp" %>
                </c:when>
                <c:otherwise>
                    <li><a href="/register" class="btn btn--small btn--highlighted">Za&#322&#243&#380 konto</a></li>
                    <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                </c:otherwise>
            </c:choose>
        </ul>

        <ul>
            <li><a href="#" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/addDonation" class="btn btn--without-border">Przeka&#380; dary</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomaga&#263!<br/>
                Oddaj niechciane rzeczy w zaufane r&#281ce
            </h1>
        </div>
    </div>
</header>