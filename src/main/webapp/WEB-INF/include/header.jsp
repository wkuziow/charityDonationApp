<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <security:authorize access="isAuthenticated()">

                    <li>Witaj! ${currentUserFullName}</li>
                    <%@include file="/WEB-INF/views/home/logout.jsp" %>
            </security:authorize>

            <security:authorize access="isAnonymous()">
                    <li><a href="/register" class="btn btn--small btn--highlighted">Za&#322&#243&#380 konto</a></li>
                    <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            </security:authorize>

        </ul>



        <ul>
            <li><a href="#" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <security:authorize access="isAuthenticated()">
                    <li><a href="/addDonation" class="btn btn--without-border">Przeka&#380; dary</a></li>
            </security:authorize>
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