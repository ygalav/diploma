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
<jsp:include page="parts/Quotation.jsp"/>
<jsp:include page="parts/navbar.jsp"/>


<div class="container">

<div class="row>">
    <div class="col-md-8 col-md-offset-2">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Пошук книги...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Знайти</button>
      </span>
        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
    <button class="newbook col-md-6 col-md-offset-3" type="button">Додати книгу</button>
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
</body>
</html>