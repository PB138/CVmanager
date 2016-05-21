<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body onload='document.loginForm.username.focus();'>



    <h2>Login</h2>

    <c:if test="${not empty success}" >
        <div> ${success}</div>
    </c:if>
    <c:if test="${not empty error}">
        ${error}
    </c:if>
    <c:if test="${not empty logout}">
        ${logout}
    </c:if>

    <form name='loginForm' action="<spring:url value='j_spring_security_check' />" method='POST'>
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input name="submit" type="submit" value="Sing In" />
                    <a href="/cvmanager/register">Register</a>
                </td>

            </tr>

        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />


    </form>


</body>
</html>