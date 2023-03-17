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
						<strong>Sorry </strong> Your Token Is Mismatching
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
            <form action="forgotPasswordTokenGenerate" method="post">
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label text-muted">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
              </div>
              <button type="submit" class="btn w-100">Reset My Password</button>
            </form>
            <p class="text-center"><a href="login.html" class="text-muted">Login</a></p>
            
          </div>
        </div>
        <div class="row">
          <a href="#" class="text-muted text-center">Privacy Policy</a>
        </div>

      </div>
    </div>
  </div>
  <script src="js/bootstrap.min.js"></script>
</body>

</html>