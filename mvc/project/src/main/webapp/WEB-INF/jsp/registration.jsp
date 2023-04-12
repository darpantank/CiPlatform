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
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12 col-lg-8 col-md-12">
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
            <form action="saveuser" method="post" id="userform">
                <div class="mb-3">
                    <label for="exampleInput" class="form-label text-muted">First Name</label>
                    <input type="text" class="form-control" id="exampleFirstName" name="first_name" required>
                  </div>
                  <div class="mb-3">
                    <label for="exampleInput" class="form-label text-muted">Last Name</label>
                    <input type="text" class="form-control" id="exampleLastName" name="last_name" required>
                  </div>
                  <div class="mb-3">
                    <label for="examplePhoneNumber" class="form-label text-muted">Phone Number</label>
                    <input type="tel" class="form-control" id="exampleMobileNo" pattern="[1-9]{1}[0-9]{9}" name="phone_number" required>
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
          <a href="#" class="text-muted text-center">Privacy Policy</a>
        </div>

      </div>
    </div>
  </div>
  <script src="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
  <script src="js/validatePassword.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</body>

</html>