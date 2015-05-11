<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <jsp:include page="parts/includes.jsp"/>
    <title>${student.surname} ${student.name}</title>
</head>
<body>
    <jsp:include page="parts/navbar.jsp"/>

    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-4">
                    Імя студента
                </div>
                <div class="col-md-8">
                    ${student.name}
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    Прізвище студента
                </div>
                <div class="col-md-8">
                    ${student.surname}
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    Група
                </div>
                <div class="col-md-8">
                    ${student.studentGroupName}
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    Email
                </div>
                <div class="col-md-8">
                    ${student.email}
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    Номер Телефону
                </div>
                <div class="col-md-8">
                    ${student.phone}
                </div>
            </div>
        </div>
    </div>

    <div class="studentRegistrations">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Книга</th>
                <th>Студент</th>
                <th>Група</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentRegistrations}" var="registration">
                <tr>
                    <td>${registration.book.name}</td>
                    <td>${registration.student.surname} ${registration.student.name}</td>
                    <td>${registration.student.studentGroupName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
