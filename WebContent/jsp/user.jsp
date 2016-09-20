<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<h3>Система бронирования билетов LOWCOST</h3>
	<hr />
	${user}, hello!
	<hr />
	
<h3>Расписание рейсов</h3>
</head>


 <table border="1">
 <thead align = "center">
   <tr>
    <th>Номер рейса</th>
    <th>Дата</th>
    <th>Количество мест</th>
    <th colspan="2">Action</th>
   </tr>
  </thead>
  <tbody align = "center">
   <c:forEach items="${flights}" var="flight">
    <tr>
     <td><c:out value="${flight.id}" /></td>
     <td><c:out value="${flight.date}" /></td>
     <td><c:out value="${flight.seats}" /></td>
     <td>
     <a
      href="Controller?action=edit&id=<c:out value="${flight.id }"/>">Update</a></td>
     <td><a
      href="Controller?action=delete&id=<c:out value="${flight.id }"/>">Delete</a></td>
    </tr>
   </c:forEach>
   <td><body>
Role: ${role}</td>
  </tbody>
    <br>
	<a href="controller?command=logout">Logout</a>

</body>
</html>