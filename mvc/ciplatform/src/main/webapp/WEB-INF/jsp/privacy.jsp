<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Privacy Policy</title>
    <link rel="stylesheet" href="css/privacy.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>

<body>
    <jsp:include page="fheader.jsp"></jsp:include>
    <div class="container headingTagDiv">
        <p class="headingOfPAge">Privacy Policy</p>
    </div>
    <div class="container">

        <div class="row">
            <div class="col-xs-12 col-sm-3 d-flex flex-column">
                <div id="list-example" class="list-group listItemTab">
                <c:forEach items="${cms}" var="a">
                	<button class=" btn list-group-item list-group-item-action activeComponent">
                        <a href="#${a.slug}">${a.title}</a>
                        <img src="image/right-arrow1.png" alt="" srcset="">
                    </button>
                </c:forEach>
                    
                </div>



            </div>
            <div class="col-xs-12 col-sm-9">

                <div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example">
                    <c:forEach items="${cms}" var="a">
                    <p class="listItemTitle" id="${a.slug}">${a.title}</p>
                    <p>
                        ${a.description}
                    </p>
					</c:forEach>
                    
                </div>
            </div>
        </div>

    </div>
	<jsp:include page="footer.jsp"></jsp:include>


    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="js/addActiveClass.js"></script>
</body>

</html>