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
  <title>Login</title>
  <!-- bootstrap css  -->
  <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"></c:url>">
  <link rel="stylesheet" href="<c:url value="/css/login.css"></c:url>">
</head>

<body>
<jsp:include page="spinner.jsp" />
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12 col-lg-8">
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-indicators">
          
<!--           	Caresoul indicators -->              
          </div>
          <div class="carousel-inner">
<!--       			Caresoul Items Fetched Here       -->
          </div>
        </div>
      </div>
      <div class="col-sm-12 col-lg-4 login d-flex flex-column justify-content-between">
        <div class="row">
        	<c:if test="${message=='wrongpassword'}">	
				<div class="alert alert-warning alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Email or Password is incorrect
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='registrationsuccess'}">	
				<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong>Thanks </strong> Registration Is done Successfully Now You Can Login !
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='passwordupdate'}">	
				<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong>Thanks </strong> Password Reset Successfully !
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='logoutsuccess'}">	
				<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong>Thanks </strong> Logout Successfully !
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='sessionexpire'}">	
				<div class="alert alert-warning alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Your session is Expired Please Relogin... !
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='nonadmin'}">	
				<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> You Don't Have Admin Rights... !
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='deactivateprofile'}">	
				<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Your Profile is Deactivated... !
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='invalidtoken'}">	
				<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Your Token Is Not Valid Please Resend Token... !
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			
			
			
			
			 
		</div>
        <div class="row">
          <div class="col">
            <form action="validateuser" method="post" id="loginForm">
            	<div class="mb-3">
            		<p class="text-center text-primary" id="message"></p>
            	</div>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-muted required">Email address</label>
                <input type="email" name="email" class="form-control email" required>
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label text-muted required">Password</label>
                <input type="password" name="password" minlength="8" class="form-control password" id="exampleInputPassword1" required>
              </div>
              <button type="submit" class="btn w-100">Login</button>
            </form>
            <p class="text-center"><a href="forgotpassword" class="text-muted">Lost your password?</a></p>
            <p class="text-muted text-center">Don't have an account? <a href="registration">Create an account</a></p>
          </div>
        </div>
        <div class="row">
          <a href="privacy" class="text-muted text-center">Privacy Policy</a>
        </div>

      </div>
    </div>
  </div>
  <script src="<c:url value="/js/bootstrap.min.js"></c:url>"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
  <script>
  let incomingData='';
  	$(document).ready(function() {
	  $("#loginForm").validate();
	  fetchBannerList();
	  $('label.required').append('&nbsp;<strong>*</strong>&nbsp;');
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
	<script src="<c:url value='/js/spinner.js'></c:url>"></script>
  
</body>

</html>