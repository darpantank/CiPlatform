<!DOCTYPE html>
<html lang="en">
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration</title>
  <!-- bootstrap css  -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/login.css">
</head>

<body>
<jsp:include page="spinner.jsp" />
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12 col-lg-8 col-md-12">
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-indicators">
            
          </div>
          <div class="carousel-inner">
                       
          </div>
        </div>
      </div>
      <div class="col-sm-12 col-lg-4 col-md-12 mt-2 registration d-flex flex-column justify-content-between">
      <c:if test="${message=='registrationfailed'}">	
				<div class="alert alert-warning alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Registration Failed because email or mobile no is already present in our record
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
        <div class="row">
          <div class="col">
            <form action="saveuser" method="post" id="registrationForm">
                <div class="mb-3">
                    <label for="exampleInput" class="form-label text-muted">First Name</label>
                    <input type="text" class="form-control" id="exampleFirstName" name="firstName" required>
                  </div>
                  <div class="mb-3">
                    <label for="exampleInput" class="form-label text-muted">Last Name</label>
                    <input type="text" class="form-control" id="exampleLastName" name="lastName" required>
                  </div>
                  <div class="mb-3">
                    <label for="examplePhoneNumber" class="form-label text-muted">Phone Number</label>
                    <input type="tel" class="form-control" id="exampleMobileNo" minlength="10" pattern="[1-9]{1}[0-9]{9}" name="phoneNumber" required>
                  </div>
              <div class="mb-3">
                <label for="exampleInputEmail" class="form-label text-muted">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp" name="email" required>
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword" class="form-label text-muted">Password</label>
                <input type="password" class="form-control" id="password" name="password" minlength="8" required>
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label text-muted">Confirm Password</label>
                <input type="password" class="form-control" id="confirm_password" minlength="8" required>
              </div>
              <button type="submit" class="btn w-100">Register</button>
            </form>
            <p class="text-center"><a href="forgotpassword" class="text-muted">Lost your password?</a></p>
            <p class="text-muted text-center">Aleready Register? <a href="login">Login Now</a></p>
          </div>
        </div>
        <div class="row">
          <a href="privacy" class="text-muted text-center">Privacy Policy</a>
        </div>

      </div>
    </div>
  </div>
  <script src="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
  <script src="js/validatePassword.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
  <script>
  	$(document).ready(function() {
	  $("#registrationForm").validate();
	  fetchBannerList();
	});
  	function fetchBannerList(){
    	$.ajax({
	        url: "fetchallbanner",
	        dataType: 'json',
	        type:"GET",
	        success: function(response){
	        	incomingData=response;
	        	printBanners();
	        }
	    });
    }
  	function printBanners(){
  		printCaresoulIndicators();
  		printCaresoulImages();
  	}
  	function printCaresoulImages(){
  		$(".carousel-inner").empty();
  		let imageDiv='';
  		let counter=0;
  		for(var i in incomingData){
  			banner=incomingData[i];
  			if(counter==0){
  				imageDiv+=`<div class="carousel-item active">
  	                <img src="`+banner.image+`" class="d-block w-100 size-fix" alt="...">
  	                <div class="carousel-caption d-none d-md-block">
  	                  <p class="carouselLabelText text-start">`+banner.text+`</p>
  	                  
  	                </div>
  	              </div>`;
  			}
  			else{
  				imageDiv+=`<div class="carousel-item">
  	                <img src="`+banner.image+`" class="d-block w-100 size-fix" alt="...">
  	                <div class="carousel-caption d-none d-md-block">
  	                  <p class="carouselLabelText text-start">`+banner.text+`</p>
  	                  
  	                </div>
  	              </div>`;
  			}
  			counter++;
  		}
  		$(".carousel-inner").append(imageDiv);
  		
  	}
  	function printCaresoulIndicators(){
  		$(".carousel-indicators").empty();
  		var counter=0;
  		var indicatorTag='';
  			for(var a=0;a<incomingData.length;a++){
  			if(counter==0){
  				indicatorTag+=`<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
		              aria-current="true" aria-label="Slide 1"></button>`;
  			}
  			else{
  				indicatorTag+=`<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="`+counter+`"
		              aria-label="Slide `+counter+`"></button>`;
  			}
  			counter++;
  		}
  		$(".carousel-indicators").append(indicatorTag);		            
  	}
  </script>
	<script src="js/spinner.js"></script>
  </script>
</body>

</html>