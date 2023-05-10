<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <div class="w3-sidebar w3-bar-block w3-card w3-animate-left myMainSideBar" style="display:none" id="leftMainMenu">
        <button onclick="closeLeftMainMenu()" class="w3-bar-item w3-button w3-large"> <img src="image/cancel.png"
                class="sidebarClosingButton" alt="" srcset=""></button>
        <a href="#" class="w3-bar-item w3-button">Explore</a>
        <a href="story" class="w3-bar-item w3-button">Story</a>
        <a href="#" class="w3-bar-item w3-button">Policy</a>
    </div>
    <nav class="navbar navbar-expand-lg row d-flex  flex-row justify-content-end">
        <div class="container-fluid d-flex flex-row col">
            <button class="w3-button w3-xlarge w3-left navbar-toggler" onclick="openLeftMainMenu()"
                data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                <img src="image/list.png" alt="" srcset="">
            </button>
            <div class="collapse navbar-collapse left gotoMainbar" id="navbarNav">
                <a href="home" class="logo">HomePage</a>
                <c:if test="${admin.role=='ADMIN' }">
                <a href="admin/users" >Admin Panel</a>
                </c:if>
<!--                 <div class="dropdown "> -->
           
<!-- 				<select class="border-0"> -->
<!-- 				<div class="dropdown-menu exploreMenu"> -->
<!-- 					<option class="dropdown-item" selected hidden>Explore</option> -->
<!-- 					<option class="dropdown-item">Top Themes</option> -->
<!-- 					<option class="dropdown-item">Most Ranked</option> -->
<!-- 					<option class="dropdown-item">Top Favourite</option> -->
<!-- 				</div> -->
<!--                 </select> -->
<!--                 </div> -->
                <a href="story" class="logo">Stories</a>
                <div class="dropdown">
                    <a class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        Policy <img src="image/drop-down.png">
                    </a>
				
				<ul class="dropdown-menu">
				<c:if test="${not empty cms}">
					<c:forEach var="a" items="${cms}">
						<li><a class="dropdown-item" href="privacy#${a.slug}">${a.title}</a></li>
					</c:forEach>
				</c:if>
                    </ul>
                </div>
            </div>

        </div>
        <div class="d-flex right col">
            <!-- <img src="image/user-img-large.png" class="profileLogo"> -->
            <div class="bellSearch d-flex align-content-center">
                <!-- Only For Mobile View Only  -->
                <img src="image/search.png" class="searchButtonMonitor" alt="" onclick="openSecondHeader()"></button>
                
            </div>
             <c:if test="${not empty user.email}">
            <div class="dropdown">
                <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                	<c:choose>
                		<c:when test="${not empty user.avatar}">
                			<img src="${user.avatar}" class="profileLogo">
                		</c:when>
                		<c:otherwise>
                			<img src="image/user1.png" class="profileLogo">
                		</c:otherwise>
                	</c:choose>
                    
                    <span class="gotoMainbar"><c:out value="${user.firstName} ${user.lastName}" /></span> <img src="image/drop-down.png" class="gotoMainbar">
                </button>
                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-lg-start">
                    <li><a class="dropdown-item" href="profile">My Profile</a></li>
                    <li><a class="dropdown-item vtsheet" href="timesheet">Volunteering Timesheet</a></li>
                    <li><a class="dropdown-item" href="logout">Log Out</a></li>
                </ul>
            </div>
             </c:if>
        </div>
    </nav>
   
    <script src="js/sidebarJs.js"></script>