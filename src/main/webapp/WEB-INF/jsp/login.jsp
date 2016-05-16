<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Custom Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>

    <h3>Login</h3>
    <form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
          method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username' value=''>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' />
                </td>
            </tr>
            <tr>
                <td>
                    <input name="submit" type="submit" value="submit" />
                </td>
            </tr>
        </table>

    </form>
</body>
</html>
