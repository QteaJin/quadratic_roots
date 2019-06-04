<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv = "Content-Type" content="text/html ; charset=UTF-8"> 
	<title>Result</title>
</head>
<body>

<h1>
	Корни уравнения ${data.paramA} x^2+ ${data.paramB} x +  ${data.paramC} = 0;
</h1>
<h3> Результат </h3>
<c:forEach var="num" items="${data.result}">
    <p>${num}</p>
</c:forEach>
<c:url var="back" value="/" />
<a href="${back}">На главную</a>
</body>
</html>
