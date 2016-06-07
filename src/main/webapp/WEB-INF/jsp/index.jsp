<!DOCTYPE html>

<html>
<head>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Curriculum Vitae App</title>

</head>

<body id="page-top" class="index">

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand page-scroll" href="#page-top">Curriculum Vitae Manager</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li>
                    <a class="page-scroll" href="#application"><spring:message code="Application" /></a>
                </li>
                <li>
                    <a class="page-scroll" href="#team"><spring:message code="Team" /></a>
                </li>

                <c:if test="${empty pageContext.request.userPrincipal}">
                    <li>
                        <a class="redirect" href="${pageContext.request.contextPath}/login"><spring:message code="LogIn" /></a>
                    </li>
                </c:if>

                <c:if test="${not empty pageContext.request.userPrincipal}">
                    <li>
                        <a class="redirect" href="${pageContext.request.contextPath}/logout"><spring:message code="LogOff" /></a>
                    </li>
                </c:if>


                <li>
                    <div>
                    <a href="?lang=en">
                        <img src="https://cdn2.iconfinder.com/data/icons/flags/flags/48/united-kingdom-great-britain.png" style="width:20px;height:15px;">
                        </a>
                    <a href="?lang=sk">
                        <img src="https://cdn3.iconfinder.com/data/icons/finalflags/24/Slovakia-Flag.png" style="width:20px;height:15px;">
                        </a>
                    </div>
                </li>

            </ul>
        </div>
    </div>
</nav>

<!-- Header -->
<header>
    <div class="container">
        <div class="intro-text">
            <div class="intro-lead-in"><spring:message code="Welcome" /></div>
            <div class="intro-heading"><spring:message code="IndexBanner" /></div>
            <a href="#application" class="page-scroll btn btn-xl"><spring:message code="TellMeMore" /></a>
        </div>
    </div>
</header>

<!-- Application Section -->
<section id="application" style=" background-color: lightgray">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading"><spring:message code="Application" /></h2>
                <h3 class="section-subheading text-muted"><spring:message code="AppText" /></h3>
            </div>
        </div>
        <div class="row text-center">
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/auth"><span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-file-text fa-stack-1x fa-inverse"></i>
                    </span></a>
                <h4 class="service-heading"><spring:message code="ViemCV" /></h4>
                <p class="text-muted"><spring:message code="ViewCvText" /></p>
            </div>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/auth/update"><span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                    </span></a>
                <h4 class="service-heading"><spring:message code="Update" /></h4>
                <p class="text-muted"><spring:message code="UpdateText" /></p>
            </div>
            <div class="col-md-4">
                <a href=""><span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-lock fa-stack-1x fa-inverse"></i>
                    </span></a>
                <h4 class="service-heading">Here will be delete?</h4>
                <p class="text-muted">Something something.....</p>
            </div>
        </div>
    </div>
</section>

