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
	<input type="text" class="defaultCountry" hidden value="${user.country.country_id}">
    <!-- Filter SideBar -->
    <div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="leftFilterMenu">
        <button onclick="closeLeftFilterMenu()" class="w3-bar-item w3-button w3-large"><img src="image/cancel.png"
                alt="" srcset=""></button>
        <!-- Filters dropdown Sidebar  -->

        <div class="dropdown mysidebar">
            <select class="countrySelectSidebar btn dropdown-toggle">
                <option value="country" hidden>Country</option>
            </select>
		</div>
        <div class="dropdown mysidebar">
            <select class="citySelectSidebar btn dropdown-toggle">
                <option value="city" hidden>City</option>
            </select>
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
        <!-- second Header  -->
    <div class="container-fluid secondHeaderParent" id="secondHeader">
        <div class="container d-flex secondHeader justify-content-center">
            <div class="row d-flex justify-content-between">
                <div class="col d-flex search justify-content-start">
                    <form class="d-flex" role="search">
                        <button class="btn gotoSidebar" type="submit"><img src="image/search.png" alt=""></button>
                        <input class="form-control me-2 search_field" type="search" placeholder="Search Mission..."
                            aria-label="Search" value="">
                    </form>
                    <button class="w3-button w3-xlarge w3-left filterBurger" onclick="openLeftFilterMenu()"><img
                            src="image/filter.png" alt="" srcset=""></button>
                </div>
                <div class="col d-flex justify-content-end filter gotoSidebar">
                    <div class="dropdown d-flex align-items-center leftBorder">
                        <select class="countrySelect btn dropdown-toggle">
                        	<option value="country" hidden>Country</option>
                        </select>
					</div>
                    <div class="dropdown d-flex align-items-center leftBorder">
                        <select class="citySelect btn dropdown-toggle">
                        	<option value="city" hidden>City</option>
                        </select>
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
                <p class="noOfMission">Explore <b id="noOfMission">${fn:length(missions)}</b> Mission</p>
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
                <div class="row GridViewDisplay w-100">
    				<!-- Data Fetched here of mission  -->
					
				</div>
            </div>
        </div>
        
        <div class="tab-pane fade" id="list" role="tabpanel" aria-labelledby="profile-tab">
            <!-- List View Div  -->
            <div class="container ListViewDisplay">
                <!-- List View Fetched Here --> 
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
         let missions="";
    	 let country="";
    	 let CheckedCountry="";
    	 let cityList="";
    	 var CountryOfUser="";
         $(document).ready(function(){
        	 CountryOfUser=$(".defaultCountry").val;
        	 console.log(CountryOfUser);
        	 /* Initial Mission Loading Function */     		 
        	 $.ajax({
                 url: "loadAllMission",
                 dataType: 'json',
                 success: function(response){
                	 missions=response;
                	 console.log(missions);
                	 console.log("Total Mission :"+Object.keys(missions).length);
                	 printCardOnGrid(missions);
                	 printCardOnList(missions);                	                 	 
                 }
             });
        	 $.ajax({
                 url: "loadListOfCountry",
                 dataType: 'json',
                 success: function(response){
                	 country=response;
                	 addCountryList(country);
                 }
             });
        	 /* Search Mission Logic */
             $('.search_field').keyup(function(){
            	 updateMissionsOnChange();
             });
        	 
             $('.countrySelect, .countrySelectSidebar').on('change', function () {
            	 CheckedCountry = $(this).find("option:selected").val();
                 getCityList(CheckedCountry);
                 updateMissionsOnChange();
            });
        });
        	 
         function  updateMissionsOnChange(){
        	 var data1 = { keyword:$('.search_field').val(),
        			 		Country: CheckedCountry
        			 	}; 
             $.ajax({
                 url: "searchMission",
                 type: "POST",
                 data:data1,
                 dataType: 'json',
                 success: function(response){
                	missions=response;
                	var a=Object.keys(missions).length;
                	editUpdatedMission(a);                   		
                	printCardOnGrid(missions);
                	printCardOnList(missions);  
                	if(a==0){
                		if($(".noMissionFound").length===0){
                			noMissionFound();
                		}
                	}
                	else{
                		$(".noMissionFound").remove();
                	}
                 }
             });   
         }
         	function getCityList(CheckedCountry){
         		//get City List
         		$.ajax({
                    url: "loadListOfCity",
                    dataType: 'json',
                    data:{countryId: CheckedCountry},
                    type:"POST",
                    success: function(response){
                   	 cityList=response;
                   	addCityList(cityList);
                    }
                });
         	}
         	function addCityList(cityList){
         		console.log(cityList);
         		$(".citySelect").empty();
         		$(".citySelectSidebar").empty();
         		var data="<option value='city' hidden>city</option>";
         		let status=0;
         		for(var i in cityList){
         			status=1;
         			data+='<option value="'+cityList[i].city_id+'"><input type="checkbox" class="cityList"> '+cityList[i].name+'</option>';
         		}
         		if(status==0){
         			data+="<option value='Nocity'>No city Found</option>";
         		}
         		$(".citySelect").append(data);
         		$(".citySelectSidebar").append(data);
         	}
         	function editUpdatedMission(a){
         		$("#noOfMission").html(a);
         	}
         	function noMissionFound(){
         		$(".gridListView").append('<h1 class="noMissionFound">No Mission Found</h1>');
         	}
         	function addCountryList(country){
         		var data="";
         		for(var i in country){
         			if(CountryOfUser==country[i].country_id){
         				console.log("thanks");
         			}
         			data+='<option value="'+country[i].country_id+'"> '+country[i].name+'</option>';
         		}
         		$(".countrySelect").append(data);
         		$(".countrySelectSidebar").append(data);
         	}
         	function printCardOnList(missions){
         		$(".ListViewDisplay").empty();
         		for(var i in missions){
         		let list=`<div class="row ListViewCard">
                    <div class="card">
                    <div class="row g-0">
                        <div class="col-md-3 missionImg">
                            <p class="missionCityListView"><i class="bi bi-geo-alt"></i>`+missions[i].city.name+`</p>
                            <p class="missionAppliedListView"> Applied</p>
                            <div class="missionLikeListView d-flex flex-column"><i class="bi bi-heart"></i><i
                                class="bi bi-person-plus"></i>
                            </div>
                            <div class="d-flex justify-content-center missionCategoryListView"><p>`+missions[i].mission_theme.title+`</p></div>
                            <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png" class="img-fluid rounded-start" alt="...">
                        </div>
                        <div class="col-md-9">
                            <div class="card-body">
                                <div class="row w-100 d-flex ">
                                    <div class="col">
                                        <div class="row d-flex justify-content-start firstInfoContainerListView">
                                            <div class="col d-flex"><i class="bi bi-geo-alt"> </i><p>`+missions[i].country.name+`</p></div>
                                            <div class="col d-flex"><i class="bi bi-globe"> </i><p> `+missions[i].mission_theme.title+`</p></div>
                                            <div class="col d-flex"><i class="bi bi-people"> </i> <p>`+missions[i].organization_name+`</p></div>
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
                                <h5 class="card-title">`+missions[i].title+`</h5>
                                <p class="card-text">`+missions[i].short_description+`</p>
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
                
            </div>`;
         			$(".ListViewDisplay").append(list);
         		}
         	}
         	function printCardOnGrid(missions){
         		$(".GridViewDisplay").empty();
         		
				for(var i in missions){
					let card=`<div class="card col-lg-4 col-md-6 col-xs-12">
						<div class="d-flex flex-column appliedCloseButtons">
						<button class="btn btn-success">applied</button>
						<button class="btn btn-danger">closed</button>
					</div>
					<p class="missionCityGridView">
						<i class="bi bi-geo-alt"></i>`+missions[i].city.name+`
					</p>
					<p class="missionLikeGridView d-flex flex-column">
						<i class="bi bi-heart"></i><i class="bi bi-person-plus"></i>
					</p>
					<img
						src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
						class="card-img-top missionImgGridView" alt="...">
					<div class="card-body">
						<div class="d-flex justify-content-center missionCategoryDiv">
							<p class="missionCategoryGridView">`+missions[i].mission_theme.title+`</p>
						</div>
						<h5 class="card-title">`+missions[i].title+`</h5>
						<p class="card-text">`+missions[i].short_description+`</p>
						<div class="row ratingDivGridView">
							<div class="col">`+missions[i].organization_name+`</div>
							<div class="col">
								<div class="row d-flex flex-row ratingStar flex-nowrap">
									<div class="col">
										<img src="image/selected-star.png" alt="" srcset="">
									</div>
									<div class="col">
										<img src="image/selected-star.png" alt="" srcset="">
									</div>
									<div class="col">
										<img src="image/selected-star.png" alt="" srcset="">
									</div>
									<div class="col">
										<img src="image/star.png" alt="" srcset="">
									</div>
									<div class="col">
										<img src="image/star.png" alt="" srcset="">
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="hrLine hrLineOverrided"></div>
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
						<div class="hrLine"></div>
						<div class="d-flex justify-content-center">
							<a href="#" class="applyButtonGridView">Apply <i
								class="bi bi-arrow-right"></i></a>
						</div>

					</div>
				</div>`;
					$(".GridViewDisplay").append(card);
				}	
         	}
         	</script>
 <script src="js/sidebarJs.js"></script>
<!--     <script src="js/add_navbar.js"></script> -->

</html>