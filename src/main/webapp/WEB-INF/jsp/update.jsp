<%--
  Created by IntelliJ IDEA.
  User: nfabian
  Date: 2.5.16
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
      <meta charset="utf-8">
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



</body>
</html>
