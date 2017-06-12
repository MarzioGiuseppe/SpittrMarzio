<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo ${spitter.username}</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
  questo è il profilo di <c:out value="${spitter.username}"/>
  <p>
  <span class="spittleMessage">
  Username = ${spitter.username}<br>
  Nome     = ${spitter.firstName}<br>
  Cognome  = ${spitter.lastName}<br>
  Email    = ${spitter.email}<br>
  </span>
</body>
</html>