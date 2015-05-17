<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="parts/includes.jsp"/>
    <style>
        .datepicker{z-index:1151 !important;}
    </style>
    <title></title>
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">

    <div class="row">
        <div class="col-md-12">
            <form:form commandName="registrationDto" action="search">
                <div class="col-md-1">
                    <form:label path="student.studentGroupName">Група</form:label>
                </div>
                <div class="col-md-2">
                    <form:select id="student" path="student.studentGroupName" class="form-control">
                    <c:forEach items="${students}" var="student">
                        <form:option value="${student.studentGroupName}" label="${student.studentGroupName}"/>
                    </c:forEach>
                    </form:select>
                </div>
            <div class="col-md-1">
                <form:label path="student.surname">Прізвище</form:label>
            </div>
            <div class="col-md-2">
                <form:input path="student.surname" type="text" class="form-control"/>
            </div>
            <div class="col-md-1">
                <form:label path="student.name">Ім'я</form:label>
            </div>
            <div class="col-md-2">
                <form:input path="student.name" type="text" class="form-control"/>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-primary">Пошук</button>
            </div>
            </form:form>
         </div>
    </div>

    <div class="row">
        <div class="col-md-2 col-md-offset-5">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Додати
                реєстрацію
            </button>
        </div>
    </div>


    <div class="groupTable">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Книга</th>
                <th>Студент</th>
                <th>Група</th>
                <th>Запланована дата здачі</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${registrations}" var="registration">
                <tr>
                    <td>${registration.book.name}</td>
                    <td><a href="/students/${registration.student.id}">${registration.student.surname} ${registration.student.name}</a></td>
                    <td>${registration.student.studentGroupName}</td>
                    <td>${registration.returnDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <form:form commandName="registrationDto" action="" method="post">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Додати реєстрацію </h4>
                    </div>

                    <div class="modal-body">
                        <div class="row form-group stud-name">
                            <div class="col-md-4">
                                <label for="student">Прізвище студента</label>
                            </div>
                            <div class="col-md-8">

                                <form:select id="student" path="student.id" class="form-control">
                                    <c:forEach items="${students}" var="student">
                                        <form:option value="${student.id}" label="${student.surname}  ${student.name}"/>
                                    </c:forEach>
                                </form:select>

                            </div>
                        </div>
                    </div>
                    <div class="modal-body">
                        <div class="row form-group book-name">
                            <div class="col-md-4">
                                <label for="book">Назва книги</label>
                            </div>
                            <div class="col-md-8">

                                <form:select id="book" path="book.id" class="form-control">

                                    <c:forEach items="${books}" var="book">
                                        <form:option value="${book.id}" label="${book.name}"/>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                    </div>

                    <div class="modal-body">
                        <div class="row form-group book-name">
                            <div class="col-md-4">
                                <label for="book"> Запланована дата здачі</label>
                            </div>
                            <div class="col-md-8">
                                <input name="returnDate" class="datepicker" data-provide="datepicker">
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Зберегти реєстрацію</button>
                    </div>
                </div>

            </form:form>


        </div>
    </div>
</div>
</div>
</body>
</html>
