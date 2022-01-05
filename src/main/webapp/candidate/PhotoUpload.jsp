<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>URL</th>
            <th>View</th>
        </tr>
        </thead>
    </table>
    <h2>Upload image</h2>
<form action="<%=request.getContextPath()%>/uploadImageCandidate?id=<%=request.getParameter("id")%>"
      method="post" enctype="multipart/form-data">
        <div class="checkbox">
            <input type="file" name="name">
        </div>
        <button type="submit" class="btn btn-default">Загрузить</button>
    </form>
</div>
</body>
</html>