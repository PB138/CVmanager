<%--
  Created by IntelliJ IDEA.
  User: nfabian
  Date: 6.6.16
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
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
            <img src="https://cdn2.iconfinder.com/data/icons/flags/flags/48/united-kingdom-great-britain.png"
                 style="width:24px;height:24px;">
            English</a>
        </li>

        <li><a href="?lang=sk">
            <img src="https://cdn3.iconfinder.com/data/icons/finalflags/24/Slovakia-Flag.png"
                 style="width:24px;height:24px;">
            Slovak</a>
        </li>
    </ul>
</div>


<style>
    div {
        padding: 0px 30px 0px 0px;
    }
</style>

<div align="right">
    <a href="<c:url value='/logout' />">
        <button type="button" class="btn btn-default btn-sm">
            <span class="glyphicon glyphicon-log-out"></span> Log out
        </button>
    </a>
    <a  style="margin-left: 10px" class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/index">
        <span class="glyphicon glyphicon-log-in"></span> Back to main page </a>

</div>

</body>
</html>
