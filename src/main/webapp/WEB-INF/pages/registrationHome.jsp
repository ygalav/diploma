<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="parts/includes.jsp"/>

    <title></title>
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
<form:form commandName="registrationDto" action="" method="post">

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

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Зберегти реєстрацію</button>
                </div>

</form:form>




    </div>
    <div class="groupTable">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Номер</th>
                <th>Книга</th>
                <th>Студент</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${registrations}" var="registration">
                <tr>
                    <td>${registration.id}</td>
                    <td>${registration.book.name}</td>
                    <td>${registration.student.name}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>



</div>
</body>
</html>
