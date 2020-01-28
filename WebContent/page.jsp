<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nombre aléatoire</title>
</head>
<body>
<form action="random.php" method="post">
Devinez: <input type="text" name="nombre" />
<input type="submit" name="action" value="jouer"/>
<input type="submit" name="action" value="relancer"/>
 



</form>
<table>
<c:forEach items="${modelJ.getHistoriques()}" var="rep">

<tr>
<td>

${rep}</td>


</tr>

</c:forEach>


</table>
</body>
</html>