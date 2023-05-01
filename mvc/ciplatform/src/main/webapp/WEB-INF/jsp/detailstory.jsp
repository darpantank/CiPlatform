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
<c:if test="${story.status=='DRAFT'}">
	<c:if test="${user.userId!=story.user.userId }">	
		<c:redirect url="story"></c:redirect>
	</c:if>
</c:if>
<c:if test="${story.status=='PENDING' && empty admin}">
	<c:redirect url="story"></c:redirect>
</c:if>

<!DOCTYPE html>
<html lang="en">

<head>
	<script>
		let story_id="<c:out  value='${story.storyId}' />";
	</script>
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
    <jsp:include page="spinner.jsp" />
<!-- 	Recommend to Coworker Modal  -->

	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Receommend to Co-Worker</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Enter Email
							address Of CoWorker</label> <input type="email" class="form-control"
							id="recommendworkerEmail" aria-describedby="emailHelp">
					</div>
					<div class="modalMessageBody"></div>
				</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary recommandToCoworker">Recommand</button>
      </div>
    </div>
  </div>
</div>


    <div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container mt-4">
    <input type="hidden" class="storyId" value="${story.storyId }">
        <div class="row">
            <!-- image caresoul Div  -->
            <div class="col-md-12 col-lg-6 imgCarouselDiv">
                <div id="firstDiv">
                <c:choose>
                 	<c:when test="${story.storyMedia.size() gt 0}" >	 
						<c:if test="${story.storyMedia[0].type=='VIDEO'}">
							<iframe src="<c:out value="${story.storyMedia[0].path}"/>" class="mainPhotoVideo"  style="position: relative; height: 100%; width: 100%;"></iframe>
                        	<img class="mainPhoto d-none">
						</c:if>
						<c:if test="${story.storyMedia[0].type=='IMAGE'}">
							<iframe class="mainPhotoVideo d-none"  style="position: relative; height: 100%; width: 100%;"></iframe>
                        	<img src="<c:out value="${story.storyMedia[0].path}"/>" class="mainPhoto">
						</c:if>
                        
               		</c:when>
               		<c:otherwise>
						<img src="image/noimagefound.png" class="mainPhoto">
               		</c:otherwise>
                
                </c:choose>        
               		 </div>
                <div id="SecondDiv">
                    <div class="swiper mySwiper">
                        <div class="swiper-wrapper">
                        <c:forEach var="a" items="${story.storyMedia}"> 
                        <c:if test="${a.type=='IMAGE'}">                        
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="${a.path }" alt=""></div>
                        </c:if>  
                        <c:if test="${a.type=='VIDEO'}">                        
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="${a.path}" alt="" hidden><img src="image/youtube.png" class="videoClass border"></div>
                        </c:if>                     
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
                        <c:choose>                        
                        	<c:when test="${empty story.user.avatar }"><img src="image/user1.png" alt="" srcset="" class="StoryOwnerPic"></c:when>
                        	<c:otherwise><img src="${story.user.avatar }" alt="" srcset="" class="StoryOwnerPic"></c:otherwise>
                        </c:choose>
                            
                            <p class="text-center">${story.user.firstName} ${story.user.lastName	}</p>
                        </div>
                        <div class="ViewsOfStory">
                            <p class="noOfView"><img src="image/eye.png" alt="" srcset=""> ${story.views} Views</p>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <p class="storyDetailsText">
                            ${story.user.whyIVolunteer }
                        </p>
                    </div>
                    <div class="d-flex justify-content-around StoryButtons mt-3">
                    <c:if test="${story.status!='DRAFT'}">
                        <a class="btn recommendButton" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            <img src="image/add1.png" alt="" srcset=""> Recommend to a Co-Worker
                        </a>
                        </c:if>
                        <a class="btn openMissionButton" href="getMyMission?mission_id=${story.mission.missionId}">
                            Open Mission <img src="image/right-arrow.png" alt="" srcset="">
                        </a>
                    </div>
                </div>
            
            <div class="row mt-4">
                <div class="headingOfMissionStory">
                    <p class="headingOfMissionStoryText ">
                        ${story.title }
                    </p>
                    <hr class="smallBackGroundline">
                </div>
                <div class="contentOfMissionStory mt-3">
                    ${story.description}
                </div>

            </div>
        </div>
		<div class="container-fluid g-0 footer mt-4">
        <jsp:include page="footer.jsp"></jsp:include>
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
        <script>
        $(".recommandToCoworker").click(function(){
    		$(".modalMessageBody").empty();
    		let messageBody="";
    		var email_id=$("#recommendworkerEmail").val();
    		var storyId=$(".storyId").val();
    		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email_id)){
    			$.ajax({
    	            url: "recommandtocoworkerstory",
    	            data:{storyId:story_id,
    	            	  emailId:email_id},
    	            type:"POST",
    	            success: function(response){
    	            	if(response=="emailnotfound"){
    	            		messageBody=`<div class="alert alert-danger" role="alert">
    	      				  Email Address is Not Found In Our Record
    	      				</div>`;
    	      			$(".modalMessageBody").html(messageBody);
    	            	}
    	            	else if(response=="bothusersame"){
    	            		messageBody=`<div class="alert alert-warning" role="alert">
    		      				  You can Not Recommand to Your Self
    		      				</div>`;
    		      			$(".modalMessageBody").html(messageBody);
    	            	}
    	            	else if(response=="sessionnotfound"){
    	            		messageBody=`<div class="alert alert-warning" role="alert">
    		      				  Please Re login to send Recommondation to friends...
    		      				</div>`;
    		      			$(".modalMessageBody").html(messageBody);
    	            	}
    	            	else if(response=="success"){
    	            		messageBody=`<div class="alert alert-success" role="alert">
    		      				  Thanks For Sending Recommandation to Your Friend
    		      				</div>`;
    		      			$(".modalMessageBody").html(messageBody);
    		      			
    	            	}
    	            }
    	        });
    		}
    		else{
    			messageBody=`<div class="alert alert-danger" role="alert">
    				  Email Address is Not Proper
    				</div>`;
    			$(".modalMessageBody").html(messageBody);
    		}
    	});
        $(".videoClass").click(function(){
        	$(".mainPhotoVideo").attr("src",$(this).siblings(".imgCarousel").prop("src"));
        	$(".mainPhotoVideo").removeClass("d-none");
        	$(".mainPhoto").addClass("d-none");
        	});
        </script>
	<script src="js/spinner.js"></script>
</body>

</html>