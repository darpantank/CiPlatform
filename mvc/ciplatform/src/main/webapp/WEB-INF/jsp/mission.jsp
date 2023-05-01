<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${empty user.email}">
	<%
	response.sendRedirect("login");
	%>
</c:if>
<c:if test="${empty Mission.title}">
	<%
	response.sendRedirect("login");
	%>
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${Mission.title}</title>
    <link rel="stylesheet" href="<c:url value="/css/missionpage.css" />">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <link rel="stylesheet" href="<c:url value="/css/imageCaresoul.css"/>">
    <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <script>
    </script>
</head>

<body>    
	<jsp:include page="spinner.jsp" />
<!-- 	Recommend to Coworker Modal  -->
	<div class="modal fade" id="recommendModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
	<!--NAvbar-->
	<div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container mainContainer gap-2">
    	<input type="text" class="missionId" value="${Mission.missionId}" hidden>
        <div class="row">
            <!-- image caresoul Div  -->
            <div class="col-md-12 col-lg-5">
                <div id="firstDiv">
                <c:forEach var="a" items="${media}" varStatus="loop">
                	<c:if test="${a.mediaDefault=='DEFAULT'}">
                		<img src="${a.mediaPath}" alt=""
                        class="mainPhoto">
                	</c:if>
                </c:forEach>
                    
                </div>
                <div id="SecondDiv">
                    <div class="swiper mySwiper">
                        <div class="swiper-wrapper">
							<c:if test="${empty media}">
    							<h2>No Image Found For Mission</h2>
							</c:if>
							<c:forEach var="a" items="${media}">
                        	<div class="swiper-slide"><img class="imgCarousel"
                                    src="${a.mediaPath}" alt=""></div>
                        </c:forEach>
                            
