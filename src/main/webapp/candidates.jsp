<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.store.Store" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.model.City" %>
<%@ page import="java.util.Collection" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Работа мечты</title>
</head>
<body>

<div class="container">
    <div class="row">
        <ul class="nav">
        <c:if test="${user != null}">
           <li class="nav-item">
               <a class="nav-link" href="<%=request.getContextPath()%>/logout.do">Выйти</a>
            </li>
         </c:if>
        </ul>
    </div>

<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Кандидаты
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Названия</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${candidates}" var="candidate">
                      <tr>
                        <td>
                           <a href='<c:url value="/candidate/edit.do?id=${candidate.id}"/>'>
                            <i class="fa fa-edit mr-3"></i>
                           </a>
                           Имя: <c:out value="${candidate.name}"/><br>
                           <c:forEach items="${cities}" var="ci">
                           <c:if test="${ci.id == candidate.cityId}">
                           Город: <c:out value="${ci.name}"/><br>
                           </c:if>
                           </c:forEach>
                           Id кандидата: <c:out value="${candidate.id}"/><br>
                           Id города: <c:out value="${candidate.cityId}"/><br>
                           <img src="<c:url value='/download?name=${candidate.id}.jpg'/>" width="100px" height="100px"/>

                           <td>
                           <form action="<c:url value='/candidate/PhotoUpload.jsp?id=${candidate.id}.jpg'/>" method="post" enctype="multipart/form-data">
                                 <button type="submit" class="btn btn-default">Добавить</button>
                           </form>

                           <form action="<c:url value='/deleteImage?id=${candidate.id}.jpg'/>" method="post" enctype="multipart/form-data">
                                <button type="submit" class="btn btn-default">Удалить фото</button>
                            </form>

                           <form action="<c:url value='/DeleteCandidate?id=${candidate.id}.jpg'/>" method="post" enctype="multipart/form-data">
                             <button type="submit" class="btn btn-default">Удалить кандидата</button>
                           </form>

                         </td>
                        </td>
                      </tr>
                       </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>