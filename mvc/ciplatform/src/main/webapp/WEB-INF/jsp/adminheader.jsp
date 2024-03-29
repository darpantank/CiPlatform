<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type = "text/javascript" >
const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
const days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];   
   
//    function preventBack(){window.history.forward();}
//     setTimeout("preventBack()", 0);
//     window.onunload=function(){null};
    function display_c(){
    	var refresh=1000; // Refresh rate in milli seconds
    	mytime=setTimeout('display_ct()',refresh)
    	}

    	function display_ct() {
    		let x=new Date();
    		let fdate=days[x.getDay()]+" "+months[x.getMonth()]+" "+x.getDate()+", "+x.getFullYear()+", "+x.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true });
    	document.getElementById('ct').innerHTML=fdate;
    	display_c();
    	 }
    	window.onload = function() {
    		display_ct();
    		};
    	
</script>
<div class="container d-flex justify-content-between align-items-center">
    <div>
        <p id="ct"></p>
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
                <li><a class="dropdown-item" href="../logout">Logout</a></li>
            </ul>
        </div>
    </div>
</div>