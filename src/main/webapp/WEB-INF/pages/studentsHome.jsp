<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="parts/includes.jsp"/>


    <title>Студенти</title>
</head>
<body>
    <jsp:include page="parts/navbar.jsp"/>
<div class="container">

    <div class="row">
        <div class="col-md-12">
            <form:form commandName="studentDto" action="search">
                <div class="col-md-1">
                    <form:label path="studentGroupName">Група</form:label>
                </div>
                <div class="col-md-2">
                    <form:select  path="studentGroupName" class="form-control">
                        <c:forEach items="${students}" var="student">
                            <form:option value="${studentGroupName}" label="${studentGroupName}"/>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="col-md-1">
                    <form:label path="surname">Прізвище</form:label>
                </div>
                <div class="col-md-2">
                    <form:input path="surname" type="text" class="form-control"/>
                </div>
                <div class="col-md-1">
                    <form:label path="name">Ім'я</form:label>
                </div>
                <div class="col-md-2">
                    <form:input path="name" type="text" class="form-control"/>
                </div>

                <div class="col-md-3">
                    <button type="submit" class="btn btn-primary">Пошук</button>
                </div>
            </form:form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2 col-md-offset-5">
            <button type="button" class="btn btn-primary stud" data-toggle="modal" data-target=".bs-example-modal-lg">
                Додати студента
            </button>

        </div>
    </div>
    <div class="studTable">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Студент</th>
            <th>Група</th>
            <th>Email</th>
            <th>Номер телефону</th>
            <th>Дії</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="property">
            <tr>
                <td><a href="${property.id}">${property.surname} ${property.name}</a></td>
                <td>${property.studentGroupName}</td>
                <td>${property.email}</td>
                <td>${property.phone}</td>
                <td><span class="btn btn-danger disabled">Видалити</span></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
 </div>



    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <form:form commandName="studentDto" action="" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Додати cтудента </h4>
                </div>
                <div class="modal-body">
                    <div class="row form-group stud-name">
                        <div class="col-md-4">
                            <label for="stud-name">Ім'я</label>
                        </div>
                        <div class="col-md-8">
                            <form:input path="name" id="stud-name" class="form-control"/>
                        </div>
                    </div>
                    <div class="row form-group stud-surname">
                        <div class="col-md-4">
                            <label for="stud-surname">Прізвище</label>
                        </div>
                        <div class="col-md-8">
                            <form:input id="stud-surname" path="surname" class="form-control"/>
                        </div>
                    </div>
                    <div class="row form-group stud-group">
                        <div class="col-md-4">
                            <label id="groups">Група</label>
                        </div>
                        <div class="col-md-8">
                            <form:select  path="name" class="form-control">

                                <c:forEach items="${groups}" var="group">
                                    <form:option value="${group.name}" label="${group.name}"/>
                                </c:forEach>

                            </form:select>
                        </div>
                    </div>
                    <div class="row form-group stud-email">
                        <div class="col-md-4">
                            <label for="stud-email">Email</label>
                        </div>
                        <div class="col-md-8">
                            <form:input id="stud-email" path="email" class="form-control"/>
                        </div>
                    </div>

                    <div class="row form-group stud-phone">
                        <div class="col-md-4">
                            <label for="stud-phone">Номер телефону</label>
                        </div>
                        <div class="col-md-8">
                            <form:input id="stud-phone" path="phone" class="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Відмінити</button>
                    <button type="submit" class="btn btn-primary">Зберегти студента</button>
                </div>
                </form:form>
            </div>
        </div>

    </div>
        </div>
</body>
</html>
