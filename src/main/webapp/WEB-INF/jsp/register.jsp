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
</head>
<body>
    <h2>Registration</h2>
    <c:if test="${not empty error}">
        ${error}
    </c:if>
    <form:form commandName="Account">

        <div >
            <label for="username" >Username:</label>
            <div >
                <form:input path="username"  />
                <form:errors path="username" />
            </div>
        </div>
        <div >
            <label for="password" >Password:</label>
            <div >
                <form:password path="password"  />
                <form:errors path="password" />
            </div>
        </div>
        <div >
            <label for="password" >Password again:</label>
            <div >
                <form:password path="retypePassword"  />
                <form:errors path="retypePassword" />

            </div>
        </div>
        <div >
            <div >
                <input type="submit" value="Register" />
            </div>
        </div>

    </form:form>

</body>
</html>
