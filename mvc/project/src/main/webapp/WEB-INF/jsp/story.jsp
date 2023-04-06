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
    <link rel="stylesheet" href="css/storylisting.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

    <title>Story - CiPlatform</title>
</head>

<body>
    	<div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container-fluid mainPhoto g-0">
        <div class="myDesc d-flex justify-content-center flex-column align-items-center w-100 h-100">
            <p class="imgDescriptor">Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis nobis cupiditate
                ad. Explicabo veritatis, dio, dolor modi nam.</p>
            <button class="btn shareStoryButton">Share Your Story <i class="bi bi-arrow-right"></i></button>
        </div>
        <img src="image/Grow-Trees-On-the-path-to-environment-sustainability - crop.png" alt="" srcset="">
    </div>
    <div class="container mt-4">
        <div class="row">
            <div class="card col-lg-4 col-md-6 col-xs-12">
                <div class="imgDiv d-flex justify-content-center">
                    <div class="d-flex justify-content-center missionCategoryDiv">
                        <p>Customer Experience</p>
                    </div>
                    <div class="viewDetailsHoverButton h-100 w-100">
                        <button class="btn">View Details <i class="bi bi-arrow-right"></i></button>
                    </div>
                    <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
                        class="card-img-top w-100" alt="...">

                </div>
                <div class="card-body">
                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                        of the
                        card's content.</p>
                    <div class="d-flex align-items-center gap-2">
                        <div><img class="profileImage" src="image/volunteer1.png" alt="" srcset=""></div>
                        <div>Andrew Jhonson</div>
                    </div>
                </div>
            </div>
            <div class="card col-lg-4 col-md-6 col-xs-12">
                <div class="imgDiv d-flex justify-content-center">
                    <div class="d-flex justify-content-center missionCategoryDiv">
                        <p>Customer Experience</p>
                    </div>
                    <div class="viewDetailsHoverButton h-100 w-100">
                        <button class="btn">View Details <i class="bi bi-arrow-right"></i></button>
                    </div>
                    <img src="image/CSR-initiative-stands-for-Coffee--and-Farmer-Equity-2.png"
                        class="card-img-top w-100" alt="...">

                </div>

                <div class="card-body">
                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                        of the
                        card's content.</p>
                    <div class="d-flex align-items-center gap-2">
                        <div><img class="profileImage" src="image/volunteer6.png" alt="" srcset=""></div>
                        <div>James Bond</div>
                    </div>
                </div>
            </div>
            <div class="card col-lg-4 col-md-6 col-xs-12">
                <div class="imgDiv d-flex justify-content-center">
                    <div class="d-flex justify-content-center missionCategoryDiv">
                        <p>Updates</p>
                    </div>
                    <div class="viewDetailsHoverButton h-100 w-100">
                        <button class="btn">View Details <i class="bi bi-arrow-right"></i></button>
                    </div>
                    <img src="image/Animal-welfare-&-save-birds-campaign-1.png"
                        class="card-img-top w-100" alt="...">

                </div>

                <div class="card-body">
                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                        of the
                        card's content.</p>
                    <div class="d-flex align-items-center gap-2">
                        <div><img class="profileImage" src="image/volunteer3.png" alt="" srcset=""></div>
                        <div>John Doe</div>
                    </div>
                </div>
            </div>
            <div class="card col-lg-4 col-md-6 col-xs-12">
                <div class="imgDiv d-flex justify-content-center">
                    <div class="d-flex justify-content-center missionCategoryDiv">
                        <p>Customer Experience</p>
                    </div>
                    <div class="viewDetailsHoverButton h-100 w-100">
                        <button class="btn">View Details <i class="bi bi-arrow-right"></i></button>
                    </div>
                    <img src="image/Plantation-and-Afforestation-programme-1.png"
                        class="card-img-top w-100" alt="...">

                </div>

                <div class="card-body">
                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                        of the
                        card's content.</p>
                    <div class="d-flex align-items-center gap-2">
                        <div><img class="profileImage" src="image/volunteer2.png" alt="" srcset=""></div>
                        <div>Ben Stokes</div>
                    </div>
                </div>
            </div>
            <div class="card col-lg-4 col-md-6 col-xs-12">
                <div class="imgDiv d-flex justify-content-center">
                    <div class="d-flex justify-content-center missionCategoryDiv">
                        <p>Customer Experience</p>
                    </div>
                    <div class="viewDetailsHoverButton h-100 w-100">
                        <button class="btn">View Details <i class="bi bi-arrow-right"></i></button>
                    </div>
                    <img src="image/Plantation-and-Afforestation-programme-1.png"
                        class="card-img-top w-100" alt="...">

                </div>

                <div class="card-body">
                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                        of the
                        card's content.</p>
                    <div class="d-flex align-items-center gap-2">
                        <div><img class="profileImage" src="image/volunteer2.png" alt="" srcset=""></div>
                        <div>Ben Stokes</div>
                    </div>
                </div>
            </div>
            <div class="card col-lg-4 col-md-6 col-xs-12">
                <div class="imgDiv d-flex justify-content-center">
                    <div class="d-flex justify-content-center missionCategoryDiv">
                        <p>Customer Experience</p>
                    </div>
                    <div class="viewDetailsHoverButton h-100 w-100">
                        <button class="btn">View Details <i class="bi bi-arrow-right"></i></button>
                    </div>
                    <img src="image/Plantation-and-Afforestation-programme-1.png"
                        class="card-img-top w-100" alt="...">

                </div>

                <div class="card-body">
                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                        of the
                        card's content.</p>
                    <div class="d-flex align-items-center gap-2">
                        <div><img class="profileImage" src="image/volunteer2.png" alt="" srcset=""></div>
                        <div>Ben Stokes</div>
                    </div>
                </div>
            </div>
            <div class="card col-lg-4 col-md-6 col-xs-12">
                <div class="imgDiv d-flex justify-content-center">
                    <div class="d-flex justify-content-center missionCategoryDiv">
                        <p>Customer Experience</p>
                    </div>
                    <div class="viewDetailsHoverButton h-100 w-100">
                        <button class="btn">View Details <i class="bi bi-arrow-right"></i></button>
                    </div>
                    <img src="image/Plantation-and-Afforestation-programme-1.png"
                        class="card-img-top w-100" alt="...">

                </div>

                <div class="card-body">
                    <h5 class="card-title">Education Supplies for Every Pair of Shoes Sold</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                        of the
                        card's content.</p>
                    <div class="d-flex align-items-center gap-2">
                        <div><img class="profileImage" src="image/volunteer2.png" alt="" srcset=""></div>
                        <div>Ben Stokes</div>
                    </div>
                </div>
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
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
    integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="js/sidebarJs.js"></script>
    <script src="js/add_navbar.js"></script>
</body>

</html>