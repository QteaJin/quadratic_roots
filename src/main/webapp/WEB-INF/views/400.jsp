<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv = "Content-Type" content="text/html ; charset=UTF-8"> 
	<title>Error income Data</title>
</head>
<body>
<h1>
	Введите правильные данные в указанные поля! 
</h1>
<h3>Данные должны быть числами. Дробные числа должны разделяться "точкой". Например: 3.52 </h3>
<c:url var="back" value="/" />
<a href="${back}">На главную</a>
</body>
</html>
