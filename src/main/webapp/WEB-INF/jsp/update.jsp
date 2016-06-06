<%--
  Created by IntelliJ IDEA.
  User: nfabian
  Date: 2.5.16
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="shared/header.jsp" %>
<body>
<div class="container">
    <style>
        h2{
            background-image: url("http://bodywrapsstlouis.com/wp-content/uploads/2013/03/header-background-image.jpg");
            color: white;
            background-color: #3f3f5a;
            padding: 30px 30px 30px 30px;
        }
    </style>

    <form:form method="POST" modelAttribute="cv" action="${pageContext.request.contextPath}/auth/update">
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="fullName"></form:input></td>

        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input path="address"></form:input></td>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td><form:input path="birthday"></form:input></td>
        </tr>

        <tr>
            <td>Contact type:</td>
            <td><form:input path="contacts[0].id"></form:input></td>

        </tr>

        <tr>
            <td>Contact value:</td>
            <td>
                <form:input path="contacts[0].value"></form:input>
            </td>
        </tr>
        <tr>
            <td>Personal profile:</td>
            <td>
                <form:input path="personalProfile"></form:input>
            </td>
        </tr>

        <tr style="background-color:goldenrod">
            <td>Work from:</td>
            <td> <form:input path="workExperience[0].from"></form:input></td>
        </tr>
        <tr style="background-color:goldenrod">
            <td>Work to:</td>
            <td> <form:input path="workExperience[0].to"></form:input></td>
        </tr>

        <tr style="background-color:goldenrod">
            <td>Work Company:</td>
            <td> <form:input path="workExperience[0].company"></form:input></td>
        </tr>
        <tr style="background-color:goldenrod">
            <td>Work Position:</td>
            <td> <form:input path="workExperience[0].position"></form:input></td>
        </tr>
        <tr style="background-color:goldenrod">
            <td>Work Text:</td>
            <td> <form:input path="workExperience[0].value"></form:input></td>
        </tr>
        <tr style="background-color:deepskyblue">
            <td>Education from:</td>
            <td> <form:input path="educations[0].from"></form:input></td>
        </tr>
        <tr style="background-color:deepskyblue">
            <td>Education to:</td>
            <td> <form:input path="educations[0].to"></form:input></td>
        </tr>
        <tr style="background-color:deepskyblue">
            <td>Education School</td>
            <td> <form:input path="educations[0].school"></form:input></td>
        </tr>
        <tr style="background-color:deepskyblue">
            <td>Education Value</td>
            <td> <form:input path="educations[0].value"></form:input></td>
        </tr>

        <tr style="background-color:darkseagreen">
            <td>Achievement Year</td>
            <td> <form:input path="achievements[0].year"></form:input></td>
        </tr>
        <tr style="background-color:darkseagreen">
            <td>Achievement title</td>
            <td> <form:input path="achievements[0].title"></form:input></td>
        </tr>
        <tr style="background-color:darkseagreen">
            <td>Achievement value</td>
            <td> <form:input path="achievements[0].value"></form:input></td>
        </tr>
        <tr style="background-color:cadetblue">
            <td>Language: </td>
            <td> <form:input path="languages[0].lang"></form:input></td>
        </tr>
        <tr style="background-color:cadetblue">
            <td>Language level: </td>
            <td> <form:input path="languages[0].level"></form:input></td>
        </tr>
        <tr style="background-color:indianred">
            <td>Skill title</td>
            <td> <form:input path="skills[0].title"></form:input></td>
        </tr>
        <tr style="background-color:indianred">
            <td>Skill value</td>
            <td> <form:input path="skills[0].value"></form:input></td>
        </tr>
        <tr style="background-color:lightgray">
            <td>Hobby:</td>
            <td> <form:input path="hobbies[0].title"></form:input></td>
        </tr>
        <tr style="background-color:lightgray">
            <td>Hobby value</td>
            <td> <form:input path="hobbies[0].value"></form:input></td>
        </tr>





        <tr>
            <td><input type="submit" value="Save"></td>
            <td></td>
        </tr>
        </tbody>
    </table>
    </form:form>


</body>
</html>
