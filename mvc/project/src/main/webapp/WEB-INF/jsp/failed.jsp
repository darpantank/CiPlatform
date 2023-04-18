<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Some Error</title>
</head>
<body>
	<h1>Unable to Process Your Request Due to...</h1>
	<h2><c:if test="${not empty message}">
		${message}
	</c:if></h2>
	<c:remove var="message"/>
</body>
</html>