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
</head>

<body>    
	
	<!--NAvbar-->
	<div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container mainContainer gap-2">
    	<input type="text" class="missionId" value="${Mission.mission_id}" hidden>
        <div class="row">
            <!-- image caresoul Div  -->
            <div class="col-md-12 col-lg-5">
                <div id="firstDiv">
                    <img src="image/Grow-Trees-On-the-path-to-environment-sustainability - crop.png" alt=""
                        class="mainPhoto">
                </div>
                <div id="SecondDiv">
                    <div class="swiper mySwiper">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png" alt=""></div>
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="image/Animal-welfare-&-save-birds-campaign-1.png" alt=""></div>
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="image/CSR-initiative-stands-for-Coffee--and-Farmer-Equity-3.png" alt=""></div>
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="image/Education-Supplies-for-Every--Pair-of-Shoes-Sold-1.png" alt=""></div>
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="image/Plantation-and-Afforestation-programme-1.png" alt=""></div>
                            <div class="swiper-slide"><img class="imgCarousel"
                                    src="image/Nourish-the-Children-in--African-country-1.png" alt=""></div>
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
                    <p class="detailsOfMission">${Mission.short_description}</p>
                </div>
                <div class="missionsTargets">
                    <div class="d-flex justify-content-center">
                        <p class="missionGoal text-center">Plant 10,000 Trees</p>
                    </div>

                    <div class="row mt-2">
                        <div class="col-6">
                            <div class="row d-flex align-items-center">
                                <div class="col-6 d-flex justify-content-end smallIcon"><img src="image/deadline.png"
                                        alt="" srcset=""></div>
                                <div class="col-6 d-flex flex-column justify-content-start">
                                    <div class="col noOfSeatLeft">10</div>
                                    <div class="col">Seat Left</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="row d-flex align-items-center h-100">
                                <div class="col-6 d-flex justify-content-end smallIcon"><img src="image/deadline.png"
                                        alt="" srcset=""></div>
                                <div class="col-6 d-flex flex-column justify-content-start">
                                    <div class="col">
                                        <!-- progress Bar -->
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" style="width: 60%"
                                                aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <div class="col">8000 Achieved</div>
                                </div>
                            </div>
                        </div>
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
                        <div class="col-sm-12 col-md-6"><button type="button" class="btn W-90"><i
                                    class="bi bi-person-plus"></i> Recommend to a Co-Worker</button></div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="row d-flex flex-row flex-nowrap ratingStars">
                            <div class="col ratingStar" value="ONE"><img src="image/selected-star.png" alt="" srcset=""></div>
                            <div class="col ratingStar" value="TWO"><img src="image/selected-star.png" alt="" srcset=""></div>
                            <div class="col ratingStar" value="THREE"><img src="image/selected-star.png" alt="" srcset=""></div>
                            <div class="col ratingStar" value="FOUR"><img src="image/star.png" alt="" srcset=""></div>
                            <div class="col ratingStar" value="FIVE"><img src="image/star.png" alt="" srcset=""></div>
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
                            <div class="col d-flex justify-content-center textBigDark">${Mission.mission_theme.title}</div>
                        </div>
                        <div class="col d-flex flex-column MissioninfoCard">
                            <div class="col d-flex justify-content-center"><i class="bi bi-calendar"></i></div>
                            <div class="col d-flex justify-content-center textSmallLight">Date</div>
                            <div class="col d-flex justify-content-center textBigDark">Ongoing Oppurtunnity</div>
                        </div>
                        <div class="col d-flex flex-column MissioninfoCard">
                            <div class="col d-flex justify-content-center"><i class="bi bi-people"></i></div>
                            <div class="col d-flex justify-content-center textSmallLight">Organization</div>
                            <div class="col d-flex justify-content-center textBigDark">${Mission.organization_name}</div>
                        </div>
                    </div>
                </div>
                <div class="applyButtonDiv d-flex justify-content-center mt-3">
                    <button class="btn">Apply Now <i class="bi bi-arrow-right"></i></button>
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
                            <h2 class="titleOfMissionTab">Introduction</h2>
                            <p class="detailsOfMissionTab">
                            ${Mission.description}
                            </p>
                            <h2 class="titleOfMissionTab">Challange</h2>
                            <p class="detailsOfMissionTab">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
                                do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
                                aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
                                pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                                deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing
                                elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                                minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia
                                deserunt mollit anim id est laborum.</p>
                            <h2 class="titleOfMissionTab">Documents</h2>
                            <div class="d-flex flex-column justify-content-start gap-2 flex-md-row mt-2">
                            <c:forEach var="doc" items="${documents}">
                            	
                                <a class="btn documentDownloadBtn" href='<c:url value="${doc.document_path}${doc.document_name}"></c:url>'>
										<c:choose>
											<c:when test="${doc.document_type== 'PDF'}">
												<img src="image/pdf.png">
											</c:when>
											<c:when test="${doc.document_type== 'XLS'}">
												<img src="image/xlsx.png">
											</c:when>
											<c:otherwise>
												<img src="image/doc.png">
											</c:otherwise>
										</c:choose>
                                    ${doc.document_name}</a>
                            </c:forEach>
                            </div>

                        </div>
                    </div>
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <div class="container mt-3">
                            <p>${Mission.organization_detail }</p>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                        <div class="mb-3 mt-3">
                            <textarea class="form-control" id="userCommentText" rows="3"
                                placeholder="Enter Your Comments..."></textarea>
                        </div>
                        <div class="applyButtonDiv mt-3">
                            <button class="btn">Post Comment</button>
                        </div>
                        <div class="userComments">
                            <div class="container mt-2">
                                <div class="row border mt-1">
                                    <div class="col-auto d-flex align-items-center">
                                        <img src="image/volunteer1.png" class="userCommentsImg" alt="" srcset="">
                                    </div>
                                    <div class="col d-flex flex-column">
                                        <div class="col">margret walah</div>
                                        <div class="col">Monday , October 21, 2019 4:57 pm</div>
                                        <div class="col">Really Nice Mission Helpful for peoples</div>
                                    </div>
                                </div>
                                <div class="row border mt-1">
                                    <div class="col-auto d-flex align-items-center">
                                        <img src="image/volunteer2.png" class="userCommentsImg" alt="" srcset="">
                                    </div>
                                    <div class="col d-flex flex-column">
                                        <div class="col">John Doe</div>
                                        <div class="col">Monday , October 21, 2019 4:57 pm</div>
                                        <div class="col">Good Mission for Some peoples</div>
                                    </div>
                                </div>
                                <div class="row border mt-1">
                                    <div class="col-auto d-flex align-items-center">
                                        <img src="image/volunteer3.png" class="userCommentsImg" alt="" srcset="">
                                    </div>
                                    <div class="col d-flex flex-column">
                                        <div class="col">Sam Doe</div>
                                        <div class="col">Monday , October 22, 2019 4:57 pm</div>
                                        <div class="col">Need Improvement into mission</div>
                                    </div>
                                </div>
                            </div>
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
                            <div class="col">Skills</div>
                            <div class="col">
                            <c:forEach var="a" items="${Mission.missionSkills}" varStatus="state">
                            	<c:if test="${not state.first}">
									,       								
    							</c:if>
                            	${a.skills.skill_name}
								</c:forEach>
                            </div>
                        </div>
                        <div class="hrLine mt-2 mb-2"></div>
                        <div class="row">
                            <div class="col">Days</div>
                            <div class="col">${ Mission.availability}</div>
                        </div>
                        <div class="hrLine mt-2 mb-2"></div>
                        <div class="row">
                            <div class="col">Rating</div>
                            <div class="col">
                                <div class="row d-flex flex-nowrap g-0 starsOfRating">
                                
                                	<c:forEach begin="1" end="${rating}">                                	
                                    	<div class="col"><img src="image/selected-star.png" alt="" srcset=""></div>
                                	</c:forEach>
                                	<c:forEach begin="${rating+1}" end="5">                                		
                                    	<div class="col"><img src="image/star.png" alt="" srcset=""></div>
                                	</c:forEach>                            
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="informstionContainer border mt-4">
                        <div class="d-flex informstionContainerText">
                            <h3>Recent Volunteers</h3>
                        </div>
                        <div class="hrLine mb-3"></div>
                        <div class="gridSys">
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer1.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer2.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer3.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer4.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer5.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer6.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer7.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer8.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <img src="image/volunteer9.png" class="rounded-circle recentVolunteerImg" alt=""
                                    srcset="">
                                <p>John Doe</p>
                            </div>
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
	
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="js/imageCaresoul.js"></script>
    <script>
    $( document ).ready(function() {
    	let missions="";
    	let missionId=$(".missionId").val();
    	$.ajax({
            url: "getRelatedMission",
            data:{missionId:missionId},
            type:"GET",
            success: function(response){
            	missions=response;
            	printCardOnGrid(missions);
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
		
		
		function printCardOnGrid(missions){
     		$(".GridViewDisplay").empty();
     		console.log(missions);
			for(var i in missions){
				let mission=missions[i].mission;
				let isFavourite=missions[i].favourited;
				let ratingCount=Math.ceil(missions[i].rating);
				let generatedRatingStar="";
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
				let LikeTag=`<i class="LikeButton bi bi-heart" id="`+mission.mission_id+`"></i>`;
				if(isFavourite){
					LikeTag=`<i class="LikeButton bi bi-heart-fill" id="`+mission.mission_id+`"></i>`;
				}
				let card=`<div class="card col-lg-4 col-md-6 col-xs-12">
					<div class="d-flex flex-column appliedCloseButtons">
					<button class="btn btn-success">applied</button>
					<button class="btn btn-danger">closed</button>
				</div>
				<p class="missionCityGridView">
					<i class="bi bi-geo-alt"></i>`+mission.city.name+`
				</p>
				<div class="missionLikeGridView d-flex flex-column">`+
				LikeTag
				+`
					<i class="bi bi-person-plus"></i>
				</div>
				<img
					src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
					class="card-img-top missionImgGridView" alt="...">
				<div class="card-body">
					<div class="d-flex justify-content-center missionCategoryDiv">
						<p class="missionCategoryGridView">`+mission.mission_theme.title+`</p>
					</div>
					<h5 class="card-title">`+mission.title+`</h5>
					<p class="card-text">`+mission.short_description+`</p>
					<div class="row ratingDivGridView">
						<div class="col">`+mission.organization_name+`</div>
						<div class="col">
							<div class="row d-flex flex-row ratingStar flex-nowrap">
								`+generatedRatingStar+`
							</div>
						</div>
					</div>
					<br>
					<div class="hr1Line hrLineOverrided"></div>
					<div class="row missionDatesGridView">
						<div class="col d-flex justify-content-center">
							<p>Ongoing Oppurtunity</p>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="row">
								<div class="col">
									<img src="image/Seats-left.png" alt="" srcset="">
								</div>
								<div class="col">
									<div class="row">10</div>
									<div class="row">Seats Left</div>
								</div>
							</div>

						</div>
						<div class="col">
							<div class="row">
								<div class="col">
									<img src="image/deadline.png" alt="" srcset="">
								</div>
								<div class="col">
									<div class="row">09/01/2019</div>
									<div class="row">Deadline</div>
								</div>
							</div>

						</div>
					</div>
					<div class="hr1Line"></div>
					<div class="d-flex justify-content-center">
						<a href="getMyMission?mission_id=`+mission.mission_id+`" class="applyButtonGridView">Apply <i
							class="bi bi-arrow-right"></i></a>
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
    	
		
		$(".ratingStar").click(function(){
			console.log($(this).attr("value"));
		})
    </script>
</body>

</html>
