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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
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
					<input type="email" class="form-control missionId"
							id="missionId" aria-describedby="emailHelp" hidden>

					<div class="modalMessageBody"></div>
				</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary recommandToCoworker">Recommand</button>
      </div>
    </div>
  </div>
</div>
	<c:if test="${not empty user.userId}">
		<input type="text" class="defaultId" hidden
		value="${user}">
	</c:if>
	<c:if test="${not empty user.country.countryId}">
		<input type="text" class="defaultCountry" hidden
		value="${user.country.countryId}">
	</c:if>
	<!-- Filter SideBar -->
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left"
		style="display: none" id="leftFilterMenu">
		<button onclick="closeLeftFilterMenu()"
			class="w3-bar-item w3-button w3-large">
			<img src="image/cancel.png" alt="" srcset="">
		</button>
		<!-- Filters dropdown Sidebar  -->

		<div class="dropdown mysidebar">
			<select class="countrySelectSidebar btn dropdown-toggle">
				<option value="country" hidden>Country</option>
			</select>
		</div>
		<div class="dropdown mysidebar">
			<button class="btn dropdown-toggle" type="button"
				data-bs-toggle="dropdown" aria-expanded="false">
				<span>City</span> <img src="image/drop-down.png">
			</button>
			<ul class="dropdown-menu citySelectorSidebar">

			</ul>
		</div>
		<div class="dropdown mysidebar">
			<button
				class="btn dropdown-toggle w-100 d-flex justify-content-between align-items-center"
				type="button" data-bs-toggle="dropdown" aria-expanded="false">
				<span>Theme</span> <img src="image/drop-down.png">
			</button>
			<ul class="dropdown-menu themeSelectorSidebar">

			</ul>
		</div>
		<div class="dropdown mysidebar">
			<button
				class="btn dropdown-toggle w-100 d-flex justify-content-between align-items-center"
				type="button" data-bs-toggle="dropdown" aria-expanded="false">
				<span>Skill</span> <img src="image/drop-down.png">
			</button>
			<ul class="dropdown-menu skillSelectorSidebar">
			</ul>
		</div>
	</div>

	<!-- NAvbar  -->
	<div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
	<!-- second Header  -->
	<div class="container-fluid secondHeaderParent" id="secondHeader">
		<div class="container d-flex secondHeader justify-content-center">
			<div class="row d-flex justify-content-between">
				<div class="col d-flex search justify-content-start">
					<form class="d-flex" role="search">
						<button class="btn gotoSidebar" type="submit">
							<img src="image/search.png" alt="">
						</button>
						<input class="form-control me-2 search_field" type="search"
							placeholder="Search Mission..." aria-label="Search" value="">
					</form>
					<button class="w3-button w3-xlarge w3-left filterBurger"
						onclick="openLeftFilterMenu()">
						<img src="image/filter.png" alt="" srcset="">
					</button>
				</div>
				<div class="col d-flex justify-content-end filter gotoSidebar">
					<div class="dropdown d-flex align-items-center leftBorder">
						<select class="countrySelect btn dropdown-toggle">
							<option value="country" hidden>Country</option>
						</select>
					</div>
					<div class="dropdown d-flex align-items-center leftBorder">

						<button class="btn dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">
							<span>City</span> <img src="image/drop-down.png">
						</button>
						<ul class="dropdown-menu citySelector">

						</ul>

					</div>
					<div class="dropdown d-flex align-items-center leftBorder">
						<button class="btn dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">
							<span>Theme</span> <img src="image/drop-down.png">
						</button>
						<ul class="dropdown-menu themeSelector">

						</ul>
					</div>
					<div class="dropdown d-flex align-items-center leftRightBorder">
						<button class="btn dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">
							<span>Skill</span> <img src="image/drop-down.png">
						</button>
						<ul class="dropdown-menu skillSelector">

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Applied Filter Showcase -->

	<div class="container AppliedFilter w-100">
		<div class="row d-flex justify-content-center" id="myList">
			<!--             Applied Filter Shows Here              -->
		</div>
	</div>

	<!-- <button onclick="addFilter()">Clcik</button> -->


	<!-- Explore Mission  -->
	<div class="container gridListView">
		<div class="row d-flex justify-content-around">
			<div
				class="col d-flex justify-content-md-start justify-content-sm-center align-content-center">
				<p class="noOfMission">
					Explore <b id="noOfMission">${fn:length(missions)}</b> Mission
				</p>
			</div>
			<div class="col d-flex justify-content-end hideOnSmallScreen">
				<div class="d-flex">
					<div class="col d-flex align-items-center">
						<select class="dropdown-toggle sortBy"
							aria-labelledby="dropdownMenuButton1" name="Sort BY">
							<option value="0" hidden>Sort By</option>
							<option value="1">Newest</option>
							<option value="2">Oldest</option>
							<option value="3">Deadline</option>
							<option value="4">Lowest Available Seat</option>
							<option value="5">Highest Available Seat</option>
						</select>
					</div>
					<div class="row">
					<div class="gridListButtons d-flex align-items-center">
						<ul class="nav nav-tabs row g-0 d-flex align-items-center" id="myTab" role="tablist">
							<li class="nav-item d-flex align-items-center col"
								role="presentation">
								<button class="nav-link active" id="home-tab"
									data-bs-toggle="tab" data-bs-target="#grid" type="button"
									role="tab" aria-controls="home" aria-selected="true">
									<img src="image/grid.png">
								</button>
							</li>
							<li class="nav-item d-flex align-items-center col"
								role="presentation">
								<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
									data-bs-target="#list" type="button" role="tab"
									aria-controls="profile" aria-selected="false">
									<img src="image/list.png">
								</button>
							</li>
						</ul>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- missions List  -->
	<div class="tab-content" id="myTabContent">

		<!-- Grid View Div  -->
		<div class="tab-pane fade show active" id="grid" role="tabpanel"
			aria-labelledby="home-tab">
			<div class="container d-flex gridView">
				<div class="row GridViewDisplay w-100">
					<!-- Data Fetched here of mission  -->

				</div>
			</div>
		</div>

		<div class="tab-pane fade" id="list" role="tabpanel"
			aria-labelledby="profile-tab">
			<!-- List View Div  -->
			<div class="container ListViewDisplay">
				<!-- List View Fetched Here -->
			</div>
		</div>
	</div>
	<div class="myPaginationTab d-flex justify-content-center text-danger">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
			</ul>
		</nav>
	</div>
	    <div class="container-fluid g-0 bg-light z-index-1111 mt-2 position-sticky bottom-0 start-0" style="z-index:1111">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.js"
		integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
		crossorigin="anonymous"></script>
			<script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
	<script src="<c:url value="js/homepage.js" />"></script>
	<script src="js/sidebarJs.js"></script>
	<script>	
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
	</script>
	<script src="js/spinner.js"></script>
	<!--     <script src="js/add_navbar.js"></script> -->
</html>