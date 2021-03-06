<%--
  Created by IntelliJ IDEA.
  User: Simon Pavlik
  Date 11.5.16
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <style>
        body {
            background: url('https://static.pexels.com/photos/1526/dark-blur-blurred-gradient.jpg') no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }

        .panel-default {
            opacity: 0.9;
            margin-top:30px;
        }
        .form-group.last {
            margin-bottom:0;
        }
    </style>

</head>
<body>

<div class="container">
    <div class="row" style="margin: 150px 0">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class=""><spring:message code="Register" /></strong>

                </div>
                <div class="panel-body">
                    <c:if test="${not empty error}">
                        <div style="color:darkred"><strong><spring:message code="${error}" /></strong></div>
                    </c:if>
                    <form:form class="form-horizontal" role="form" commandName="Account">
                        <div class="form-group">
                            <label for="Username" class="col-sm-3 control-label"><spring:message code="Username" /></label>
                            <div class="col-sm-9">
                                <form:input path="username" type="username" class="form-control" id="Username" placeholder="Username" required="yes" />
                                <form:errors path="username" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label"><spring:message code="Password" /></label>
                            <div class="col-sm-9">
                                <form:password path="password" class="form-control" id="password"  placeholder="Password" required="yes"/>
                                <form:errors path="password" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="retypePasswords" class="col-sm-3 control-label"><spring:message code="PasswordAgain" /></label>
                            <div class="col-sm-9">
                                <form:password path="retypePassword" class="form-control" id="retypePasswords"  placeholder="Retype password" required="yes"/>
                                <form:errors path="retypePassword" />
                            </div>
                        </div>
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>


                        <div class="form-group last">

                            <div class="col-sm-offset-3 col-sm-10">

                                <button type="submit" class="btn btn-success btn-sm"><spring:message code="Register" /></button>

                                <a  class="btn btn-default btn-sm" style=""
                                    href="${pageContext.request.contextPath}/login">
                                    <span class="glyphicon glyphicon-user"></span> Back to login
                                </a>




                        </div>

                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
