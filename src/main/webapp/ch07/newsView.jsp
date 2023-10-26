<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <title>뉴스 상세 보기</title>
</head>
<body>
    <div class="container w-75 mt-5 mx-auto">
        <h2>${news.title}</h2>
        <hr>
        <div class="card w-75 mx-auto">
            <img class="card-img-top" src="${news.img}">
            <div class="card-body">
                <h4 class="card-title">Date: ${news.date}</h4>
                <p class="card-text">Content: ${news.content}</p>
            </div>
        </div>
        <hr>
        <c:if test="${error != null}">
            <div class="alert alert-danger alert-dismissible fade show mt-3">
                에러발생: ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </c:if>
        <a href="javascript:history.back()" class="btn btn-primary"><< Back</a>
    </div>
</body>
</html>
