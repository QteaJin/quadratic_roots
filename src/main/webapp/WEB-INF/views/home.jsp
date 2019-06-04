<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv = "Content-Type" content="text/html ; charset=UTF-8"> 
	<title>Home</title>
</head>
<body>
<h1>
	Введите даные для расчета уравнений вида "ax^2 + bx + c = 0"
</h1>
<form:form method="POST"   id="myForm" action="getResult" modelAttribute="data">
<form:label path="paramA">Параметр "а"</form:label>
<form:input path="paramA"/>
<p>
<form:label path="paramB">Параметр "b"</form:label>
<form:input path="paramB"/>
<p>
<form:label path="paramC">Параметр "c"</form:label>
<form:input path="paramC"/>
<input type="submit" value="Рассчитать">
</form:form>

</body>
</html>
