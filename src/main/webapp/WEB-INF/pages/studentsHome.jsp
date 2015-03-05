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
    <div class="row">
        <div class="col-md-2 col-md-offset-5">
            <button type="button" class="btn btn-primary stud" data-toggle="modal" data-target=".bs-example-modal-lg">
                Додати студента
            </button>

        </div>
    </div>

    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-lg">
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
                            <input id="stud-name" name="name" class="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="row form-group stud-surname">
                    <div class="col-md-4">
                        <label for="stud-surname">Прізвище</label>
                    </div>
                    <div class="col-md-8">
                        <input id="stud-surname" name="surname" class="form-control"/>
                    </div>
                </div>
                <div class="row form-group stud-group">
                    <div class="col-md-4">
                        <label for="stud-group">Група</label>
                    </div>
                    <div class="col-md-8">
                        <input id="stud-group" name="group" class="form-control"/>
                    </div>
                </div>
                <div class="row form-group stud-email">
                     <div class="col-md-4">
                          <label for="stud-email">Email</label>
                     </div>
                     <div class="col-md-8">
                          <input id="stud-email" name="email" class="form-control"/>
                     </div>
                </div>

                <div class="row form-group stud-phone">
                      <div class="col-md-4">
                            <label for="stud-phone">Номер телефону</label>
                      </div>
                      <div class="col-md-8">
                            <input id="stud-phone" name="phone" class="form-control"/>
                      </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Відмінити</button>
                    <button type="button" class="btn btn-primary">Зберегти студента</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
