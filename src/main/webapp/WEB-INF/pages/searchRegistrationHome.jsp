<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="parts/includes.jsp"/>

</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<form:form commandName="searchRegistrationDto" action="" method="post">


<div class="row form-group stud-surname">

    <div class="col-md-4">
        <label for="studentName">Прізвище</label>
    </div>
    <div class="col-md-8">
        <form:input id="studentName" path="builder" class="form-control"/>
    </div>
</div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">Зберегти </button>
    </div>
</form:form>
</body>
</html>
