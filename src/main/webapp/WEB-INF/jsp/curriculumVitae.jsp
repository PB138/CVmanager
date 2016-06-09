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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="shared/header.jsp" %>
<body>


    <div class="resume">
        <header class="page-header">
            <h1 class="page-title">Curriculum Vitae</h1>
        </header>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8">
                <div class="panel panel-default">
                    <div class="panel-heading resume-heading">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="col-xs-12 col-sm-4">
                                    <figure>
                                        <img class="img-circle img-responsive" alt="" src="https://image.freepik.com/iconos-gratis/persona-silueta-de-negocios-con-corbata_318-49988.png" style="width: 219px;
    height: 219px;">
                                    </figure>
                                </div>

                                <div class="col-xs-12 col-sm-8">
                                    <ul class="list-group">
                                        <li class="list-group-item"><strong>${cv.fullName}</strong></li>
                                        <li class="list-group-item">${cv.address}</li>
                                        <li class="list-group-item">${cv.birthday}</li>
                                        <c:forEach items="${cv.contacts}" var="item">
                                            <li class="list-group-item">
                                                <c:choose>
                                            <c:when test="${item.id == 'Tel'||item.id == 'tel'|| item.id =='Telephone' || item.id =='telephone' || item.id =='Telefón' || item.id =='telefón' || item.id =='phone' || item.id =='Phone'}">
                                            <i class="fa fa-phone"></i>
                                            </c:when>
                                                    <c:when test="${item.id == 'Email' || item.id =='email' || item.id =='Mail' || item.id =='mail' || item.id =='E-mail'}">
                                                        <i class="fa fa-envelope"></i>
                                                    </c:when>
                                                    <c:when test="${item.id == 'fb' || item.id =='FB' || item.id =='Facebook' || item.id =='facebook'}">
                                                        <i class="fa fa-facebook"></i>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:out value="${item.id}"/>:
                                                    </c:otherwise>
                                                </c:choose>
                                             <c:out value="${item.value}"/>
                                        </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.personalInformation" /></h4>
                        <p>
                            ${cv.personalProfile}
                        </p>
                    </div>




                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.workExperience" /></h4>
                        <ul class="list-group">

                            <c:forEach items="${cv.workExperience}" var="item">
                            <a>
                                <h4 class="list-group-item-heading"><c:out value="${item.company}"/> - <c:out value="${item.position}"/></h4>
                                <p class="list-group-item-text">
                                    <c:out value="${item.from}"/> - <c:out value="${item.to}"/>
                                </p>
                                <ul>
                                <li>
                                    <c:out value="${item.value}"/>
                                </li>
                            </ul>

                            </a>

                            </c:forEach>
                        </ul>
                    </div>



                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.educations" /></h4>
                        <table class="table table-striped table-responsive ">
                            <thead>
                            <tr><th><spring:message code="cv.school" /></th>
                                <th><spring:message code="cv.year" /></th>
                                <th><spring:message code="cv.title" /></th>
                            </tr></thead>
                            <c:forEach items="${cv.educations}" var="item">
                            <tbody>
                            <tr>
                                <td><c:out value="${item.school}"/></td>
                                <td><c:out value="${item.from}"/> - <c:out value="${item.to}"/></td>
                                <td> <c:out value="${item.value}"/> </td>
                            </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                    </div>


                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.achievements" /></h4>
                        <ul class="list-group">

                            <c:forEach items="${cv.achievements}" var="item">

                                    <h4 class="list-group-item-heading"><c:out value="${item.year}"/> - <c:out value="${item.title}"/> </h4>
                                    <ul>
                                        <li>
                                            <c:out value="${item.value}"/>
                                        </li>
                                    </ul>
                            </c:forEach>
                        </ul>
                    </div>

                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.languages" /></h4>
                        <ul class="list-group">
                        <c:forEach items="${cv.languages}" var="item">
                            <li class="list-group-item"><c:out value="${item.lang}"/> - <c:out value="${item.level}"/></li>

                        </c:forEach>

                        </ul>
                    </div>

                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.skills" /></h4>
                        <ul class="list-group">
                            <c:forEach items="${cv.skills}" var="item">
                                <li class="list-group-item"><c:out value="${item.title}"/> - <c:out value="${item.value}"/></li>
                            </c:forEach>
                        </ul>
                    </div>

                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.hobbies" /></h4>
                        <ul class="list-group">
                            <c:forEach items="${cv.hobbies}" var="item">
                                <li class="list-group-item"><c:out value="${item.title}"/> - <c:out value="${item.value}"/></li>
                            </c:forEach>
                        </ul>
                    </div>

                </div>

                <b >
                    <a href="<c:url value='/auth/update' />">
                        <button type="button" class="btn-lg btn-default">
                            <span class="glyphicon glyphicon-pencil"></span>Edit info</button></a>
                </b>

            </div>
        </div>

    </div>






</body>

<!-- SCRIPTS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" property="">
<style>
    /* uses font awesome for social icons */
    @import url(http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css);
    body {
        padding-bottom: 50px;
    }
    .page-header{
        text-align: center;
    }

    .bs-callout {
        -moz-border-bottom-colors: none;
        -moz-border-left-colors: none;
        -moz-border-right-colors: none;
        -moz-border-top-colors: none;
        border-color: #eee;
        border-image: none;
        border-radius: 3px;
        border-style: solid;
        border-width: 1px 1px 1px 5px;
        margin-bottom: 5px;
        padding: 20px;
    }

    .bs-callout h4 {
        margin-bottom: 10px;
        margin-top: 0;
    }

    .bs-callout-danger {
        border-left-color: #d9534f;
    }

    .bs-callout-danger h4{
        color: #d9534f;
    }

    .resume .list-group-item:first-child, .resume .list-group-item:last-child{
        border-radius:0;
    }

</style>

</html>
