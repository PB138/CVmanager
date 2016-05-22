<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <td>
                Users
            </td>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    ${user.username}
                </td>
            </tr>

        </c:forEach>

    </table>
</body>
</html>