<!--                             <div class="swiper-slide"><img class="imgCarousel" -->
<!--                                     src="image/Animal-welfare-&-save-birds-campaign-1.png" alt=""></div> -->
<!--                             <div class="swiper-slide"><img class="imgCarousel" -->
<!--                                     src="image/CSR-initiative-stands-for-Coffee--and-Farmer-Equity-3.png" alt=""></div> -->
<!--                             <div class="swiper-slide"><img class="imgCarousel" -->
<!--                                     src="image/Education-Supplies-for-Every--Pair-of-Shoes-Sold-1.png" alt=""></div> -->
<!--                             <div class="swiper-slide"><img class="imgCarousel" -->
<!--                                     src="image/Plantation-and-Afforestation-programme-1.png" alt=""></div> -->
<!--                             <div class="swiper-slide"><img class="imgCarousel" -->
<!--                                     src="image/Nourish-the-Children-in--African-country-1.png" alt=""></div> -->
                        </div>
                        <div class="swiper-button-next"></div>
                        <div class="swiper-button-prev"></div>
                    </div>
                </div>
            </div>

            <!-- mission Details div  -->
            <div class="col-md-12 col-lg-7">
                <div class="row">
                    <p class="titleOfMission">${Mission.title}</p>
                </div>
                <div class="row mb-2">
                    <p class="detailsOfMission">${Mission.shortDescription}</p>
                </div>
                <div class="missionsTargets">
                    <div class="d-flex justify-content-center">
                        <p class="missionGoal text-center">
                        	<c:choose>
                        		<c:when test="${Mission.missionType=='GOAL' }">
                        			${Mission.goalMission.goalObjectiveText}
                        		</c:when>
                        		<c:otherwise>
                        			<fmt:formatDate type = "date" var="startDate" value = "${Mission.startDate}" />
                        			<fmt:formatDate type = "date" var="endDate" value = "${Mission.endDate}" />
                        			From ${startDate} Untill ${endDate} 
                        		</c:otherwise>
                        	</c:choose>
                        </p>
                    </div>

                    <div class="row mt-3 justify-content-center">
                    
                   	<c:if test="${Mission.missionType=='TIME'}">
                   		<div class="col-6">
                            <div class="row d-flex align-items-center">
                                <div class="col-6 d-flex justify-content-end smallIcon"><img src="image/deadline.png"
                                        alt="" srcset=""></div>
                                <div class="col-6 d-flex flex-column justify-content-start">
                                <fmt:formatDate type = "date" var="deadlineDate" value = "${Mission.deadline}" />
                                    <div class="col noOfSeatLeft">${deadlineDate}</div>
                                    <div class="col">Deadline</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="row d-flex align-items-center">
                                <div class="col-6 d-flex justify-content-end smallIcon"><img src="image/Seats-left.png"
                                        alt="" srcset=""></div>
                                <div class="col-6 d-flex flex-column justify-content-start">
                                
                                    <div class="col noOfSeatLeft">${Mission.seatLeft}</div>
                                    <div class="col">Seat Left</div>
                                </div>
                            </div>
                        </div>
                   	</c:if>
                    <c:if test="${Mission.missionType=='GOAL'}">
                   		
                        <div class="col-6 mt-2">
                            <div class="row d-flex align-items-center h-100">
                                <div class="col-6 d-flex justify-content-center smallIcon"><img src="image/achieved.png"
                                        alt="" srcset=""></div>
                                <div class="col-6 d-flex flex-column justify-content-start">
                                    <div class="col">
                                        <!-- progress Bar -->
                                        <div class="progress">
                                        <fmt:formatNumber value="${goalAchieved/Mission.goalMission.goalValue}" type="percent" var="goalCompleted"/>
                                            <div class="progress-bar" role="progressbar" style="width: ${goalCompleted}"
                                                aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <div class="col">${goalAchieved} Achieved</div>
                                </div>
                            </div>
                        </div>
                   	</c:if>
                        
                    </div>
                </div>
                <div class="ratingsAndButtons">
                    <div class="row d-flex justify-content-center">
                        <div class="col-sm-12 col-md-6">
                        <c:if test="${isFavourited}">                        
                        <button type="button" class="btn W-90">
                        <i class="bi bi-heart-fill LikeButtonMain"></i> Add to Favourite</button>
                        </c:if>
                        <c:if test="${not isFavourited}">                        
                        <button type="button" class="btn W-90">
                        <i class="bi bi-heart LikeButtonMain"></i> Add to Favourite</button>
                        </c:if>
                        
                        </div>
                        <div class="col-sm-12 col-md-6" data-bs-toggle="modal" data-bs-target="#recommendModal"><button type="button" class="btn W-90"><i
                                    class="bi bi-person-plus"></i> Recommend to a Co-Worker</button></div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="row d-flex flex-row flex-nowrap ratingStars">
                        
                       	 <c:forEach var="i" begin="1" end="${ratingOfUser}">                                	
                                 <div class="col ratingStar" value="${i }"><img src="image/selected-star.png" alt="" srcset=""></div>
                          </c:forEach>
                           <c:forEach var="i" begin="${ratingOfUser+1}" end="5">                                		
                                  <div class="col ratingStar" value="${i }"><img src="image/star.png" alt="" srcset=""></div>
                           </c:forEach>  
                            
                        </div>
                    </div>

                </div>
                <div class="missionInfoDiv mt-4 container-fluid">
                    <div class="row d-flex g-0 gap-1">
                        <div class="col d-flex flex-column MissioninfoCard">
                            <div class="col d-flex justify-content-center"><i class="bi bi-geo-alt"></i></div>
                            <div class="col d-flex justify-content-center textSmallLight">City</div>
                            <div class="col d-flex justify-content-center textBigDark">${Mission.city.name}</div>
                        </div>
                        <div class="col d-flex flex-column MissioninfoCard">
                            <div class="col d-flex justify-content-center"><i class="bi bi-globe"></i></div>
                            <div class="col d-flex justify-content-center textSmallLight">Theme</div>
                            <div class="col d-flex justify-content-center textBigDark">${Mission.missionTheme.title}</div>
                        </div>
                        <div class="col d-flex flex-column MissioninfoCard">
                            <div class="col d-flex justify-content-center"><i class="bi bi-calendar"></i></div>
                            <div class="col d-flex justify-content-center textSmallLight">Date</div>
                            <div class="col d-flex justify-content-center textBigDark">Ongoing Oppurtunnity</div>
                        </div>
                        <div class="col d-flex flex-column MissioninfoCard">
                            <div class="col d-flex justify-content-center"><i class="bi bi-people"></i></div>
                            <div class="col d-flex justify-content-center textSmallLight">Organization</div>
                            <div class="col d-flex justify-content-center textBigDark">${Mission.organizationName}</div>
                        </div>
                    </div>
                </div>
                <div class="applyButtonDiv d-flex justify-content-center mt-3">
                <c:choose>                
	                <c:when test="${isAlreadyApplied}">
	                    <button class="btn" disabled>Applied <i class="bi bi-arrow-right"></i></button>
	                </c:when>
	                <c:otherwise>
	                	<button class="btn applyNow">Apply Now <i class="bi bi-arrow-right"></i></button>
	                </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>

    </div>

    <div class="container mt-4">
        <div class="row">
            <div class="col-md-12 col-lg-8">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home"
                            type="button" role="tab" aria-controls="home" aria-selected="true">Missions</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile"
                            type="button" role="tab" aria-controls="profile" aria-selected="false">Organization</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact"
                            type="button" role="tab" aria-controls="contact" aria-selected="false">Comments</button>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="container mt-4">
                            ${Mission.description}
                            
                            <h2 class="titleOfMissionTab">Documents</h2>
                            <div class="d-flex flex-column justify-content-start gap-2 flex-md-row mt-2">
                            <c:forEach var="doc" items="${documents}">
                            	
                                <a class="btn documentDownloadBtn" href='<c:url value="${doc.documentPath}"></c:url>'>
										<c:choose>
											<c:when test="${doc.documentType== 'pdf'}">
												<img src="image/pdf.png">
											</c:when>
											<c:when test="${doc.documentType== 'xlsx'}">
												<img src="image/xlsx.png">
											</c:when>
											<c:otherwise>
												<img src="image/doc.png">
											</c:otherwise>
										</c:choose>
                                    ${doc.documentName}</a>
                            </c:forEach>
                            </div>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <div class="container mt-3">
                            <p>${Mission.organizationDetail }</p>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                        <div class="mb-3 mt-3">
                            <textarea class="form-control" id="userCommentText" rows="3"
                                placeholder="Enter Your Comments..."></textarea>
                        </div>
                        <div class="applyButtonDiv mt-3">
                            <button class="btn postCommentBtn">Post Comment</button>
                        </div>
                            <div class="container mt-2 userComments">
