<%--
  Created by IntelliJ IDEA.
  User: nfabian
  Date: 2.5.16
  Time: 19:51
  Changed
  User: Simon Pavlik
  Date 11.5.16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Curriculum vitae</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</head>
<body>

Language:
<div class="btn-group dropdown">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
        <span class="lang-sm lang-lbl-full" lang="it"></span> <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
        <li><a href="?lang=en">
            <img src="https://cdn2.iconfinder.com/data/icons/flags/flags/48/united-kingdom-great-britain.png" style="width:24px;height:24px;">
            English</a>
        </li>

        <li><a href="?lang=sk">
            <img src="https://cdn3.iconfinder.com/data/icons/finalflags/24/Slovakia-Flag.png" style="width:24px;height:24px;">
            Slovak</a>
        </li>
    </ul>
</div>


<style>
    div{
        padding: 0px 30px 0px 0px;
    }
</style>

<div align="right">
    <a href="<c:url value='/logout' />" >
        <button type="button" class="btn btn-default btn-sm">
            <span class="glyphicon glyphicon-log-out"></span> Log out</button></a>
</div>

<div class="container">
    <style>
        h2{
            background-image: url("http://bodywrapsstlouis.com/wp-content/uploads/2013/03/header-background-image.jpg");
            color: white;
            background-color: #3f3f5a;
            padding: 30px 30px 30px 30px;
        }
    </style>
    <h2>Curriculum vitae</h2>
    <table class="table table-striped col-lg-12">
        <thead>
        <tr class="info">
            <th class="col-lg-12" colspan="2">Basic information</th>
        </tr>
        </thead>
        <tbody>
        <tr class="">
            <th class="col-lg-5"><spring:message code="cv.fullName" /></th>

            <td class="col-lg-7">${cv.fullName}</td>
        </tr>

        <tr class="">
            <th class="col-lg-5"><spring:message code="cv.address" /></th>
            <td class="col-lg-7">${cv.address}</td>
        </tr>

        <tr>
        <tr class="">
            <th class="col-lg-5"><spring:message code="cv.birthday" /></th>
            <td class="col-lg-7">${cv.birthday}</td>
        </tr>

        <c:forEach items="${cv.contacts}" var="item">
            <tr class="">
                <th class="col-lg-5"><c:out value="${item.id}"/></th>
                <td class="col-lg-7"><c:out value="${item.value}"/></td>
            </tr>
        </c:forEach>

        <tr class="">
            <th class="col-lg-5"><spring:message code="cv.personalInformation" /></th>
            <td class="col-lg-5">${cv.personalProfile}</td>
        </tr>
        </tbody>
    </table>

    <table class="table table-striped">
        <thead>
        <tr class="info">
            <th><spring:message code="cv.workExperience" /></th>
            <th> </th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cv.workExperience}" var="item">
            <tr class="">
                <th class="col-lg-5"><c:out value="${item.company}"/> - <c:out value="${item.position}"/></th>
                <td class="col-lg-7"><c:out value="${item.from}"/> - <c:out value="${item.to}"/></td>
            </tr>
            <tr class="">
                <td class="col-lg-5"><c:out value="${item.value}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <table class="table table-striped">
        <thead>
        <tr class="info">
            <th><spring:message code="cv.educations" />/th>
            <th> </th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cv.educations}" var="item">
            <tr>
                <th><c:out value="${item.school}"/></th>
                <td class="col-lg-7"><c:out value="${item.from}"/> - <c:out value="${item.to}"/></td>
            </tr>
            <tr>
                <td>Description: <c:out value="${item.value}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <table class="table table-striped">
        <thead>
        <tr class="info">
            <th><spring:message code="cv.achievements" /></th>
            <th> </th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cv.achievements}" var="item">
            <tr>
                <th class="col-lg-5"><c:out value="${item.title}"/></th>
                <td class="col-lg-7"><c:out value="${item.year}"/></td>
            </tr>
            <tr>
                <td>Description: <c:out value="${item.value}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <table class="table table-striped">
        <thead>
        <tr class="info">
            <th><spring:message code="cv.languages" /></th>
            <th> </th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cv.languages}" var="item">
            <tr>
                <th><c:out value="${item.lang}"/></th>
                <td class="col-lg-7"><c:out value="${item.level}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <table class="table table-striped">
        <thead>
        <tr class="info">
            <th><spring:message code="cv.skills" /></th>
            <th> </th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cv.skills}" var="item">
            <tr>
                <th><c:out value="${item.title}"/></th>
                <td class="col-lg-7"><c:out value="${item.value}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <table class="table table-striped">
        <thead>
        <tr class="warning">
            <th><spring:message code="cv.hobbies" /></th>
            <th> </th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${cv.hobbies}" var="item">
            <tr>
                <th><c:out value="${item.title}"/></th>
                <td class="col-lg-7"><c:out value="${item.value}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <style>
        sm{
            padding: 50px 0px 0px 0px
        }
    </style>

    <sm align="left">
        <a href="<c:url value='/auth/update' />" >
            <button type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil"></span>Edit info</button></a>
    </sm>

</body>
</html>
