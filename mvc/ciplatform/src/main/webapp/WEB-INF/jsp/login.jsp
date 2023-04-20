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
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/login.css">
</head>

<body>
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
              <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-login.png" class="d-block w-100 size-fix" alt="...">
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
              <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-login.png" class="d-block w-100 size-fix" alt="...">
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
              <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-login.png" class="d-block w-100 size-fix" alt="...">
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
              <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-login.png" class="d-block w-100 size-fix" alt="...">
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
			
			 
		</div>
        <div class="row">
          <div class="col">
            <form action="validateuser" method="post" id="loginForm">
            	<div class="mb-3">
            		<p class="text-center text-primary" id="message"></p>
            	</div>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-muted">Email address</label>
                <input type="email" name="email" class="form-control email" required>
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label text-muted">Password</label>
                <input type="password" name="password" minlength="3" class="form-control password" id="exampleInputPassword1" required>
              </div>
              <button type="submit" class="btn w-100">Login</button>
            </form>
            <p class="text-center"><a href="forgotpassword" class="text-muted">Lost your password?</a></p>
            <p class="text-muted text-center">Don’t have an account? <a href="registration">Create an account</a></p>
          </div>
        </div>
        <div class="row">
          <a href="privacy" class="text-muted text-center">Privacy Policy</a>
        </div>

      </div>
    </div>
  </div>
  <script src="js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
  <script>
  	$(document).ready(function() {
	  $("#loginForm").validate();
	});
  </script>
</body>

</html>