<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pippo Pippo Pippo</title>
</head>
<body>

<c:set var="stringa"  value="  pippo pippo pippo!  "/>
<c:set var="stringa1" value="${fn:trim(stringa)}"/>
<c:out value="il valore di stringa è ${stringa} , lungh=${fn:length(stringa)} "/>
<br>
<c:out value="il valore di stringa1 è ${stringa1} , lungh=${fn:length(stringa1)} "/>
<br>
<p>Lunghezza di stringa = ${fn:length(stringa)}</p>
<p>Lunghezza di stringa trimmata = ${fn:length(stringa1)}</p>  
</body>
</html>