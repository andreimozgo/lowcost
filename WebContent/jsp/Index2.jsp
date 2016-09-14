<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>JSP input</title>
</head>
<body>
	<form action="inputaction" method="POST">
		Введите Имя:<input name="fio" type="text"><br> 
		Введите Телефон:<input name="phone" type="text"><br> 
		Введите email:<input name="mail" type="text"><br>
		<input type="submit">
	</form>
</body>
</html>