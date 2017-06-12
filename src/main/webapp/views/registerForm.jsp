<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Form</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Register!</h1>

	<!--      <form method="POST" > non indico una action="/spittr/spitter/register"> -->
	<!--         Nome: <input type="text" name="firstName" value=Mar><br/> -->
	<!--         Cognome: <input type="text" name="lastName" value="Par"/><br/> -->
	<!--         Username: <input type="text" name="username" /><br/> -->
	<!--         Password: <input type="password" name="password" /><br/> -->
	<!--         Email <input type="email" name="email" value="marzio.parenti@gmail.com"/><br/> -->
	<!--         <input type="submit" value="Registra"> -->
	<!--     </form> -->

	<sf:form method="POST" commandName="spitter">
	   <sf:errors path="*" element="div" cssClass="error"/><br/>
		<!-- non indico una action="/spittr/spitter/register"> :in questo modo torna su se stessa -->
		Nome: <sf:input path="firstName" value="Marzio"/>
		<sf:errors path="firstName" cssClass="error"/><br/>
		Cognome: <sf:input path="lastName" />
		<sf:errors path="lastName" cssClass="error"/><br/>
		Email <sf:input path="email"  />
		<sf:errors path="email" cssClass="error"/><br/>
		Username: <sf:input path="username" />
		<sf:errors path="username" cssClass="error"/><br/>
		Password: <sf:password path="password" />
		<sf:errors path="password" cssClass="error"/><br/>
		<input	type="submit" value="Registra">
	</sf:form>
	
	<p>
		Elenco campi errati:
		<c:forEach var="errore" items="${elencoErrori}" varStatus="loop">
			<li id="field_<c:out value="${loop.index}"/>">
				<div class="spittleMessage">
					Errore nr
					<c:out value="${loop.index }" />
					field :
					<c:out value="${errore.field}" />
				</div>
			</li>
		</c:forEach>
</body>
</html>