<!--                                 Comments are fetched Here                               -->
                            </div>
                        
                    </div>
                </div>
            </div>
            <div class="col-md-12 col-lg-4 d-flex flex-column mt-2">
                <div class="col">
                    <div class="informstionContainer border mt-4">
                        <div class="d-flex informstionContainerText">
                            <h3>Information</h3>
                        </div>
                        <div class="hrLine mb-3"></div>
                        <div class="row">
                            <div class="col-auto">Skills</div>
                            <div class="col">
                            <c:forEach var="a" items="${Mission.missionSkills}" varStatus="state">
                            	<c:if test="${not state.first}">
									,       								
    							</c:if>
                            	${a.skills.skillName}
								</c:forEach>
                            </div>
                        </div>
                        <div class="hrLine mt-2 mb-2"></div>
                        <div class="row">
                            <div class="col-auto">Days</div>
                            <div class="col">${ Mission.availability}</div>
                        </div>
                        <div class="hrLine mt-2 mb-2"></div>
                        <div class="row">
                            <div class="col-auto">Rating</div>
                            <div class="col">
                                <div class="row d-flex flex-nowrap g-0 starsOfRating">
                                
                                	<c:forEach begin="1" end="${rating}">                                	
                                    	<div class="col-auto"><img src="image/selected-star.png" alt="" srcset=""></div>
                                	</c:forEach>
                                	<c:forEach begin="${rating+1}" end="5">                                		
                                    	<div class="col-auto"><img src="image/star.png" alt="" srcset=""></div>
                                	</c:forEach>       
                                	<div class="col">(by ${ratingByPeople } Volunteers)</div>             
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="informstionContainer border mt-4 pb-0">
                        <div class="d-flex informstionContainerText">
                            <h3>Recent Volunteers</h3>
                        </div>
                        <div class="hrLine mb-3"></div>
                        <div class="gridSys">
                            
