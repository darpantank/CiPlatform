<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${empty user.email}">
	<%
	response.sendRedirect("login");
	%>
</c:if>
<c:if test="${empty story}">
	<%
	response.sendRedirect("login");
	%>
</c:if>
<%-- <c:if test="${story.status=='DRAFT'}"> --%>
<%-- 	<c:if test="${user.user_id!=story.user.user_id }">	 --%>
<%-- 		<c:redirect url="story"></c:redirect> --%>
<%-- 	</c:if> --%>
<%-- </c:if> --%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Story Details</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/storyDetails.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <link rel="stylesheet" href="css/imageCaresoul.css">
</head>

<body>
    <!-- Recommend to Co Worker Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Recommend to a Co-Worker</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="storytitle">Select Your Co-Worker</label>
                        <select class="form-control" name="coworkerSelect" placeholder="Select Your Mission">
                            <option value="" disabled selected hidden>Select Your CoWorker</option>
                            <option value="Education">john Doe</option>
                            <option value="Animal Wellfare">Evan Donhule</option>
                            <option value="Volunteering">James Mary</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Recommend </button>
                </div>
            </div>
        </div>
    </div>


    <div class="container-fluid g-0" id="headerIncludedTag"></div>
    <div class="container mt-4">
        <div class="row">
            <!-- image caresoul Div  -->
            <div class="col-md-12 col-lg-6 imgCarouselDiv">
                <div id="firstDiv">
                <c:choose>
                 	<c:when test="${story.storyMedia.size() gt 0}" >               		 
                    	<img src="<c:out value="${story.storyMedia[0].path}"/>" alt=""
                        class="mainPhoto">
               		</c:when>
               		<c:otherwise>
               			<img src="<c:out value="image/noimagefound.png"/>" alt=""
                        class="mainPhoto">
               		</c:otherwise>
                
                </c:choose>
               		                
               		 </div>
                <div id="SecondDiv">
                    <div class="swiper mySwiper">
                        <div class="swiper-wrapper">
                        <c:forEach var="a" items="${story.storyMedia}">                        
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="${a.path }" alt=""></div>
                        </c:forEach>
                            
                        </div>
                        <div class="swiper-button-next"></div>
                        <div class="swiper-button-prev"></div>
                    </div>
                </div>
                </div>
                <!-- mission Details div  -->
                <div class="col-md-12 col-lg-6">
                    <div class="d-flex justify-content-between align-items-end mt-3">
                        <div class="nameAndPhoto">
                            <img src="image/${story.user.avatar }" alt="" srcset="" class="StoryOwnerPic">
                            <p class="text-center">${story.user.first_name} ${story.user.last_name	}</p>
                        </div>
                        <div class="ViewsOfStory">
                            <p class="noOfView"><img src="image/eye.png" alt="" srcset=""> 12,000 Views</p>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <p class="storyDetailsText">
                            ${story.title }
                        </p>
                    </div>
                    <div class="d-flex justify-content-around StoryButtons mt-3">
                        <a class="btn recommendButton" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            <img src="image/add1.png" alt="" srcset=""> Recommend to a Co-Worker
                        </a>
                        <a class="btn openMissionButton" href="getMyMission?mission_id=${story.mission.mission_id}">
                            Open Mission <img src="image/right-arrow.png" alt="" srcset="">
                        </a>
                    </div>
                </div>
            
            <div class="row mt-4">
                <div class="headingOfMissionStory">
                    <p class="headingOfMissionStoryText ">
                        ${story.mission.title }
                    </p>
                    <hr class="smallBackGroundline">
                </div>
                <div class="contentOfMissionStory mt-3">
                    ${story.description}
                </div>

            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
            integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
            crossorigin="anonymous"></script>
        <script src="js/add_navbar.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
        <script src="js/imageCaresoul.js"></script>
</body>

</html>