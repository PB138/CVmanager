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


    <!---------------------------------------- CSS  ---------------------------------------->

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" property="">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">

    <!--------- custom.css  ---------->

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
                    <a class="page-scroll" href="#application"><span class="glyphicon glyphicon-tasks"></span>  <spring:message code="Application" /></a>
                </li>
                <li>
                    <a class="page-scroll" href="#team"><span class="glyphicon glyphicon-user"></span>  <spring:message code="Team" /></a>
                </li>

                <c:if test="${empty pageContext.request.userPrincipal}">
                    <li>
                        <a class="redirect" href="${pageContext.request.contextPath}/login"><spring:message code="LogIn" /></a>
                    </li>
                </c:if>

                <c:if test="${not empty pageContext.request.userPrincipal}">
                    <li>
                        <a class="redirect" href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-off"></span>  <spring:message code="LogOff" /></a>
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
                <!-- response.locale is recognition of users language  -->
                <a href="${pageContext.request.contextPath}/auth/download?l=${pageContext.response.locale}" target="_blank"><span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-download fa-stack-1x fa-inverse"></i>
                    </span></a>
                <h4 class="service-heading"><spring:message code="Download" /></h4>
                <p class="text-muted"><spring:message code="DownloadText" /></p>
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

</body>

</html>