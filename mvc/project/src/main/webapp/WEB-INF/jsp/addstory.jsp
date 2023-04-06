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

</html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add/Edit Story</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/addStory.css">
    <link rel="stylesheet" href="css/upload_drag_drop.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>

<body>
<div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container">
        <p class="titleOfStory">
            Share Your Story
        </p>
        <div class="row mt-5">
            <div class="col-md-12 col-lg-4">
                <div class="form-group">
                    <div class="rightArrow"><i class="bi bi-chevron-down"></i></div>
                    <label for="storytitle">Select Mission</label>
                    <select class="form-control missionSelect" name="missionSelect" placeholder="Select Your Mission">
                        <option value="" disabled selected hidden>Select Your Mission</option>
                        <c:forEach var="a" items="${missions}">
                        	<option value="${a.missionId }">${a.missionName }</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-12 col-lg-4">
                <div class="form-group">
                    <label for="storytitle">My Story Title</label>
                    <input type="text" class="form-control titleOfTheStory" name="titleOfStory" placeholder="Enter Story Title">
                </div>
            </div>
            <div class="col-md-12 col-lg-4">
                <div class="form-group">
                    <label for="storytitle">Date</label>
                    <input type="date" class="form-control dateOfStory" name="dateOfStory" placeholder="Select Date">
                </div>
            </div>
        </div>
        <div class="ckeditor mt-4">
            <p>My Story</p>
            <div id="editor">Sample CkEditor 1</div>
        </div>
        <div class="videoUrl mt-4">
            <div class="form-group">
                <label for="storytitle">Enter Video URL</label>
                <input type="text" class="form-control videoUrl" name="videoUrl"placeholder="Enter Story Title">
            </div>
        </div>
        <div class="upload__box">
            <p>Upload Your Photos</p>
            <div class="upload__btn-box">
                <label class="upload__btn">
                    <input type="file" multiple="multiple" data-max_length="20" class="upload__inputfile">
                    <i class="bi bi-plus-lg plusIcon"></i>
                    <p class="UploadTextMsg">drag and drop picture and video here</p>
                </label>
            </div>
            <div class="upload__img-wrap mt-3"></div>
        </div>
        <div class="d-flex justify-content-between">
            <div><button class="btn">cancel</button></div>
            <div class="d-flex rightButtons">
                <button class="btn saveButton">Save</button>
                <button class="btn">Submit</button>
            </div>
        </div>
    </div>

	<script>
		var imgArray = [];
	</script>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
        <script src=
        "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
            </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="js/sidebarJs.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
    <script src="js/imageUploader.js"></script>
    <script src="js/ckeditor.js"></script>
    <script src="js/add_navbar.js"></script>
    <script>
    $(".saveButton").click(function(){
    	var title= $(".titleOfTheStory").val();
    	var mission=$(".missionSelect").val();
    	var date=new Date($(".dateOfStory").val());
    	var videoUrl=$(".videoUrl").val();
    	var story=myEditor.getData();
    	if(title!=null&&mission!=null&&date!=null&&story!=null)
    	{
    		let myDataObj ={
        			missionId :mission,
        			title:title,
        			date:date,
        			videoUrl:videoUrl,
        			story:story,
        			imgages: $(".upload__inputfile").prop('files')[0]
        	}
    		console.log(myDataObj);
    		saveMyDateInDb(myDataObj);
    	}
    	else{
    		alert("Some Field is Empty");
    	}
    });
    function saveMyDateInDb(myDataObj){
    	console.log("Function called");
    $.ajax({
        url: "savestory",
        dataType: 'json',
        data:myDataObj,
        type:"POST",
        async: false,
        cache: false,
        contentType: 'multipart/form-data',
        processData: false,
        success: function(response){
        	console.log(response);
        }
	});
    }
    </script>
</body>

</html>