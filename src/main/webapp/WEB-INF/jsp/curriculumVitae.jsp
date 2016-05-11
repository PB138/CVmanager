<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Curriculum vitae</title>
</head>
<body>

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Curriculum vitae</h2>
  <p>Can be used: .active, .success, .info, .warning, and .danger.</p>
  <table class="table table-striped">
    <thead>
      <tr class="danger">
        <th>Basic information</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>Full name:</th>
        <td>${cv.fullName}</td>
      </tr>

      <tr>
        <th>Address:</th>
        <td>${cv.address}</td>
      </tr>

      <tr>
        <th>Birthday:</th>
        <td>${cv.birthday}</td>
      </tr>

      <tr>
        <th>personalProfile:</th>
        <td>${cv.personalProfile}</td>
      </tr>
    </tbody>
  </table>

  <table class="table table-striped">
    <thead>
      <tr class="danger">
        <th>Work skills</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>

<c:forEach items="${cv.workExperience}" var="item">
      <tr>
        <th>From: </th>
        <td><c:out value="${item.from}"/></td>
      </tr>
      <tr>
        <th>To:</th>
        <td><c:out value="${item.to}"/></td>
      </tr>
      <tr>
        <th>Company:</th>
        <td><c:out value="${item.company}"/></td>
      </tr>
      <tr>
        <th>Position:</th>
        <td><c:out value="${item.position}"/></td>
      </tr>
      <tr>
        <th>Value:</th>
        <td><c:out value="${item.value}"/></td>
      </tr>
</c:forEach>

</tbody>
</table>

</div>


workExperience${cv.workExperience}</br>

educations${cv.educations}</br>
achievements${cv.achievements}</br>
languages${cv.languages}</br>
skills${cv.skills}</br>
hobbies${cv.hobbies}</br>

</body>
</html>