<!-- Team Section -->
<section id="team" class="bg-light-gray">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading"><spring:message code="TeamDesc" /></h2>
                <h3 class="section-subheading text-muted"><spring:message code="TeamText" /></h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <div class="team-member">
                    <img src="https://is.muni.cz/auth/lide/foto?uco=422465;typ=prim" class="img-responsive img-circle" alt="">
                    <h4>Šimon Pavlík</h4>
                    <p class="text-muted">Lead Designer</p>
                    <ul class="list-inline social-buttons">
                        <li><a href="https://www.facebook.com/simon.pavlik.7"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="https://is.muni.cz/auth/osoba/422465"><i class="fa fa-info-circle"></i></a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="team-member">
                    <img src="https://is.muni.cz/auth/lide/foto?uco=396035;typ=prim" class="img-responsive img-circle" alt="">
                    <h4>Bc. Norbert Fabián</h4>
                    <p class="text-muted">Team Leader</p>
                    <ul class="list-inline social-buttons">
                        <li><a href="https://www.facebook.com/norbert.fabian.73"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="https://is.muni.cz/auth/osoba/396035"><i class="fa fa-info-circle"></i></a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="team-member">
                    <img src="https://is.muni.cz/auth/lide/foto?uco=433800;typ=prim" class="img-responsive img-circle" alt="">
                    <h4>Ondrej Zeman</h4>
                    <p class="text-muted">Team Member</p>
                    <ul class="list-inline social-buttons">
                        <li><a href="https://www.facebook.com/ozeman77"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="https://is.muni.cz/auth/osoba/433800"><i class="fa fa-info-circle"></i></a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-sm-3">
                <div class="team-member">
                    <img src="https://is.muni.cz/auth/lide/foto?uco=396537;typ=prim" class="img-responsive img-circle" alt="">
                    <h4>Bc. David Osička</h4>
                    <p class="text-muted">Team Member</p>
                    <ul class="list-inline social-buttons">
                        <li><a href="https://www.facebook.com/david.osicka.3"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="https://is.muni.cz/auth/osoba/david.osicka"><i class="fa fa-info-circle"></i></a>
                        </li>
                    </ul>
                </div>
            </div>


            <div class="col-lg-8 col-lg-offset-2 text-center">
                <p class="large text-muted"><spring:message code="ThanksToSupervisor"/> <a href="https://is.muni.cz/auth/osoba/208428">RNDr. Filip Nguyen.</a></p>
            </div>

        </div>
    </div>
</section>

<!-- spodok -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <span class="copyright">Copyright &copy; Our website 2016</span>
            </div>
            <div class="col-md-4">
                <ul class="list-inline social-buttons">
                    <li><a href="http://pb138.github.io/CVmanager/"><i class="fa fa-github"></i></a>
                    </li>
                    <li><a href="https://is.muni.cz/auth/rozpis/tema?studium=647429;lang=cs;sorter=vedouci;balik=269689;tema=270522;predmet=870713;kod=PB138;obdobi=6384;fakulta=1433;uplne_info=1">
                        <i class="fa fa-info-circle"></i></a>
                    </li>

                </ul>
            </div>
            <div class="col-md-4">
                <ul class="list-inline quicklinks">

                </ul>
            </div>
        </div>
    </div>
</footer>




<!---------------------------------------- SCRIPTS  ------------------------------------>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!---------------------------------------- FONTS  -------------------------------------->

<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" property="">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" property="">
<link href='http://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css' property="">
<link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css' property="">
<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css' property="">

<!---------------------------------------- CSS  ---------------------------------------->

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" property="">


<!--------- custom.css  ---------->

