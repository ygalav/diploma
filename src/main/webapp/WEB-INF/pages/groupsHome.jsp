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
<div class="groupTable">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Назва</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${spysokGroup}" var="property">
            <tr>
                <td>${property.id}</td>
                <td>${property.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
