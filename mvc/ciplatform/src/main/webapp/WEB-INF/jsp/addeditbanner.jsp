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
    <title>Admin Banner</title>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"></c:url>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/rowreorder/1.3.2/css/rowReorder.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.dataTables.min.css">
     <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <link rel="stylesheet" href="<c:url value="/css/userpageAdmin.css"></c:url>">
    <style>
        #banner{
            background-color: white;
            color: #F88634;
        }
        .demoImage{
        height:250px;
        width:350px;}
        
    </style>
</head>

<body>
    <jsp:include page="spinner.jsp" />
    <div class="container-fluid g-0">
        <div class="row flex-nowrap g-0">
            <div class="col-auto col-md-3 col-xl-2 MySidebar g-0">
                <jsp:include page="adminsidebar.jsp"></jsp:include>
            </div>
            <div class="col g-0">
                <div class="myTopHeadbar w-100">
                    <jsp:include page="adminheader.jsp"></jsp:include>
                </div>
                <div class="container">
               		
               		<div class="UserTextDiv p-4">
                    <div class="d-flex">
                        <p class="userText">Add Banner</p>
                    </div>
                    <hr>
                </div>
                <div class="ckEditorDiv p-4">
                <form id="myBannerAddForm">
                <c:choose>
                <c:when test="${not empty banner}">
     				<input type="text" class="bannerId" name="bannerId" value="${banner.bannerId}" hidden>
     			</c:when> 
     			<c:otherwise>
     				<input type="text" class="bannerId" name="bannerId" value="0" hidden>
     			</c:otherwise>
     			</c:choose>
                	
                    <div class="mb-3">
                        <label for="inputPassword5" class="form-label">Banner Text</label>
                        <input type="text" class="form-control text" value="${banner.text }" name="text" required>
                     </div>
                     <div class="mb-3">
                        <label for="inputPassword5" class="form-label">Banner Sort Order</label>
                        <input type="number" class="form-control text" value="${banner.sortOrder }" name="sortOrder" required>
                     </div>
                     <div class="mb-3">
                        <label for="inputPassword5" class="form-label">Banner Image</label>
                        <c:choose>
                        <c:when test="${not empty banner.image}">
                     		<input type="file" class="form-control image" name="image" accept="image/*">
                     	</c:when>
                     	<c:otherwise>
                     		<input type="file" class="form-control image" name="image" accept="image/*" required>
                     	</c:otherwise>
                        </c:choose>
                     </div>
                     <div class="mb-3 d-flex justify-content-center demoImgDiv">
                     <c:choose>
                     	<c:when test="${not empty banner.image}">
                     		<img src="../${banner.image}" class="demoImage">
                     	</c:when>
                     	<c:otherwise>
                     		<img src="../image/noimagefound.png" class="demoImage">
                     	</c:otherwise>
                     </c:choose>
                        
                     </div>
                     
                    <div class="mb-3 d-flex justify-content-end">
                    	<button class="btn AddButton d-flex flex-row flex-nowrap saveBannerPage"><span> Save Banner</span></button>
                    </div>
                    
                  </form>
                </div>

                

                
                 </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
     <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script>
    $(document).ready(function() {
  	  $("#myBannerAddForm").validate();
  	});
    $(".saveBannerPage").click(function(e){
    	e.preventDefault();
    	
    	if($("#myBannerAddForm").valid()){ 
    		const form = document.getElementById("myBannerAddForm");
    		const formData = new FormData(form);
//     		Ajax Call to Save the Data
		$.ajax({
        url: "addupdatebanner",
        dataType: 'json',
        data:formData,
        type:"POST",
        contentType: false,
        processData: false,
        success: function(response){
        	    	if(response){
//         	    		put sweet alert
						swal("Thanks","Banner added successfully...","success");
// 						Clear The Form Data
						resetBannerPage();
						window.location.href = '<%=request.getContextPath()%>/admin/bannerpage';
        	    	}
        }
		});
    	}
    });
    function resetBannerPage(){
    	$('form#myBannerAddForm').trigger("reset");
		$(".bannerId").val('0');
    }
	$(".image").change(function() {
        bannerImage=$('.image').prop('files')[0];
        
        var reader  = new FileReader();
        // it's onload event and you forgot (parameters)
        reader.onload = function(e)  {
            var image = document.createElement("img");
            // the result image data
            $(".demoImage").remove();
            image.className = 'demoImage';
            image.src = e.target.result;
            document.body.appendChild(image);
            $(".demoImgDiv").append(image);
         }
         // you have to declare the file loading
         reader.readAsDataURL(bannerImage);
    });
     
    </script>
	<script src="<c:url value="/js/spinner.js"></c:url>"></script>
</body>

</html>