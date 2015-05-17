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
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
<img class=" col-md-offset-3" src="<c:url value='/resources/img/books.jpg'/>" width="500"height="500">
</div>
</body>
</html>