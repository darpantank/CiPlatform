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
  <title>Forgot Password</title>
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
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
              aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
              aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
              aria-label="Slide 3"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3"
              aria-label="Slide 4"></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="<c:url value="/image/Grow-Trees-On-the-path-to-environment-sustainability-login.png"></c:url>" class="d-block w-100 size-fix" alt="...">
              <div class="carousel-caption d-none d-md-block">
                <p class="carouselLabelText text-start">Sed ut perspiciatis unde omnis iste natus voluptatem.</p>
                <p class="carouselDescriptionText text-start">Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                  nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
                  reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                  cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
              </div>
            </div>
            <div class="carousel-item">
              <img src="<c:url value="/image/Grow-Trees-On-the-path-to-environment-sustainability-login.png"></c:url>" class="d-block w-100 size-fix" alt="...">
              <div class="carousel-caption d-none d-md-block">
                <p class="carouselLabelText text-start">Sed ut perspiciatis unde omnis iste natus voluptatem.</p>
                <p class="carouselDescriptionText text-start">Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                  nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
                  reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                  cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
              </div>
            </div>
            <div class="carousel-item">
              <img src="<c:url value="/image/Grow-Trees-On-the-path-to-environment-sustainability-login.png"></c:url>" class="d-block w-100 size-fix" alt="...">
              <div class="carousel-caption d-none d-md-block">
                <p class="carouselLabelText text-start">Sed ut perspiciatis unde omnis iste natus voluptatem.</p>
                <p class="carouselDescriptionText text-start">Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                  nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
                  reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                  cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
              </div>
            </div>
            <div class="carousel-item">
              <img src="<c:url value="/image/Grow-Trees-On-the-path-to-environment-sustainability-login.png"></c:url>" class="d-block w-100 size-fix" alt="...">
              <div class="carousel-caption d-none d-md-block">
                <p class="carouselLabelText text-start">Sed ut perspiciatis unde omnis iste natus voluptatem.</p>
                <p class="carouselDescriptionText text-start">Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
                  nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
                  reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                  cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-sm-12 col-lg-4 login d-flex flex-column justify-content-between">
        <div class="row">
        	<c:if test="${message=='usernotfound'}">	
				<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Email is not found in our record
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			
			<c:if test="${message=='tokensent'}">	
				<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong>Thanks </strong> Email Send to Your Register Email Id
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='someerror'}">	
				<div class="alert alert-warning alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Email Is not sent Due to Some Technical Issue
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='invalidtoken'}">	
				<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Your Token Is Invalid
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			<c:if test="${message=='tokenexpire'}">	
				<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Your Token Is Expired please use Token in 4 hour next time
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
			</c:if>
			
			
        </div>
        <div class="row">
          <div class="col">
            <p class="text-center forgotPass">Forgot Password</p>
            <p class="text-muted text-center">Enter your email address you've using for your account below and we will send you a password reset link</p>
            <form action="forgotPasswordTokenGenerate" method="post" id="forgotPasswordForm">
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-muted">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" required>
              </div>
              <button type="submit" class="btn w-100">Reset My Password</button>
            </form>
            <p class="text-center"><a href="login" class="text-muted">Login</a></p>
            
          </div>
        </div>
        <div class="row">
          <a href="privacy" class="text-muted text-center">Privacy Policy</a>
        </div>

      </div>
    </div>
  </div>

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
        
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
  <script>
  	$(document).ready(function() {
	  $("#forgotPasswordForm").validate();
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
    </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
          <script src="<c:url value="/js/bootstrap.min.js"></c:url>"></script>
	<script src="<c:url value="/js/spinner.js"></c:url>"></script>
</body>

</html>