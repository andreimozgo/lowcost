<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h3>Добро пожаловать в систему бронирования билетов LOWCOST</h3>
		<h4>Войдите в систему</h4>
	<form name="loginForm" method="POST" action="controller">
		<input type="hidden" name="command" value="login" /> Логин:
		<br/>
		<input type="text" name="login" value="" />
		<br/>Пароль:<br/>
		<input type="password" name="password" value="" />
		<br/><br/>
				<input type="submit" value="Войти" />
		<br/>
			<a href="controller?command=registration">Регистрация</a>
			<br/>
		${errorLoginPassMessage}
		<br/> 
		${wrongAction} 
		<br/>
		${nullPage}
		<br/>
	</form>
	<hr />
</body>
</html>