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

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Пошук книги...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Знайти</button>
      </span>
            </div>
            <!-- /input-group -->
        </div>
        <!-- /.col-lg-6 -->
    </div>

    <div class="row">
        <div class="col-md-2 col-md-offset-5">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Додати книгу</button>
        </div>
    </div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Назва</th>
            <th>Автор</th>
            <th>Код</th>
            <th>Дії</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${spysokBook}" var="property">
            <tr>
                <td>${property.id}</td>
                <td>${property.name}</td>
                <td>${property.author}</td>
                <td>${property.code}</td>
                <td><span class="btn btn-danger disabled">Видалити</span></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <div class="row">
        <div class="list-group col-md-8 col-md-offset-2">
            <a href="#" class="list-group-item disabled">
                Категорії
            </a>
            <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
            <a href="#" class="list-group-item">Morbi leo risus</a>
            <a href="#" class="list-group-item">Porta ac consectetur ac</a>
            <a href="#" class="list-group-item">Vestibulum at eros</a>
        </div>
    </div>
</div>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Додати книгу </h4>
            </div>
            <div class="modal-body">
                <div class="row form-group book-name">
                    <div class="col-md-4">
                        <label for="book-name">Назва</label>
                    </div>
                    <div class="col-md-8">
                        <input id="book-name" name="name" class="form-control"/>
                    </div>
                </div>

            </div>
            <div class="row form-group book-author">
                <div class="col-md-4">
                    <label for="book-author">Автор</label>
                </div>
                <div class="col-md-8">
                    <input id="book-author" name="author" class="form-control"/>
                </div>
            </div>
            <div class="row form-group book-code">
                <div class="col-md-4">
                    <label for="book-code">Код</label>
                </div>
                <div class="col-md-8">
                    <input id="book-code" name="code" class="form-control"/>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Відмінити</button>
                <button type="button" class="btn btn-primary">Зберегти книгу</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>