<%--
  Created by IntelliJ IDEA.
  User: Simon Pavlik
  Date 11.5.16
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>

<html>
<%@ include file="shared/header.jsp" %>


<head>


    <!-- CSS -->
    <style>
        /* uses font awesome for social icons */
        body {
            padding-bottom: 50px;
        }

        .page-header {
            text-align: center;
        }

        .bs-callout {
            -moz-border-bottom-colors: none;
            -moz-border-left-colors: none;
            -moz-border-right-colors: none;
            -moz-border-top-colors: none;
            border-image: none;
            border-radius: 3px;
            border: 1px solid #eee;
            border-left-width: 5px;
            margin-bottom: 5px;
            padding: 20px;
        }

        .bs-callout h4 {
            margin-bottom: 10px;
            margin-top: 0;
        }

        .bs-callout-danger {
            border-left-color: blue;
        }

        .bs-callout-danger h4 {
            color: blue;
        }

        .bs-callout-danger h3 {
            color: black;
        }

        .resume .list-group-item:first-child, .resume .list-group-item:last-child {
            border-radius: 0;
        }

    </style>


</head>

<body>


<form:form method="POST" modelAttribute="cv" action="${pageContext.request.contextPath}/auth/update">
    <div class="resume">
        <header class="page-header">
            <h1 class="page-title">Update</h1>
        </header>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8">
                <div class="panel panel-default">
                    <div class="panel-heading resume-heading">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="col-xs-12 col-sm-4">

                                </div>
                                <ul class="list-group">


                                    <li class="list-group-item">
                                        <fieldset class="form-group">
                                            <label for="fullname"><spring:message code="cv.fullName"/>:</label>
                                            <form:input path="fullName" id="fullname" placeholder="Name"
                                                        class="form-control" required="required"/>
                                        </fieldset>

                                    </li>
                                    <li class="list-group-item">
                                        <fieldset class="form-group">
                                            <label for="fullname"><spring:message code="cv.address"/>:</label>
                                            <form:input path="address" placeholder="Address" class="form-control"
                                                        required="required"/>
                                        </fieldset>
                                    </li>

                                    <li class="list-group-item">
                                        <fieldset class="form-group">
                                            <label for="fullname"><spring:message code="cv.birthday"/>:</label>
                                            <form:input path="birthday" placeholder="Birthday" class="form-control"
                                                        required="required"/>
                                        </fieldset>
                                    </li>

                                        <%--end of list--%>
                                </ul>

                            </div>
                        </div>
                    </div>


                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.personalInformation"/></h4>
                        <p>
                            <form:textarea path="personalProfile" class="form-control" rows="5" id="personalProfile"/>
                                <%--<form:input path="personalProfile"></form:input>--%>
                        </p>
                    </div>


                    <div class="bs-callout bs-callout-default">
                        <h4><strong><spring:message code="cv.contacts"/></strong></h4>
                            <%--<td><form:input path="contacts[0].value" placeholder="Contact type" class="form-control"/></td>--%>
                        <ul class="list-group">

                            <c:if test="${not empty cv.contacts}">

                                <c:forEach items="${cv.contacts}" var="item" varStatus="count">

                                    <li class="list-group-item contact-one">
                                        <table>
                                            <tr class="contact_id">
                                                <td>Contact type:</td>
                                                <td><form:input path="contacts[${count.index}].id"
                                                                placeholder="Contact type"
                                                                class="form-control"/></td>
                                            </tr>
                                            <tr class="contact_val">
                                                <td>Contact value:</td>
                                                <td>
                                                    <form:input path="contacts[${count.index}].value"
                                                                placeholder="Contact type"
                                                                class="form-control"/>
                                                </
                                            </tr>
                                        </table>
                                    </li>

                                </c:forEach>
                            </c:if>

                            <c:if test="${empty cv.contacts}">
                                <li class="list-group-item contact-one">
                                    <table>
                                        <tr class="contact_id">
                                            <td>Contact type:</td>
                                            <td><form:input path="contacts[0].id"
                                                            placeholder="Contact type"
                                                            class="form-control"/></td>
                                        </tr>
                                        <tr class="contact_val">
                                            <td>Contact value:</td>
                                            <td>
                                                <form:input path="contacts[0].value"
                                                            placeholder="Contact type"
                                                            class="form-control"/>
                                            </
                                        </tr>
                                    </table>
                                </li>

                            </c:if>
                            <li>
                                <input id="buttonContacts" type="button" value="<spring:message code="addNew"/>"
                                       onclick="addContactField();"/>
                            </li>


                        </ul>
                            <%--END OF CONTACTS--%>
                    </div>


                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.workExperience"/></h4>
                        <ul class="list-group">

                            <c:if test="${not empty cv.workExperience}">

                                <c:forEach items="${cv.workExperience}" var="item" varStatus="count">
                                    <li class="list-group-item workExp">
                                        <h3 class="list-group-item-heading"><spring:message code="cv.company"/>
                                            <form:input path="workExperience[${count.index}].company"
                                                        placeholder="Company name"
                                                        class="form-control"/></h3>
                                        <p><spring:message code="cv.position"/>
                                            <form:input path="workExperience[${count.index}].position"
                                                        placeholder="Position"
                                                        class="form-control"/>
                                        </p>
                                        <p><spring:message code="cv.from"/>
                                            <form:input path="workExperience[${count.index}].from" placeholder="From"
                                                        class="form-control"/>
                                        </p>
                                        <p><spring:message code="cv.to"/>
                                            <form:input path="workExperience[${count.index}].to" placeholder="To"
                                                        class="form-control"/>
                                        </p>
                                        <p><spring:message code="cv.info"/>
                                            <form:input path="workExperience[${count.index}].value" placeholder="Info"
                                                        class="form-control"/>
                                        </p>
                                    </li>
                                </c:forEach>
                            </c:if>

                            <c:if test="${empty cv.workExperience}">

                                <li class="list-group-item workExp">
                                    <h3 class="list-group-item-heading"><spring:message code="cv.company"/>
                                        <form:input path="workExperience[0].company" placeholder="Company name"
                                                    class="form-control"/></h3>
                                    <p><spring:message code="cv.position"/>
                                        <form:input path="workExperience[0].position" placeholder="Position"
                                                    class="form-control"/>
                                    </p>
                                    <p><spring:message code="cv.from"/>
                                        <form:input path="workExperience[0].from" placeholder="From"
                                                    class="form-control"/>
                                    </p>
                                    <p><spring:message code="cv.to"/>
                                        <form:input path="workExperience[0].to" placeholder="To" class="form-control"/>
                                    </p>
                                    <p><spring:message code="cv.info"/>
                                        <form:input path="workExperience[0].value" placeholder="Info" class="form-control"/>
                                    </p>
                                </li>

                            </c:if>

                            <li>
                                <input id="buttonWork" type="button" value="<spring:message code="addNew"/>"
                                       onclick="addWorkExperienceField();"/>
                            </li>

                        </ul>
                            <%--END OF WORK--%>
                    </div>

                    <div class="bs-callout bs-callout-default">
                        <h4><spring:message code="cv.educations"/></h4>
                        <ul class="list-group">
                            <c:if test="${not empty cv.educations}">
                                <c:forEach items="${cv.educations}" var="item" varStatus="count">
                                    <li class="list-group-item educ">
                                        <h3 class="list-group-item-heading"><spring:message code="cv.school"/>
                                            <form:input path="educations[${count.index}].school"
                                                        placeholder="School name"
                                                        class="form-control"/></h3>
                                        <p><spring:message code="cv.from"/>
                                            <form:input path="educations[${count.index}].from" placeholder="From"
                                                        class="form-control"/>
                                        </p>
                                        <p><spring:message code="cv.to"/>
                                            <form:input path="educations[${count.index}].to" placeholder="To"
                                                        class="form-control"/>
                                        </p>
                                        <p><spring:message code="cv.basicInformation"/>
                                            <form:input path="educations[${count.index}].value" placeholder="Info"
                                                        class="form-control"/>
                                        </p>
                                    </li>
                                </c:forEach>
                            </c:if>


                            <c:if test="${empty cv.educations}">
                                <li class="list-group-item educ">
                                    <h3 class="list-group-item-heading"><spring:message code="cv.school"/>
                                        <form:input path="educations[0].school" placeholder="School name"
                                                    class="form-control"/></h3>
                                    <p><spring:message code="cv.from"/>
                                        <form:input path="educations[0].from" placeholder="From" class="form-control"/>
                                    </p>
                                    <p><spring:message code="cv.to"/>
                                        <form:input path="educations[0].to" placeholder="To" class="form-control"/>
                                    </p>
                                    <p><spring:message code="cv.basicInformation"/>
                                        <form:input path="educations[0].value" placeholder="Info" class="form-control"/>
                                    </p>
                                </li>
                            </c:if>


                            <li>
                                <input id="buttonEducation" type="button" value="<spring:message code="addNew"/>"
                                       onclick="addEducation();"/>
                            </li>


                        </ul>
                            <%--END OF EDU--%>
                    </div>


                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.achievements"/></h4>
                        <ul class="list-group">

                            <c:if test="${not empty cv.achievements}">
                                <c:forEach items="${cv.achievements}" var="item" varStatus="count">
                                    <li class="list-group-item achi">
                                        <h3 class="list-group-item-heading">
                                            <spring:message code="cv.title"/>
                                            <form:input path="achievements[${count.index}].title" placeholder="Title"
                                                        class="form-control"/></h3>
                                        <p><spring:message code="cv.year"/>
                                            <form:input path="achievements[${count.index}].year" placeholder="Title"
                                                        class="form-control"/>
                                        </p>
                                        <p><spring:message code="cv.basicInformation"/>
                                            <form:input path="achievements[${count.index}].value" placeholder="Info"
                                                        class="form-control"/>
                                        </p>
                                    </li>
                                </c:forEach>
                            </c:if>

                            <c:if test="${empty cv.achievements}">

                                <li class="list-group-item achi">
                                    <h3 class="list-group-item-heading">
                                        <spring:message code="cv.title"/>
                                        <form:input path="achievements[0].title" placeholder="Title"
                                                    class="form-control"/></h3>
                                    <p><spring:message code="cv.year"/>
                                        <form:input path="achievements[0].year" placeholder="Title"
                                                    class="form-control"/>
                                    </p>
                                    <p><spring:message code="cv.basicInformation"/>
                                        <form:input path="achievements[0].value" placeholder="Info"
                                                    class="form-control"/>
                                    </p>
                                </li>

                            </c:if>

                            <li>
                                <input id="buttonAchievements" type="button" value="<spring:message code="addNew"/>"
                                       onclick="addAchievement();"/>
                            </li>

                        </ul>
                    </div>

                    <div class="bs-callout bs-callout-default">
                        <h4><spring:message code="cv.languages"/></h4>
                        <ul class="list-group">

                            <c:if test="${not empty cv.languages}">
                                <c:forEach items="${cv.languages}" var="item" varStatus="count">
                                    <li class="list-group-item lang">
                                        <h3 class="list-group-item-heading"><spring:message code="cv.language"/>
                                            <form:input path="languages[${count.index}].lang" placeholder="Language"
                                                        class="form-control"/></h3>
                                        <p><spring:message code="cv.level"/>
                                            <form:input path="languages[${count.index}].level" placeholder="Level"
                                                        class="form-control"/>
                                        </p>
                                    </li>
                                </c:forEach>
                            </c:if>

                            <c:if test="${empty cv.languages}">
                                <li class="list-group-item lang">
                                    <h3 class="list-group-item-heading"><spring:message code="cv.language"/>
                                        <form:input path="languages[0].lang" placeholder="Language"
                                                    class="form-control"/></h3>
                                    <p><spring:message code="cv.level"/>
                                        <form:input path="languages[0].level" placeholder="Level" class="form-control"/>
                                    </p>
                                </li>
                            </c:if>

                            <li>
                                <input id="buttonLanguages" type="button" value="<spring:message code="addNew"/>"
                                       onclick="addLanguageFunction();"/>

                            </li>
                        </ul>
                    </div>


                    <div class="bs-callout bs-callout-danger">
                        <h4><spring:message code="cv.skills"/></h4>
                        <ul class="list-group">

                            <c:if test="${not empty cv.skills}">
                                <c:forEach items="${cv.skills}" var="item" varStatus="count">
                                    <li class="list-group-item skill">
                                        <h3 class="list-group-item-heading"><spring:message code="cv.skill"/>
                                            <form:input path="skills[${count.index}].title" placeholder="Title"
                                                        class="form-control"/></h3>
                                        <p><spring:message code="cv.basicInformation"/>
                                            <form:input path="skills[${count.index}].value" placeholder="Info"
                                                        class="form-control"/>
                                        </p>
                                    </li>
                                </c:forEach>
                            </c:if>

                            <c:if test="${empty cv.skills}">
                                <li class="list-group-item skill">
                                    <h3 class="list-group-item-heading"><spring:message code="cv.skill"/>
                                        <form:input path="skills[0].title" placeholder="Title"
                                                    class="form-control"/></h3>
                                    <p><spring:message code="cv.basicInformation"/>
                                        <form:input path="skills[0].value" placeholder="Info" class="form-control"/>
                                    </p>
                                </li>
                            </c:if>


                            <li>
                                <input id="buttonSkills" type="button" value="<spring:message code="addNew"/>"
                                       onclick="addSkillFunction();"/>
                            </li>


                        </ul>
                    </div>


                    <div class="bs-callout bs-callout-default">
                        <h4><spring:message code="cv.hobbies"/></h4>
                        <ul class="list-group">

                            <c:if test="${not empty cv.hobbies}">
                                <c:forEach items="${cv.hobbies}" var="item" varStatus="count">
                                    <li class="list-group-item hobby">
                                        <h3 class="list-group-item-heading"><spring:message code="cv.hobby"/>
                                            <form:input path="hobbies[${count.index}].title" placeholder="Title"
                                                        class="form-control"/></h3>
                                        <p><spring:message code="cv.basicInformation"/>
                                            <form:input path="hobbies[${count.index}].value" placeholder="Info"
                                                        class="form-control"/>
                                        </p>
                                    </li>
                                </c:forEach>
                            </c:if>

                            <c:if test="${empty cv.hobbies}">
                                <li class="list-group-item hobby">
                                    <h3 class="list-group-item-heading"><spring:message code="cv.hobby"/>
                                        <form:input path="hobbies[0].title" placeholder="Title"
                                                    class="form-control"/></h3>
                                    <p><spring:message code="cv.basicInformation"/>
                                        <form:input path="hobbies[0].value" placeholder="Info" class="form-control"/>
                                    </p>
                                </li>
                            </c:if>
                            <li>
                                <input id="buttonHobbies" type="button" value="<spring:message code="addNew"/>"
                                       onclick="addHobbyFunction();"/>
                            </li>

                        </ul>
                    </div>

                </div>

                <input type="submit" value="Save">


            </div>
        </div>

    </div>


