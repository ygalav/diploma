<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="parts/includes.jsp"/>
</head>
<body>
<jsp:include page="parts/Quotation.jsp"/>
<jsp:include page="parts/navbar.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="input-group">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Дія <span class="caret"></span></button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Пошук книги</a></li>
                        <li><a href="#">Пошук студента</a></li>
                    </ul>
                </div><!-- /btn-group -->
                <input type="text" class="form-control" aria-label="...">
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
     </div>
<img class=" col-md-offset-3" src="<c:url value='/resources/img/books.jpg'/>" width="500"height="500">
</div>
</body>
</html>