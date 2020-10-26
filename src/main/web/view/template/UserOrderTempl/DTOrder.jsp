<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="table" class="display">
    <thead>
    <tr>
        <th>id</th>
        <th>Название</th>
        <th>Тип</th>
        <th>Производитель</th>
        <th>Цена</th>
        <th>Количество</th>
        <th>Общая стоимость</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${UserOrders}">
        <tr onclick="document.location = './viewAgent?idAgent=${order.idorder}'">
            <td><c:out value="${order.idorder}"/></td>
            <td><c:out value="${order.nameprod}"/></td>
            <td><c:out value="${order.typename}"/></td>
            <td><c:out value="${order.namemanuf}"/></td>
            <td><c:out value="${order.price}"/></td>
            <td><c:out value="${order.count}"/></td>
            <td><c:out value="${order.finalprice}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>