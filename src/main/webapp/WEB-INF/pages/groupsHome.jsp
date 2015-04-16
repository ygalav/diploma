<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="parts/includes.jsp"/>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">

    <div class="row">
        <div class="col-md-2 col-md-offset-5">
            <button type="button" class="btn btn-primary stud" data-toggle="modal" data-target=".bs-example-modal-lg">
                Додати групу
            </button>

        </div>
    </div>
<div class="groupTable">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Назва</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${groups}" var="property">
            <tr>
                <td>${property.id}</td>
                <td>${property.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <form:form commandName="groupDto" action="" method="post">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Додати групу </h4>
            </div>
            <div class="modal-body">
                <div class="row form-group group-name">
                    <div class="col-md-4">
                        <label for="group-name">Назва</label>
                    </div>
                    <div class="col-md-8">
                        <form:input id="group-name" path="name" class="form-control"/>
                    </div>
                </div>

            </div>



            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Відмінити</button>
                <button type="submit" class="btn btn-primary">Зберегти групу</button>
            </div>
            </form:form>>
        </div>
    </div>
</div>
</body>
</html>
