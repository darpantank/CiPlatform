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
                			<img src="<c:url value="/${user.avatar}"></c:url>" class="profileLogo">
                		</c:when>
                		<c:otherwise>
                			<img src="<c:url value="/image/user1.png"></c:url>" class="profileLogo" >
                		</c:otherwise>
                	</c:choose>
                <span class="gotoMainbar"><c:out value="${user.firstName} ${user.lastName}" /></span> 
                
<%--                 <img src="<c:url value="/image/drop-down.png"></c:url>" --%>
<!--                     class="gotoMainbar"> -->
            </button>
            <ul class="dropdown-menu dropdown-menu-end">
            	<li><a class="dropdown-item" href="../homeadmin">userpage</a></li>
                <li><a class="dropdown-item" href="adminlogout">Logout</a></li>
            </ul>
        </div>
    </div>
</div>