<style scoped>
    /*!
 * Agency v1.0.7 (http://startbootstrap.com/template-overviews/agency)
 * Copyright 2013-2016 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap/blob/gh-pages/LICENSE)
 */

    body {
        overflow-x: hidden;
        font-family: "Roboto Slab", "Helvetica Neue", Helvetica, Arial, sans-serif;
    }
    .text-muted {
        color: #777777;
    }
    .text-primary {
        color: #fed136;
    }
    p {
        font-size: 14px;
        line-height: 1.75;
    }
    p.large {
        font-size: 16px;
    }

    a {
        color: #fed136;
    }

    h1,
    h2,
    h3,
    h4,
    h5,
    h6 {
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;
        font-weight: 700;
    }

    .bg-light-gray {
        background-color: #f7f7f7;
    }

    .btn-xl {
        color: #ffffff;
        background-color: #fed136;
        border-color: #fed136;
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;
        font-weight: 700;
        border-radius: 3px;
        font-size: 18px;
        padding: 20px 40px;
    }

    .navbar-default {
        background-color: #222222;
        border-color: transparent;
    }
    .navbar-default .navbar-brand {
        color: #fed136;
        font-family: "Kaushan Script", "Helvetica Neue", Helvetica, Arial, cursive;
    }

    .navbar-default .navbar-collapse {
        border-color: rgba(255, 255, 255, 0.02);
    }
    .navbar-default .navbar-toggle {
        background-color: #fed136;
        border-color: #fed136;
    }
    .navbar-default .navbar-toggle .icon-bar {
        background-color: white;
    }
    .navbar-default .navbar-toggle:hover,
    .navbar-default .navbar-toggle:focus {
        background-color: #fed136;
    }
    .navbar-default .nav li a {
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;
        font-weight: 400;
        letter-spacing: 1px;

        color: white;
        text-shadow:
                -1px -1px 0 #000,
                1px -1px 0 #000,
                -1px 1px 0 #000,
                1px 1px 0 #000;
    }
    .navbar-default .nav li a:hover,
    .navbar-default .nav li a:focus {
        color: #fed136;
        outline: none;
    }
    .navbar-default .navbar-nav > .active > a {
        border-radius: 0;
        color: white;
        background-color: #fed136;
    }
    .navbar-default .navbar-nav > .active > a:hover,
    .navbar-default .navbar-nav > .active > a:focus {
        color: white;
        background-color: #fec503;
    }
    @media (min-width: 768px) {
        .navbar-default {
            background-color: transparent;
            padding: 25px 0;
            -webkit-transition: padding 0.3s;
            -moz-transition: padding 0.3s;
            transition: padding 0.3s;
            border: none;
        }
        .navbar-default .navbar-brand {
            font-size: 2em;
            -webkit-transition: all 0.3s;
            -moz-transition: all 0.3s;
            transition: all 0.3s;
        }
        .navbar-default .navbar-nav > .active > a {
            border-radius: 3px;
        }

        .navbar-default.navbar-shrink .navbar-brand {
            font-size: 1.5em;
        }
    }
    header {
        background: url('https://github.com/BlackrockDigital/startbootstrap-agency/blob/master/dist/img/header-bg.jpg?raw=true');
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
        text-align: center;
        color: white;
    }
    header .intro-text {
        padding-top: 100px;
        padding-bottom: 50px;
    }
    header .intro-text .intro-lead-in {
        font-family: "Droid Serif", "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-style: italic;
        font-size: 22px;
        line-height: 22px;
        margin-bottom: 25px;
    }
    header .intro-text .intro-heading {
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;
        font-weight: 700;
        font-size: 50px;
        line-height: 50px;
        margin-bottom: 25px;
    }
    @media (min-width: 768px) {
        header .intro-text {
            padding-top: 300px;
            padding-bottom: 200px;
        }
        header .intro-text .intro-lead-in {
            font-family: "Droid Serif", "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-style: italic;
            font-size: 40px;
            line-height: 40px;
            margin-bottom: 25px;
        }
        header .intro-text .intro-heading {
            font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
            text-transform: uppercase;
            font-weight: 700;
            font-size: 75px;
            line-height: 75px;
            margin-bottom: 50px;
        }
    }
    section {
        padding: 100px 0;
    }
    section h2.section-heading {
        font-size: 40px;
        margin-top: 0;
        margin-bottom: 15px;
    }
    section h3.section-subheading {
        font-size: 16px;
        font-family: "Droid Serif", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: none;
        font-style: italic;
        font-weight: 400;
        margin-bottom: 75px;
    }
    @media (min-width: 768px) {
        section {
            padding: 150px 0;
        }
    }
    .service-heading {
        margin: 15px 0;
        text-transform: none;
    }

    #portfolio .portfolio-item .portfolio-link .portfolio-hover .portfolio-hover-content i {
        margin-top: -12px;
    }
    #portfolio .portfolio-item .portfolio-link .portfolio-hover .portfolio-hover-content h3,
    #portfolio .portfolio-item .portfolio-link .portfolio-hover .portfolio-hover-content h4 {
        margin: 0;
    }

    #portfolio .portfolio-item .portfolio-caption h4 {
        text-transform: none;
        margin: 0;
    }
    #portfolio .portfolio-item .portfolio-caption p {
        font-family: "Droid Serif", "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-style: italic;
        font-size: 16px;
        margin: 0;
    }
    #portfolio * {
        z-index: 2;
    }
    @media (min-width: 767px) {
    }

    .timeline > li {
        margin-bottom: 50px;
        position: relative;
        min-height: 50px;
    }
    .timeline > li:before,
    .timeline > li:after {
        content: " ";
        display: table;
    }
    .timeline > li:after {
        clear: both;
    }

    .timeline > li .timeline-image h4 {
        font-size: 10px;
        margin-top: 12px;
        line-height: 14px;
    }

    .timeline > li:last-child {
        margin-bottom: 0;
    }
    .timeline .timeline-heading h4 {
        margin-top: 0;
        color: inherit;
    }

    .timeline .timeline-body > p,
    .timeline .timeline-body > ul {
        margin-bottom: 0;
    }
    @media (min-width: 768px) {
        .timeline > li {
            margin-bottom: 100px;
            min-height: 100px;
        }

        .timeline > li .timeline-image h4 {
            font-size: 13px;
            margin-top: 16px;
            line-height: 18px;
        }
    }
    @media (min-width: 992px) {
        .timeline > li {
            min-height: 150px;
        }

        .timeline > li .timeline-image h4 {
            font-size: 18px;
            margin-top: 30px;
            line-height: 26px;
        }
    }
    @media (min-width: 1200px) {
        .timeline > li {
            min-height: 170px;
        }

        .timeline > li .timeline-image h4 {
            margin-top: 40px;
        }
    }
    .team-member {
        text-align: center;
        margin-bottom: 50px;
    }
    .team-member img {
        margin: 0 auto;
        border: 7px solid white;
    }
    .team-member h4 {
        margin-top: 25px;
        margin-bottom: 0;
        text-transform: none;
    }
    .team-member p {
        margin-top: 0;
    }
    aside.clients img {
        margin: 50px auto;
    }
    section#contact .section-heading {
        color: white;
    }

    section#contact .form-group input,
    section#contact .form-group textarea {
        padding: 20px;
    }

    section#contact ::-webkit-input-placeholder {
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;
        font-weight: 700;
        color: #bbbbbb;
    }
    section#contact :-moz-placeholder {
        /* Firefox 18- */
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;
        font-weight: 700;
        color: #bbbbbb;
    }
    section#contact ::-moz-placeholder {
        /* Firefox 19+ */
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;
        font-weight: 700;
        color: #bbbbbb;
    }
    section#contact :-ms-input-placeholder {
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;
        font-weight: 700;
        color: #bbbbbb;
    }

    footer {
        padding: 25px 0;
        text-align: center;
    }
    footer span.copyright {
        line-height: 40px;
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;

    }
    footer ul.quicklinks {
        margin-bottom: 0;
        line-height: 40px;
        font-family: "Montserrat", "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-transform: uppercase;

    }
    ul.social-buttons {
        margin-bottom: 0;
    }
    ul.social-buttons li a {
        display: block;
        background-color: #222222;
        height: 40px;
        width: 40px;
        border-radius: 100%;
        font-size: 20px;
        line-height: 40px;
        color: white;
        outline: none;
        -webkit-transition: all 0.3s;
        -moz-transition: all 0.3s;
        transition: all 0.3s;
    }
    ul.social-buttons li a:hover,
    ul.social-buttons li a:focus,
    ul.social-buttons li a:active {
        background-color: #fed136;
    }

    .portfolio-modal .modal-content h2 {
        margin-bottom: 15px;
        font-size: 3em;
    }
    .portfolio-modal .modal-content p {
        margin-bottom: 30px;
    }

    .portfolio-modal .modal-content img {
        margin-bottom: 30px;
    }

    ::-moz-selection {
        text-shadow: none;
        background: #fed136;
    }
    ::selection {
        text-shadow: none;
        background: #fed136;
    }
    img::selection {
        background: transparent;
    }
    img::-moz-selection {
        background: transparent;
    }

</style>

</body>

</html>