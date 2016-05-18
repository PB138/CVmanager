<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Custom Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>

    <h3>Login</h3>
    <form:form commandName="user"  name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>


        <table>
            <tr>
                <td>User:</td>
                <td>
                    <form:input path="username"  />
                    <form:errors path="username" />
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                    <form:password path="password"  />
                    <form:errors path="password" />
                </td>
            </tr>
            <tr>
                <td>
                    <input name="submit" type="submit" value="submit" />
                </td>
            </tr>
        </table>

    </form:form>
</body>
</html>