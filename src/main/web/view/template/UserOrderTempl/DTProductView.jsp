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
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}">
        <tr onclick="document.location = './addOrder?idProduct=${product.idproduct}'">
            <td><c:out value="${product.idproduct}"/></td>
            <td><c:out value="${product.nameprod}"/></td>
            <td><c:out value="${product.typename}"/></td>
            <td><c:out value="${product.namemanuf}"/></td>
            <td><c:out value="${product.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>