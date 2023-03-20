<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>

<body>
    <!-- main w3-sidebar -->
    
    <!-- <div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="leftMainMenu">
        <button onclick="closeLeftMainMenu()" class="w3-bar-item w3-button w3-large"> <img src="image/cancel.png"
                class="sidebarClosingButton" alt="" srcset=""></button>
        <a href="#" class="w3-bar-item w3-button">Explore</a>
        <a href="#" class="w3-bar-item w3-button">Story</a>
        <a href="#" class="w3-bar-item w3-button">Policy</a>
    </div> -->

    <!-- Filter SideBar -->
    <div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="leftFilterMenu">
        <button onclick="closeLeftFilterMenu()" class="w3-bar-item w3-button w3-large"><img src="image/cancel.png"
                alt="" srcset=""></button>
        <!-- Filters dropdown Sidebar  -->

        <div class="dropdown mysidebar">
            <button class="btn dropdown-toggle w-100 d-flex justify-content-between align-items-center" type="button"
                data-bs-toggle="dropdown" aria-expanded="true">
                <span>Country</span>
                <img src="image/drop-down.png">
            </button>
            <ul class="dropdown-menu">
                <li><input type="checkbox"> India</li>
                <li><input type="checkbox"> USA</li>
            </ul>
        </div>
        <div class="dropdown mysidebar">
            <button class="btn dropdown-toggle w-100 d-flex justify-content-between align-items-center" type="button"
                data-bs-toggle="dropdown" aria-expanded="false">
                <span>City</span>
                <img src="image/drop-down.png">
            </button>
            <ul class="dropdown-menu">
                <li><input type="checkbox"> Ahmedabad</li>
                <li><input type="checkbox"> Delhi</li>
            </ul>
        </div>
        <div class="dropdown mysidebar">
            <button class="btn dropdown-toggle w-100 d-flex justify-content-between align-items-center" type="button"
                data-bs-toggle="dropdown" aria-expanded="false">
                <span>Theme</span>
                <img src="image/drop-down.png">
            </button>
            <ul class="dropdown-menu">
                <li><input type="checkbox"> Dark</li>
                <li><input type="checkbox"> Light</li>
            </ul>
        </div>
        <div class="dropdown mysidebar">
            <button class="btn dropdown-toggle w-100 d-flex justify-content-between align-items-center" type="button"
                data-bs-toggle="dropdown" aria-expanded="false">
                <span>Skill</span>
                <img src="image/drop-down.png">
            </button>
            <ul class="dropdown-menu">
                <li><input type="checkbox"> Dance</li>
                <li><input type="checkbox"> Reading</li>
            </ul>
        </div>
    </div>

    <!-- NAvbar  -->
    <div class="container-fluid">
	<jsp:include page="fheader.jsp" />
    </div>
	
    <!-- <nav class="navbar navbar-expand-lg d-flex row flex-row justify-content-end">
        <div class="container-fluid d-flex flex-row col">
            <button class="w3-button w3-xlarge w3-left navbar-toggler" onclick="openLeftMainMenu()"
                data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                <img src="image/list.png" alt="" srcset="">
            </button>
            <div class="collapse navbar-collapse left gotoMainbar" id="navbarNav">
                <a href="#" class="logo">Stories</a>
                <div class="dropdown">
                    <a class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        Policy <img src="image/drop-down.png">
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </div>
            </div>

        </div>
        <div class="d-flex right col">
            <img src="image/user-img-large.png" class="profileLogo">
            <div class="bellSearch d-flex align-content-center">
                Only For Mobile View Only 
                <img src="image/search.png" class="searchButtonMonitor" alt="" onclick="openSecondHeader()"></button>
                <img src="image/bell.png" alt="">
            </div>

            <div class="dropdown">
                <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="image/user-img-large.png" class="profileLogo">
                    <span class="gotoMainbar">Evan Donohue</span> <img src="image/drop-down.png" class="gotoMainbar">
                </button>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another </a></li>
                    <li><a class="dropdown-item" href="#">Something</a></li>
                </ul>
            </div>
        </div>
    </nav>
 -->
    <!-- second Header  -->
    <div class="container-fluid secondHeaderParent" id="secondHeader">
        <div class="container d-flex secondHeader justify-content-center">
            <div class="row d-flex justify-content-between">
                <div class="col d-flex search justify-content-start">
                    <form class="d-flex" role="search">
                        <button class="btn gotoSidebar" type="submit"><img src="image/search.png" alt=""></button>
                        <input class="form-control me-2 search_field" type="search" placeholder="Search Mission..."
                            aria-label="Search">
                    </form>
                    <button class="w3-button w3-xlarge w3-left filterBurger" onclick="openLeftFilterMenu()"><img
                            src="image/filter.png" alt="" srcset=""></button>
                </div>
                <div class="col d-flex justify-content-end filter gotoSidebar">
                    <div class="dropdown d-flex align-items-center leftBorder">
                        <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            <span>Country</span>
                            <img src="image/drop-down.png">
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </div>
                    <div class="dropdown d-flex align-items-center leftBorder">
                        <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            <span>City</span>
                            <img src="image/drop-down.png">
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </div>
                    <div class="dropdown d-flex align-items-center leftBorder">
                        <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            <span>Theme</span>
                            <img src="image/drop-down.png">
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </div>
                    <div class="dropdown d-flex align-items-center leftRightBorder">
                        <button class="btn dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            <span>Skill</span>
                            <img src="image/drop-down.png">
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Applied Filter Showcase -->

    <div class="container AppliedFilter w-100">
    	<p>${user}</p>
    	<p>${missions}</p>
        <div class="row d-flex justify-content-center" id="myList">
            <div class="col d-flex align-items-center justify-content-between">
                <p>Delhi</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Natural</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>India</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Volunterring</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Tree Plantation</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Nutrition</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Environment</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Volunterring</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Tree Plantation</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Nutrition</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Environment</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Environment</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Volunterring</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Tree Plantation</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Nutrition</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
            <div class="col d-flex align-items-center justify-content-between">
                <p>Environment</p><img src="image/cancel.png" onclick="deleteFilter(this)">
            </div>
        </div>
    </div>

    <!-- <button onclick="addFilter()">Clcik</button> -->


    <!-- Explore Mission  -->
    <div class="container gridListView">
        <div class="row d-flex justify-content-around">
            <div class="col d-flex justify-content-md-start justify-content-sm-center align-content-center">
                <p class="noOfMission">Explore <b>${fn:length(missions)} Mission</b></p>
            </div>
            <div class="col d-flex justify-content-end hideOnSmallScreen">
                <div class="row">
                    <div class="col d-flex align-items-center">
                        <div class="dropdown">
                            <button class="btn dropdown-toggle border" type="button" id="dropdownMenuButton1"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                Sort By <i class="bi bi-chevron-down"></i>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col gridListButtons d-flex align-items-center">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item d-flex align-items-center" role="presentation">
                                <button class="nav-link active" id="home-tab" data-bs-toggle="tab"
                                    data-bs-target="#grid" type="button" role="tab" aria-controls="home"
                                    aria-selected="true"><img src="image/grid.png"></button>
                            </li>
                            <li class="nav-item d-flex align-items-center" role="presentation">
                                <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#list"
                                    type="button" role="tab" aria-controls="profile" aria-selected="false"><img
                                        src="image/list.png"></button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>


        </div>
    </div>

    <!-- missions List  -->
    <div class="tab-content" id="myTabContent">

        <!-- Grid View Div  -->
        <div class="tab-pane fade show active" id="grid" role="tabpanel" aria-labelledby="home-tab">
            <div class="container d-flex gridView">
                <div class="row justify-content-center">
                <c:forEach var="mission" items="${missions}">
                	                    <div class="card col-lg-4 col-md-6 col-xs-12">
						<div class="d-flex flex-column appliedCloseButtons">
							<button class="btn btn-success">applied</button>
							<button class="btn btn-danger">closed</button>
						</div>
						<p class="missionCityGridView"><i class="bi bi-geo-alt"></i> ${mission.city.name }</p>
                        <p class="missionLikeGridView d-flex flex-column"><i class="bi bi-heart"></i><i
                                class="bi bi-person-plus"></i></p>
                        <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
                            class="card-img-top missionImgGridView" alt="...">
                        <div class="card-body">
                            <div class="d-flex justify-content-center missionCategoryDiv">
                                <p class="missionCategoryGridView">${mission.mission_theme.title }</p>
                            </div>
                            <h5 class="card-title">${mission.title}</h5>
                            <p class="card-text">${mission.short_description}</p>
                            <div class="row ratingDivGridView">
                                <div class="col">${mission.organization_name}</div>
                                <div class="col">
                                    <div class="row d-flex flex-row ratingStar flex-nowrap">
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="hrLine hrLineOverrided"></div>
                            <div class="row missionDatesGridView">
                            	<c:choose>
                            		<c:when test="${mission.mission_type == 'GOAL'}">
                            			<div class="col d-flex justify-content-center">
                                    		<p>Ongoing Oppurtunity</p>
                                		</div>
                            		</c:when>
                            		<c:otherwise>
                            			<div class="col d-flex justify-content-center">
                            			
                                    		<p>From 
                                    		 <fmt:formatDate pattern = "dd-MM-yyyy" value = "${mission.start_date}" />
                                    		 until 
                                    		 <fmt:formatDate pattern = "dd-MM-yyyy" value = "${mission.end_date}" />
                                    		 </p>
                                		</div>
                            		</c:otherwise>
                            	</c:choose>
                            	
                                
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="row">
                                        <div class="col"><img src="image/Seats-left.png" alt="" srcset=""></div>
                                        <div class="col">
                                            <div class="row">10</div>
                                            <div class="row">Seats Left</div>
                                        </div>
                                    </div>

                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col"><img src="image/deadline.png" alt="" srcset=""></div>
                                        <div class="col">
                                            <div class="row">09/01/2019</div>
                                            <div class="row">Deadline</div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="hrLine"></div>
                            <div class="d-flex justify-content-center">
                                <a href="#" class="applyButtonGridView">Apply <i class="bi bi-arrow-right"></i></a>
                            </div>

                        </div>
                    </div>
                </c:forEach>


                    <div class="card col-lg-4 col-md-6 col-xs-12">
                        <p class="missionCityGridView"><i class="bi bi-geo-alt"></i> London</p>
                        <p class="missionLikeGridView d-flex flex-column"><i class="bi bi-heart"></i><i
                                class="bi bi-person-plus"></i></p>
                        <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
                            class="card-img-top missionImgGridView" alt="...">
                        <div class="card-body">
                            <div class="d-flex justify-content-center missionCategoryDiv">
                                <p class="missionCategoryGridView">Environment</p>
                            </div>
                            <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the
                                card's content.</p>
                            <div class="row ratingDivGridView">
                                <div class="col">Tree Canada</div>
                                <div class="col">
                                    <div class="row d-flex flex-row ratingStar flex-nowrap">
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="hrLine hrLineOverrided"></div>
                            <div class="row missionDatesGridView">
                                <div class="col d-flex justify-content-center">
                                    <p>From 10/01/2019 until 25/02/2019</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="row">
                                        <div class="col"><img src="image/Seats-left.png" alt="" srcset=""></div>
                                        <div class="col">
                                            <div class="row">10</div>
                                            <div class="row">Seats Left</div>
                                        </div>
                                    </div>

                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col"><img src="image/deadline.png" alt="" srcset=""></div>
                                        <div class="col">
                                            <div class="row">09/01/2019</div>
                                            <div class="row">Deadline</div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="hrLine"></div>
                            <div class="d-flex justify-content-center">
                                <a href="#" class="applyButtonGridView">Apply <i class="bi bi-arrow-right"></i></a>
                            </div>

                        </div>
                    </div>

                    <div class="card col-lg-4 col-md-6 col-xs-12">
                        <p class="missionCityGridView"><i class="bi bi-geo-alt"></i> London</p>
                        <p class="missionLikeGridView d-flex flex-column"><i class="bi bi-heart"></i><i
                                class="bi bi-person-plus"></i></p>
                        <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
                            class="card-img-top missionImgGridView" alt="...">
                        <div class="card-body">
                            <div class="d-flex justify-content-center missionCategoryDiv">
                                <p class="missionCategoryGridView">Environment</p>
                            </div>
                            <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the
                                card's content.</p>
                            <div class="row ratingDivGridView">
                                <div class="col">Tree Canada</div>
                                <div class="col">
                                    <div class="row d-flex flex-row ratingStar flex-nowrap">
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="hrLine hrLineOverrided"></div>
                            <div class="row missionDatesGridView">
                                <div class="col d-flex justify-content-center">
                                    <p>From 10/01/2019 until 25/02/2019</p>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="row">
                                        <div class="col"><img src="image/Seats-left.png" alt="" srcset=""></div>
                                        <div class="col">
                                            <div class="row">10</div>
                                            <div class="row">Seats Left</div>
                                        </div>
                                    </div>

                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col"><img src="image/deadline.png" alt="" srcset=""></div>
                                        <div class="col">
                                            <div class="row">09/01/2019</div>
                                            <div class="row">Deadline</div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="hrLine"></div>
                            <div class="d-flex justify-content-center">
                                <a href="#" class="applyButtonGridView">Apply <i class="bi bi-arrow-right"></i></a>
                            </div>

                        </div>
                    </div>
                    <div class="card col-lg-4 col-md-6 col-xs-12">
                        <p class="missionCityGridView"><i class="bi bi-geo-alt"></i> London</p>
                        <p class="missionLikeGridView d-flex flex-column"><i class="bi bi-heart"></i><i
                                class="bi bi-person-plus"></i></p>
                        <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
                            class="card-img-top missionImgGridView" alt="...">
                        <div class="card-body">
                            <div class="d-flex justify-content-center missionCategoryDiv">
                                <p class="missionCategoryGridView">Environment</p>
                            </div>
                            <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the
                                card's content.</p>
                            <div class="row ratingDivGridView">
                                <div class="col">Tree Canada</div>
                                <div class="col">
                                    <div class="row d-flex flex-row ratingStar flex-nowrap">
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="hrLine hrLineOverrided"></div>
                            <div class="row missionDatesGridView">
                                <div class="col d-flex justify-content-center">
                                    <p>From 10/01/2019 until 25/02/2019</p>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="row">
                                        <div class="col"><img src="image/Seats-left.png" alt="" srcset=""></div>
                                        <div class="col">
                                            <div class="row">10</div>
                                            <div class="row">Seats Left</div>
                                        </div>
                                    </div>

                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col"><img src="image/deadline.png" alt="" srcset=""></div>
                                        <div class="col">
                                            <div class="row">09/01/2019</div>
                                            <div class="row">Deadline</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="hrLine"></div>
                            <div class="d-flex justify-content-center">
                                <a href="#" class="applyButtonGridView">Apply <i class="bi bi-arrow-right"></i></a>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        
        <div class="tab-pane fade" id="list" role="tabpanel" aria-labelledby="profile-tab">
            <!-- List View Div  -->
            <div class="container">
                <div class="row ListViewCard">
                    <div class="card">
                        <div class="row g-0">
                            <div class="col-md-3 missionImg">
                                <p class="missionCityListView"><i class="bi bi-geo-alt"></i> London</p>
                                <p class="missionAppliedListView"> Applied</p>
                                <div class="missionLikeListView d-flex flex-column"><i class="bi bi-heart"></i><i
                                    class="bi bi-person-plus"></i>
                                </div>
                                <div class="d-flex justify-content-center missionCategoryListView"><p>Environment</p></div>
                                <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png" class="img-fluid rounded-start" alt="...">
                            </div>
                            <div class="col-md-9">
                                <div class="card-body">
                                    <div class="row w-100 d-flex ">
                                        <div class="col">
                                            <div class="row d-flex justify-content-start firstInfoContainerListView">
                                                <div class="col d-flex"><i class="bi bi-geo-alt"> </i><p> Atlanta</p></div>
                                                <div class="col d-flex"><i class="bi bi-globe"> </i><p> Environment</p></div>
                                                <div class="col d-flex"><i class="bi bi-people"> </i> <p>Smith Caring Foundation</p></div>
                                            </div>
                                        </div>
                                        <div class="col d-flex justify-content-end">
                                            <div class="row ratingDivGridView">
                                                <div class="col">
                                                    <div class="row d-flex flex-row ratingStar flex-nowrap">
                                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural
                                        lead-in to additional content. This content is a little bit longer.</p>
                                    <div class="row">
                                        <div class="col d-flex">
                                            <div class="col d-flex">
                                                <div class="col d-flex align-items-center"><img src="image/Seats-left.png" alt="" srcset=""></div>
                                                <div class="col">
                                                    <div class="row">2</div>
                                                    <div class="row">Seats</div>
                                                </div>
                                            </div>
                                            <div class="col d-flex">
                                                <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
                                                <div class="col">
                                                    <div class="row">2</div>
                                                    <div class="row">Seats</div>
                                                </div>
                                            </div>
                                            <div class="col d-flex">
                                                <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
                                                <div class="col">
                                                    <div class="row">2</div>
                                                    <div class="row">Seats</div>
                                                </div>
                                            </div>
                                            <div class="col d-flex">
                                                <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
                                                <div class="col">
                                                    <div class="row">2</div>
                                                    <div class="row">Seats</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col d-flex justify-content-end">
                                            <a href="#" class="applyButtonGridView">View Details <i class="bi bi-arrow-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="row ListViewCard">
                    <div class="card">
                        <div class="row g-0">
                            <div class="col-md-3 missionImg">
                                <p class="missionCityListView"><i class="bi bi-geo-alt"></i> London</p>
                                <p class="missionAppliedListView"> Applied</p>
                                <div class="missionLikeListView d-flex flex-column"><i class="bi bi-heart"></i><i
                                    class="bi bi-person-plus"></i>
                                </div>
                                <div class="d-flex justify-content-center missionCategoryListView"><p>Environment</p></div>
                                <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png" class="img-fluid rounded-start" alt="...">
                            </div>
                            <div class="col-md-9">
                                <div class="card-body">
                                    <div class="row w-100 d-flex ">
                                        <div class="col">
                                            <div class="row d-flex justify-content-start firstInfoContainerListView">
                                                <div class="col d-flex"><i class="bi bi-geo-alt"> </i><p> Atlanta</p></div>
                                                <div class="col d-flex"><i class="bi bi-globe"> </i><p> Environment</p></div>
                                                <div class="col d-flex"><i class="bi bi-people"> </i> <p>Smith Caring Foundation</p></div>
                                            </div>
                                        </div>
                                        <div class="col d-flex justify-content-end">
                                            <div class="row ratingDivGridView">
                                                <div class="col">
                                                    <div class="row d-flex flex-row ratingStar flex-nowrap">
                                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                                        <div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                                        <div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a natural
                                        lead-in to additional content. This content is a little bit longer.</p>
                                    <div class="row">
                                        <div class="col d-flex">
                                            <div class="col d-flex">
                                                <div class="col d-flex align-items-center"><img src="image/Seats-left.png" alt="" srcset=""></div>
                                                <div class="col">
                                                    <div class="row">2</div>
                                                    <div class="row">Seats</div>
                                                </div>
                                            </div>
                                            <div class="col d-flex">
                                                <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
                                                <div class="col">
                                                    <div class="row">2</div>
                                                    <div class="row">Seats</div>
                                                </div>
                                            </div>
                                            <div class="col d-flex">
                                                <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
                                                <div class="col">
                                                    <div class="row">2</div>
                                                    <div class="row">Seats</div>
                                                </div>
                                            </div>
                                            <div class="col d-flex">
                                                <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
                                                <div class="col">
                                                    <div class="row">2</div>
                                                    <div class="row">Seats</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col d-flex justify-content-end">
                                            <a href="#" class="applyButtonGridView">View Details <i class="bi bi-arrow-right"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
    <div class="myPaginationTab d-flex justify-content-center text-danger">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true"><i class="bi bi-chevron-double-left"></i></span>
                    </a>
                  </li>
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true"><i class="bi bi-chevron-left"></i></span>
                </a>
              </li>
              <li class="page-item"><a class="page-link active" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#">4</a></li>
              <li class="page-item"><a class="page-link" href="#">5</a></li>
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="bi bi-chevron-right"></i></span>
                </a>
              </li>
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true"><i class="bi bi-chevron-double-right"></i></span>
                  </a>
              </li>
            </ul>
          </nav>
    </div>




    <!-- <button class="w3-button w3-teal w3-xlarge w3-left" onclick="openLeftMainMenu()">&#9776;</button> -->
	
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
         <script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
         <script>
         $(document).ready(function(){
             $('.search_field').keyup(function(){
            	 var data1 = $('.search_field').val();
            	 console.log(data1);
                 $.ajax({
                     url: "home",
                     type: "GET",
                     cache: false,
                     data: {
                    	 "keyword":data1
                     },
                     success: function(){
                       console.log("Thanks for updating");
                     }
                 });
             });
           });
         </script>
 <script src="js/sidebarJs.js"></script>
<!--     <script src="js/add_navbar.js"></script> -->

</html>