</form:form>


</body>

<!---------------------------------------- SCRIPTS  ------------------------------------>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>

    function addContactField() {
        var count = $(".contact-one").size();
        var last = $(".contact-one:last");
        var button = $("#buttonContacts");
        button.remove();
        last.after(
                $("<li>", {class: "list-group-item contact-one"}).append(
                        $("<tr>", {class: "contact_id"}).append(
                                $("<td>").text("Contact type:"),
                                $("<td>").append(
                                        $("<input>", {
                                            id: "contacts" + count + ".id",
                                            name: "contacts[" + count + "].id",
                                            type: "text",
                                            placeholder: "Contact type",
                                            class: "form-control"
                                        })
                                )
                        ),
                        $("<tr>", {class: "contact_val"}).append(
                                $("<td>").text("Contact value:"),
                                $("<td>").append(
                                        $("<input>", {
                                            id: "contacts" + count + ".value",
                                            name: "contacts[" + count + "].value",
                                            type: "text",
                                            placeholder: "Contact type",
                                            class: "form-control"
                                        })
                                )
                        )
                ),
                button
        )

    }

    function addWorkExperienceField() {
        var count = $(".workExp").size();
        var last = $(".workExp:last");
        var button = $("#buttonWork");
        button.remove();
        last.after(
                $("<li>", {class: "list-group-item workExp"}).append(
                        $("<h3>", {class: "list-group-item-heading"}).append(
                                $("<td>").text("Company").append(
                                        $("<input>", {
                                            id: "workExperience" + count + ".company",
                                            name: "workExperience[" + count + "].company", type: "text",
                                            placeholder: "Company name", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("Position").append(
                                        $("<input>", {
                                            id: "workExperience" + count + ".position",
                                            name: "workExperience[" + count + "].position", type: "text",
                                            placeholder: "Position", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("From").append(
                                        $("<input>", {
                                            id: "workExperience" + count + ".from",
                                            name: "workExperience[" + count + "].from", type: "text",
                                            placeholder: "From", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("To").append(
                                        $("<input>", {
                                            id: "workExperience" + count + ".to",
                                            name: "workExperience[" + count + "].to", type: "text",
                                            placeholder: "To", class: "form-control"
                                        })
                                )
                        ),
                        $("<p>").append(
                                $("<td>").text("Info").append(
                                        $("<input>", {
                                            id: "workExperience" + count + ".value",
                                            name: "workExperience[" + count + "].value", type: "text",
                                            placeholder: "Info", class: "form-control"
                                        })
                                )
                        )
                ),
                button
        )
    }

    function addEducation() {
        var count = $(".educ").size();
        var last = $(".educ:last");
        var button = $("#buttonEducation");
        button.remove();
        last.after(
                $("<li>", {class: "list-group-item educ"}).append(
                        $("<h3>", {class: "list-group-item-heading"}).append(
                                $("<td>").text("School").append(
                                        $("<input>", {
                                            id: "educations" + count + ".school",
                                            name: "educations[" + count + "].school", type: "text",
                                            placeholder: "School name", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("From").append(
                                        $("<input>", {
                                            id: "educations" + count + ".from",
                                            name: "educations[" + count + "].from", type: "text",
                                            placeholder: "From", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("To").append(
                                        $("<input>", {
                                            id: "educations" + count + ".to",
                                            name: "educations[" + count + "].to", type: "text",
                                            placeholder: "To", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("Info").append(
                                        $("<input>", {
                                            id: "educations" + count + ".basicInformation",
                                            name: "educations[" + count + "].basicInformation", type: "text",
                                            placeholder: "Info", class: "form-control"
                                        })
                                )
                        )
                ),

                button
        )
    }

    function addAchievement() {
        var count = $(".achi").size();
        var last = $(".achi:last");
        var button = $("#buttonAchievements");
        button.remove();
        last.after(
                $("<li>", {class: "list-group-item achi"}).append(
                        $("<h3>", {class: "list-group-item-heading"}).append(
                                $("<td>").text("Title").append(
                                        $("<input>", {
                                            id: "achievements" + count + ".title",
                                            name: "achievements[" + count + "].title", type: "text",
                                            placeholder: "Title", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("Year").append(
                                        $("<input>", {
                                            id: "achievements" + count + ".year",
                                            name: "achievements[" + count + "].year", type: "text",
                                            placeholder: "Year", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("Info").append(
                                        $("<input>", {
                                            id: "achievements" + count + ".value",
                                            name: "achievements[" + count + "].value", type: "text",
                                            placeholder: "Info", class: "form-control"
                                        })
                                )
                        )
                ),
                button
        )
    }


    function addLanguageFunction() {
        var count = $(".lang").size();
        var last = $(".lang:last");
        var button = $("#buttonLanguages");
        button.remove();
        last.after(
                $("<li>", {class: "list-group-item lang"}).append(
                        $("<h3>", {class: "list-group-item-heading"}).append(
                                $("<td>").text("Language").append(
                                        $("<input>", {
                                            id: "languages" + count + ".lang",
                                            name: "languages[" + count + "].lang", type: "text",
                                            placeholder: "Language", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("Level").append(
                                        $("<input>", {
                                            id: "languages" + count + ".level",
                                            name: "languages[" + count + "].level", type: "text",
                                            placeholder: "Level", class: "form-control"
                                        })
                                )
                        )
                ),
                button
        )
    }

    function addSkillFunction() {
        var count = $(".skill").size();
        var last = $(".skill:last");
        var button = $("#buttonSkills");
        button.remove();
        last.after(
                $("<li>", {class: "list-group-item skill"}).append(
                        $("<h3>", {class: "list-group-item-heading"}).append(
                                $("<td>").text("Type").append(
                                        $("<input>", {
                                            id: "skills" + count + ".title",
                                            name: "skills[" + count + "].title", type: "text",
                                            placeholder: "Title", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("Info").append(
                                        $("<input>", {
                                            id: "skills" + count + ".value",
                                            name: "skills[" + count + "].value", type: "text",
                                            placeholder: "Value", class: "form-control"
                                        })
                                )
                        )
                ),
                button
        )
    }

    function addHobbyFunction() {
        var count = $(".hobby").size();
        var last = $(".hobby:last");
        var button = $("#buttonHobbies");
        button.remove();
        last.after(
                $("<li>", {class: "list-group-item hobby"}).append(
                        $("<h3>", {class: "list-group-item-heading"}).append(
                                $("<td>").text("Activity").append(
                                        $("<input>", {
                                            id: "hobbies" + count + ".title",
                                            name: "hobbies[" + count + "].title", type: "text",
                                            placeholder: "Title", class: "form-control"
                                        })
                                )
                        ),

                        $("<p>").append(
                                $("<td>").text("Info").append(
                                        $("<input>", {
                                            id: "hobbies" + count + ".value",
                                            name: "hobbies[" + count + "].value", type: "text",
                                            placeholder: "Value", class: "form-control"
                                        })
                                )
                        )


                ), button
        )
    }

</script>

<!-- SCRIPTS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" property="">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" property="">


</html>
