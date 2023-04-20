<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "now" value = "<%= new java.util.Date()%>" />
<div class="container d-flex justify-content-between align-items-center">
    <div>
        <p class="currentDateTime">${now}</p>
    </div>
    <div>
        <div class="dropdown">
            <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown"
                aria-expanded="false">
                <c:choose>
                		<c:when test="${not empty user.avatar}">
                			<img src="${user.avatar}" class="profileLogo">
                		</c:when>
                		<c:otherwise>
                			<img src="image/user1.png" class="profileLogo">
                		</c:otherwise>
                	</c:choose>
                <span class="gotoMainbar"><c:out value="${user.first_name} ${user.last_name}" /></span> 
                
                <img src="image/drop-down.png"
                    class="gotoMainbar">
            </button>
            <ul class="dropdown-menu dropdown-menu-end">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another </a></li>
                <li><a class="dropdown-item" href="#">Something</a></li>
            </ul>
        </div>
    </div>
</div>