<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zeman
  Date: 18-May-16
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <style>
        body {
            background: url('http://www.wallpaperno.com/thumbnails/detail/20130225/books%201920x1080%20wallpaper_www.wallpaperno.com_96.jpg') no-repeat center center fixed;
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
            margin-bottom:0px;
        }
    </style>

</head>
<body>

<div class="container">
    <div class="row" style="margin: 150px 0px">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Register</strong>
                    <c:if test="${not empty error}">
                        ${error}
                    </c:if>
                </div>
                <div class="panel-body">
                    <form:form class="form-horizontal" role="form" commandName="Account">
                        <div class="form-group">
                            <label for="Username" class="col-sm-3 control-label">Username</label>
                            <div class="col-sm-9">
                                <form:input path="username" type="username" class="form-control" id="Username" placeholder="Username" required="yes" />
                                <form:errors path="username" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-9">
                                <form:password path="password" class="form-control" id="password" required="yes"/>
                                <form:errors path="password" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="retypePasswords" class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-9">
                                <form:password path="retypePassword" class="form-control" id="retypePasswords" required="yes"/>
                                <form:errors path="retypePassword" />
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <div class="checkbox">
                                    <label class="">
                                        <input type="checkbox" class="">Remember me</label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group last">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" value="Register" class="btn btn-success btn-sm">Register</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>



</body>
</html>
