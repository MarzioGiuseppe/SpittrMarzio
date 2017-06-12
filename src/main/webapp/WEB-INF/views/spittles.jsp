<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spittles</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>

	<c:forEach var="spittle" items="${spittleList}">
	<li id="spittle_<c:out value="${spittle.id}"/>">
	<div class="spittleMessage"> Item <c:out value="${spittle.message}" /> |</div>
	<div> 
		<span class="spittleTime"> 
		Time <c:out value="${spittle.time}" />
		</span>
		<span class="spittleLocation">
			(<c:out value="${spittle.latitude} / ${spittle.longitude}"/>)
		</span> 
	</div>
	
	<div class="spittleMessage">
		Id <c:out value="${spittle.id}" /> |
	</div>
	 
	</li>
	</c:forEach>
	
</body>
</html>