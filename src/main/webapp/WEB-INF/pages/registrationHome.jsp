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
                    <label for="stud-name">Прізвище студента</label>
                </div>
                <div class="col-md-8">

                    <input id="stud-name" name="surname" class="form-control"/>
                </div>
            </div>

</form:form>

    </div>



</div>
</body>
</html>