<!--                             Recent Volunteers Fetched Here -->
                            
                        </div>
                        
                        <!-- Pagination Of Volunteers  -->

						<div class="row mt-2 justify-content-center border-top">
							<div class="col-auto border-end d-flex align-items-center leftButtonRecentVolunteers">&lt;</div>
							<div class="col text-center my-2 recentVolunteerText"></div>
							<div class="col-auto border-start d-flex align-items-center rightButtonRecentVolunteers">&gt;</div>
						</div>
					</div>
                </div>
            </div>
        </div>
    </div>
    
    
<!--     Related Missions -->
	
	<div class="container mt-4">
		<p class="h2 text-center mt-2">Related Mission</p>
		<div class="container d-flex gridView">
				<div class="row GridViewDisplay w-100">
					<!-- Data Fetched here of mission  -->

				</div>
			</div>
	</div>
	<div class="container-fluid g-0 footer mt-4">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script src="js/imageCaresoul.js"></script>
    <script>
    let missionId=$(".missionId").val();
    let currentPageRecentVolunteer=1;
    let totalPageRecentVolunteer=1;
    let getTotalVolunteerOfMission=0;
    let missions="";
    let volunteers="";
    $( document ).ready(function() {
    	loadRelatedMission();
    	loadCommentsOfMission();
    	loadNumberOfVolunteers();
    });
    $(".applyNow").click(function(){
    	let missionId=$(".missionId").val();
    	$.ajax({
            url: "applyForMission",
            data: {missionId:missionId},
            dataType : "json",
            type:"POST",
            success: function(response){
            	if(response){            		
            	swal("Thanks","Thank You For Applying in Mission...","success");
            	$(".applyNow").html("applied <i class='bi bi-arrow-right'>").attr('disabled','disabled');
            	}
            	else{
            		swal("Notes","Already Applied or Admin Closed Entry!","warning");
            	}
            }
        });  
    });
    $(".postCommentBtn").click(function(){
    	$(".commentNotFound").remove();
    	var commentText=$("#userCommentText").val();
    	let missionId=$(".missionId").val();
    	var mydata={'mission_id':missionId,
        		'comment':commentText};
    	if(commentText!=""){
    		$.ajax({
                url: "postcomment",
                data: mydata,
                dataType : "json",
                type:"POST",
                success: function(response){
                	swal("Thanks","Comment Posted Successfully","success");
                	$("#userCommentText").val('');
                	loadCommentsOfMission();
                }
            });  
    	}
    	else{
    		$("#userCommentText").parent().append("<p class='commentNotFound text-danger'>Your Comment Box is Empty</p>");
    	}
    }
    );
    
    $(".recommandToCoworker").click(function(){
		$(".modalMessageBody").empty();
		let messageBody="";
		var email_id=$("#recommendworkerEmail").val();
		let missionId=$(".missionId").val();
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email_id)){
			$.ajax({
	            url: "recommandtocoworker",
	            data:{missionId:missionId,
	            	  email_id:email_id},
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
	$(".ratingStar").click(function(){
		var rating=$(this).attr("value");
		var missionId=$(".missionId").attr("value");
    	$.ajax({
        url: "ratingToMission",
        type: "POST",
        data:	{"missionId": missionId,
        		"rating":rating	
        },
        success: function(response){
       		$(".ratingStars").empty();
       		data=``;
       		for(var a=1;a<=5;a++){
       			if(rating>0){       				
       			data+=`<div class="col ratingStar" value=`+a+`><img src="image/selected-star.png" alt="" srcset=""></div>`;
       			rating--;
       			}
       			else{
       				data+=`<div class="col ratingStar" value=`+a+`><img src="image/star.png" alt="" srcset=""></div>`;
       			}
       		}
       		$(".ratingStars").append(data);
        }
		
	});
	});
		$(".LikeButtonMain").click(function(){
			var missionId=$(".missionId").val();
			let res="";
		 	$.ajax({
            url: "addToMyFavourite",
            dataType: 'json',
            data:{missionId:missionId},
            type:"POST",
            success: function(response){
            }
        });
		 	if($(this).hasClass("bi-heart")){
				$(this).removeClass("bi-heart");
				$(this).addClass("bi-heart-fill");
			}
			else{
				$(this).addClass("bi-heart");
				$(this).removeClass("bi-heart-fill");
			}
		});

    	function loadRelatedMission(){
    		$.ajax({
                url: "getRelatedMission",
                data:{missionId:missionId},
                type:"GET",
                success: function(response){
                	missions=response;
                	printCardOnGrid(missions);
                }
            });
    	}
		function loadNumberOfVolunteers(){
	    	$.ajax({
	            url: "getTotalVolunteerOfMission",
	            data:{missionId:missionId},
	            type:"GET",
	            dataType:"json",
	            success: function(response){
	            	getTotalVolunteerOfMission=response;
	            	calculateTotalPages();
	            	loadVolunteers();
	            }
	        });
		}
		function calculateTotalPages(){
			totalPageRecentVolunteer=getTotalVolunteerOfMission/9;
			totalPageRecentVolunteer=Math.ceil(totalPageRecentVolunteer);
		}
		$(".leftButtonRecentVolunteers").click(function(){
			if(currentPageRecentVolunteer>1){				
			currentPageRecentVolunteer--;
			loadVolunteers();
			}
			else{
				swal("sorry !","You are Already On First Slide You can't go back more...","info");
			}
		});
		$(".rightButtonRecentVolunteers").click(function(){
			if(currentPageRecentVolunteer<totalPageRecentVolunteer){				
			currentPageRecentVolunteer++;
			loadVolunteers();
			}
			else{
				swal("sorry !","You are Already On Last Slide You can't forward more...","info");
			}
		});
		function loadVolunteers(){
			$.ajax({
	            url: "getVolunteers",
	            data:{missionId:missionId,
	            		pageNumber:currentPageRecentVolunteer},
	            type:"GET",
	            dataType:"json",
	            success: function(response){
	            	volunteers=response;
	            	printVolunteers();
	            	updatePaginationText();
	            }
	        });
		}
		function printVolunteers(){
			$(".gridSys").empty();
			for(var i in volunteers){
				var name=volunteers[i].name;
				var avatar=volunteers[i].avatar;
				if(name==null)name="";
				if(avatar==null||avatar=="")avatar="image/user1.png";
				
				let card=`<div class="d-flex flex-column align-items-center">
                    <img src="`+avatar+`" class="rounded-circle recentVolunteerImg" alt=""
                    srcset="">
                <p>`+name+`</p>
            </div>`;
				$(".gridSys").append(card);
			}
		}
		function updatePaginationText(){
			$(".recentVolunteerText").empty();
			var firstEntry=(9*(currentPageRecentVolunteer-1))+1;
			var lastEntry=firstEntry+9>getTotalVolunteerOfMission?getTotalVolunteerOfMission:(firstEntry+9)-1;
			var text=firstEntry+" - "+lastEntry+" Of "+getTotalVolunteerOfMission+" Recent Volunteers";
			if(getTotalVolunteerOfMission==0){
				text="No Volunteers Found In This Mission";
			}
			$(".recentVolunteerText").append(text);
		}
		function loadCommentsOfMission(){
    		$.ajax({
                url: "getCommentsOfMission",
                data:{missionId:missionId},
                type:"GET",
                success: function(response){
                	printComments(response);
                }
            }); 
    	}
		function printComments(response){
			$(".userComments").empty();
			for(var a in response){			
				var comment=response[a].comment;
				var createdAt=new Date(response[a].createdAt).toLocaleString();
				var name=response[a].name;
				var avatar=response[a].avatar;
				if(avatar==null||avatar==""){
					avatar="image/user1.png";
				}
				if(createdAt==null)createdat='';
				if(name==null)name='';
				if(comment==null)comment='';
			let Comments=`<div class="row border mt-1">
                <div class="col-auto d-flex align-items-center">
                <img src="`+avatar+`" class="userCommentsImg" alt="" srcset="">
            </div>
            <div class="col d-flex flex-column">
                <div class="col">`+name+`</div>
                <div class="col">`+createdAt+`</div>
                <div class="col">`+comment+`</div>
            </div>
        </div>`;
        
        $(".userComments").append(Comments);
			}
			
		}
		
		
		function printCardOnGrid(missions){
     		$(".GridViewDisplay").empty();
     		for(var i in missions){
				let mission=missions[i].mission;
				let isFavourite=missions[i].favourited;
				let ratingCount=Math.ceil(missions[i].rating);
				let generatedRatingStar="";
				let image=missions[i].image;
				let isApplied=missions[i].appliedForMission;
				let appliedTag="";
				let seatTag="";
				var seatLeft=mission.totalSeat-missions[i].noOfApplicatioin;
				var noOfApplication=missions[i].noOfApplicatioin;
				var goalAchieved=missions[i].goalAchieved;
				let timeOrGoalTag='';
				let dateGoalPills='';
				let closedTag='';
				let applyButton=`<a href="getMyMission?mission_id=`+mission.missionId+`" class="applyButtonGridView">Apply <i
							class="bi bi-arrow-right"></i></a>`;
				
				if(image==""){
					image="image/noimagefound.png";
				}
				if(isApplied){
					appliedTag='<button class="btn btn-success">applied</button>';
					applyButton=`<a href="getMyMission?mission_id=`+mission.missionId+`" class="applyButtonGridView">View Detail <i
							class="bi bi-arrow-right"></i></a>`;
				}
				if(mission.deadline!=null){
					var currentTimeDate=new Date(mission.deadline);
					var deadlineDate=new Date();
					if(deadlineDate>currentTimeDate){
						closedTag='<button class="btn btn-danger">closed</button>';
						applyButton=`<a class="applyButtonGridView" disabled>Closed <i
							class="bi bi-arrow-right"></i></a>`;
					}
				}
				if(mission.missionType=='GOAL'){
					let totalGoal=mission.goalMission.goalValue;
					if(goalAchieved>totalGoal){
						goalAchieved=totalGoal;
						closedTag='<button class="btn btn-danger">closed</button>';
						applyButton=`<a class="applyButtonGridView" disabled>Closed <i
							class="bi bi-arrow-right"></i></a>`;
					}
					let percentageCompleted=Math.round((goalAchieved / totalGoal) * 100);
					timeOrGoalTag=`<div class="col">
							<div class="row align-items-center">
								<div class="col-auto">
									<img src="image/achieved.png" alt="" srcset="">
								</div>
								<div class="col">
									<div class="row">
										<div class="progress p-0" style="height: 10px;">
												<div class="progress-bar" role="progressbar" style="width: `+percentageCompleted+`%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
										</div>
									</div>
									<div class="row">`+goalAchieved+` Achieved</div>
								</div>
							</div>
						</div>`;
						dateGoalPills=`<p>`+mission.goalMission.goalObjectiveText+`</p>`;
				}
				else{
					let deadline="not available";
					if(mission.deadline!=null){
						deadline=new Date(mission.deadline).toLocaleDateString();
					}
					timeOrGoalTag=`<div class="col">
							<div class="row align-items-center">
								<div class="col-auto">
									<img src="image/deadline.png" alt="" srcset="">
								</div>
								<div class="col">
									<div class="row">Deadline</div>
									<div class="row">`+deadline+`</div>
								</div>
							</div>
						</div>`;
						if(mission.startDate==null||mission.endDate==null){									
							dateGoalPills=`<p>Ongoing Oppurtunities</p>`;
						}
						else{
							dateGoalPills=`<p>From `+deadline+` Untill `+new Date(mission.endDate).toLocaleDateString()+`</p>`;
						}
				}
				if(mission.totalSeat!=0){
//					show Seat Left 
					seatTag=`<div class="col">
							<div class="row align-items-center">
								<div class="col-auto">
									<img src="image/Seats-left.png" alt="" srcset="">
								</div>
								<div class="col">
									<div class="row">`+seatLeft+`</div>
									<div class="row volunteeredCount">Seats Left</div>
								</div>
							</div>

						</div>`;
				}
				else{
						seatTag=`<div class="col">
							<div class="row align-items-center">
								<div class="col-auto">
									<img src="image/Already-volunteered.png" alt="" srcset="">
								</div>
								<div class="col">
									<div class="row">`+noOfApplication+`</div>
									<div class="row volunteeredCount">Already Volunteered</div>
								</div>
							</div>

						</div>`;
				}
				for(var a=1;a<=5;a++){
					if(ratingCount>0){
						generatedRatingStar+=`<div class="col">
									<img src="image/selected-star.png" alt="" srcset="">
								</div>`;
						ratingCount--;
					}
					else{
						generatedRatingStar+=`<div class="col">
									<img src="image/star.png" alt="" srcset="">
								</div>`;
					}
				}
				let LikeTag=`<i class="LikeButton bi bi-heart" id="`+mission.missionId+`"></i>`;
				if(isFavourite){
					LikeTag=`<i class="LikeButton bi bi-heart-fill" id="`+mission.missionId+`"></i>`;
				}
				let card=`<div class="card col-lg-4 col-md-6 col-xs-12">
					<div class="d-flex flex-column appliedCloseButtons">
					`+appliedTag+`
					`+closedTag+`
				</div>
				<p class="missionCityGridView">
					<i class="bi bi-geo-alt"></i>`+mission.city.name+`
				</p>
				<div class="missionLikeGridView d-flex flex-column">`+
				LikeTag
				+`
					<i class="bi bi-person-plus recommandButton" data-bs-toggle="modal" data-bs-target="#recommendModal"></i>
				</div>
				<img
					src="`+image+`"
					class="card-img-top missionImgGridView" alt="...">
				<div class="card-body">
					<div class="d-flex justify-content-center missionCategoryDiv">
						<p class="missionCategoryGridView">`+mission.missionTheme.title+`</p>
					</div>
					<h5 class="card-title">`+mission.title+`</h5>
					<p class="card-text">`+mission.shortDescription+`</p>
					<div class="row ratingDivGridView">
						<div class="col">`+mission.organizationName+`</div>
						<div class="col">
							<div class="row d-flex flex-row ratingStar flex-nowrap">
								`+generatedRatingStar+`
							</div>
						</div>
					</div>
					<br>
					<div class="hrLine hrLineOverrided"></div>
					<div class="row missionDatesGridView">
						<div class="col d-flex justify-content-center">
							`+dateGoalPills+`
						</div>
					</div>
					<div class="row">
						`+seatTag+` 
						`+timeOrGoalTag+`
						 
					</div>
					<div class="hrLine"></div>
					<div class="d-flex justify-content-center">
					`+applyButton+`
						
					</div>

				</div>
			</div>`;
				$(".GridViewDisplay").append(card);
			}
			
			$(".LikeButton").click(function(){
				var missionId=$(this).attr("id");
			 	$.ajax({
                url: "addToMyFavourite",
                dataType: 'json',
                data:{missionId:missionId},
                type:"POST",
                
                success: function(response){
                }
            });
            if($(this).is(".bi-heart")){						
			$(this).removeClass("bi-heart");
			$(this).addClass("bi-heart-fill LikedMission");
			}
			else{
				$(this).removeClass("bi-heart-fill LikedMission");
				$(this).addClass("bi-heart");
			}
				});
     	}

    </script>
	<script src="js/spinner.js"></script>
</body>

</html>
