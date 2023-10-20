<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h2>Student Info update</h2>
<hr>
<form action="/student?action=update" method="post">
    <p>id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="text" name="id" value="${student.id}" readonly></p>
    <p>name:<input type="text" name="name" value="${student.name}"></p>
    <p>univ :<input type="text" name="univ" value="${student.univ}" readonly></p>
    <p>birth:<input type="text" name="birth" value="${student.birth}" readonly></p>
    <p>email:<input type="text" name="email" value="${student.email}"></p>
    <input type="submit" value="수정">
</form>
</body>
</html>