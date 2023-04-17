<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Requested Page Not Found</title>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	.pageNotFound{
		height:100vh;
		width:auto;
	}
</style>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"></c:url>">
</head>
<body>
	<div class="container d-flex justify-content-center">	
		<img class="pageNotFound" src="<c:url value="/image/404-Page-image.png"></c:url>">
	</div>
</body>
</html>