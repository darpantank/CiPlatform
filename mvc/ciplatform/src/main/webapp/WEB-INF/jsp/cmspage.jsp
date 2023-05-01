<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${empty cms}">
		<%
		response.sendRedirect("home");
		%>
	</c:if>
<meta charset="ISO-8859-1">
		
<title>${cms.title}</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	    <jsp:include page="spinner.jsp" />
	<div class="container">
		${cms.description}
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script src="<c:url value="/js/spinner.js"></c:url>"></script>
</body>
</html>