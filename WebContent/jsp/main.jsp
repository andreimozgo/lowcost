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
	
<h3>Лента новостей</h3>
</head>


<<<<<<< HEAD
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
=======
 <table>
   <c:forEach items="${news}" var="onenews">
>>>>>>> branch 'master' of https://github.com/andreimozgo/lowcost.git
    <tr>
      <thead>
     <td><b><c:out value="${onenews.title}" /></b></td>
       </thead>
     <br>  
     <tbody>
     <td>
     <c:out value="${onenews.annotation}" />
     <br><br>
     <td>Автор:<c:out value="${onenews.author}" /></td>
     <td> </table>
   </c:forEach>
<<<<<<< HEAD
   <td><body>
Role: ${role}</td>
  </tbody>
  <form action="controller" method="post">

   <div>
    <label for="flightDate">Date:</label><br> <input
     type="date" name="flightDate" value="" required />
   </div>

   <div>
    <label for="seats">Seats:</label><br> <input
     type="text" name="seats" value="" required />
   </div>
   <br>
      <div>
    <label for="cost">Cost:</label><br> <input
     type="text" name="cost" value="" required />
   </div>
    <div>
    <label for="upCost">Up cost</label> <select name="upCost">
     <option value="0">0</option>
     <option value="1">1</option>
    </select>
   </div>
   <div>
    <input type="hidden" name="command" value="addflight" /> <input
     type="submit" value="add flight" />
   </div>

 </form>
  
 </table>
=======

>>>>>>> branch 'master' of https://github.com/andreimozgo/lowcost.git
    <br>
	<a href="controller?command=logout">Logout</a>

</body>
</html>