<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script
          src="https://code.jquery.com/jquery-3.5.1.js"
          integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

  <style>
    <%@include file='./css/style.css' %>
  </style>
</head>
<body>
<div class="p-3">
  <div class="w-25 p-3 mx-auto" >
    <h2>Вход в сиcтему</h2>
    <form method="post" class="py-3" >
      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="login">Логин</label>
          <input type="text" class="form-control" id="login" name="login" placeholder="Введите логин">
        </div>
      </div>
      <div class="form-row">
        <div class="form-group col-md-12">
          <label for="password">Пароль</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Введите пароль">
        </div>
      </div>
      <button type="submit" class="btn btn-primary" formaction="./authUser">Войти</button>
    </form>
    <c:if test="${userIsAuth == false}">
      <div class="alert alert-danger alert-dismissible fade show col-md-12" role="alert">
        <strong>логин/пароль не верны</strong> Проверьте вводимые значения
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
    </c:if>
  </div>
</div>
</body>
</html>