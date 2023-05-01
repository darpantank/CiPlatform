<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ResetPassword</title>
  <!-- bootstrap css  -->
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/login.css">
</head>

<body>

<c:if test="${token!=''}">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12 col-lg-8">
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-indicators">
            
          </div>
          <div class="carousel-inner">

          </div>
        </div>
      </div>
      <div class="col-sm-12 col-lg-4 login d-flex flex-column justify-content-between">
        <div class="row"></div>
        <div class="row">
        <div class="messageBox">
        	
        </div>
          <div class="col">
            <p class="text-center forgotPass">New Password</p>
            <p class="text-muted text-center">Please enter a new password in the fields below.</p>
            <form action="../resetmypassword" method="post" id="resetPasswordForm">
            <input type="hidden" name="token" value="${token}" readonly required hidden>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label text-muted">New Password</label>
                    <input type="password" class="form-control" id="password" name="password" minlength="8" required>
                  </div>
              <div class="mb-3">
                <label for="exampleInputPassword2" class="form-label text-muted">Confirm New Password</label>
                <input type="password" class="form-control" name="confirm_password" id="confirm_password" minlength="8" required>
              </div>
              <button type="submit" class="btn w-100">Change Password</button>
            </form>
            <p class="text-center"><a href="login.html" class="text-muted">Login</a></p>
          </div>
        </div>
        <div class="row">
          <a href="privacy" class="text-muted text-center">Privacy Policy</a>
        </div>

      </div>
    </div>
  </div>
  <script src="../js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="../js/validatePassword.js"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
  <script>
  	$(document).ready(function() {
	  $("#resetPasswordForm").validate({rules: {
		  confirm_password:{
			  equalTo: "#password"
		  }
	  },messages:{
		  confirm_password:{
			  equalTo: "Password and Confirm Password must same"
		  }
	  }	  
	  });
	  
	  fetchBannerList();
	});
  	function fetchBannerList(){
    	$.ajax({
	        url: "../fetchallbanner",
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
  	                <img src="../`+banner.image+`" class="d-block w-100 size-fix" alt="...">
  	                <div class="carousel-caption d-none d-md-block">
  	                  <p class="carouselLabelText text-start">`+banner.text+`</p>
  	                  
  	                </div>
  	              </div>`;
  			}
  			else{
  				imageDiv+=`<div class="carousel-item">
  	                <img src="../`+banner.image+`" class="d-block w-100 size-fix" alt="...">
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
  </c:if>
  <script src="<c:url value="/js/spinner.js"></c:url>"></script>
</body>

</html>