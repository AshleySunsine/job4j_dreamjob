<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.store.Store" %>
<%@ page import="ru.job4j.dream.model.Post" %>
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
            <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
            <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
<script>
function send() {
    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/dreamjob/listCandidates",
        dataType: "text"
    }).done(function(data, textStatus, jqXHR) {
    var j = JSON.parse(data);
    var candList = j.candidatesList;
    var postList = j.postsList;
    var cityList = j.cityList;

    candList.forEach(function(item, i, arr) {
        cityList.forEach(function(city, i, arr) {
            if (city.id == item.cityId) {
               $('#candidateTable tr:last').after('<tr><th scope="row">' + item.id + '</th><td>'
                   + item.name + '</th><td>'
                   + city.name + '</td></tr>');
            }
        });
    });
    postList.forEach(function(item, i, arr) {
        $('#postTable tr:last').after('<tr><th scope="row">' + item.id + '</th><td>'
                    + item.name + '</th><td>');
    });
});
}
</script>
    <title>Работа мечты</title>
</head>
<body>

<script>
    send();
</script>

<div class="container">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Вакансии</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Кандидаты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Добавить вакансию</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidate/edit.do">Добавить резюме</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Войти</a>
            </li>
            <c:if test="${user != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/logout.do">Выйти</a>
                </li>
           </c:if>
        </ul>
    </div>

    <div class="col-md-7">
    <div class="row">
        <div class="card" style="width: 100%" name="Post">
            <div class="card-header">
                Сегодняшние вакансии.
            </div>
            <div class="card-body">
             <table class="table table-striped table-dark" id="postTable">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Имя</th>
                    </tr>
                </thead>
                <tbody>

                    </tr>
                 </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row pt-3">
        <div class="card" style="width: 100%" name="Candidate">
            <div class="card-header">
                Сегодняшние кандидаты.
            </div>
            <div class="card-body">
                <table class="table table-striped table-dark" id="candidateTable">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Имя</th>
                            <th scope="col">Город(Id)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        </tr>
                     </tbody>
                    </table>
            </div>
        </div>
    </div>
</div> </div>
</body>
</html>