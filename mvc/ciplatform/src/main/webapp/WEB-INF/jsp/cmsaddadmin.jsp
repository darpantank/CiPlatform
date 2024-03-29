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
    <title>Admin</title>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"></c:url>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/rowreorder/1.3.2/css/rowReorder.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.dataTables.min.css">
     <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <link rel="stylesheet" href="<c:url value="/css/userpageAdmin.css"></c:url>">
    <style>
        #cms{
            background-color: white;
            color: #F88634;
        }
    </style>
</head>

<body>
    <!-- Modal For The Delete  -->
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
                        <p class="userText">Add/Edit CMS</p>
                    </div>
                    <hr>
                </div>
                <div class="ckEditorDiv p-4">
                <form id="myCmsAddForm">
                <c:choose>
                <c:when test="${not empty cms}">
     				<input type="text" class="cmsId" name="cmsId" value="${cms.cmsPageId}" hidden>
     			</c:when> 
     			<c:otherwise>
     				<input type="text" class="cmsId" name="cmsId" value="0" hidden>
     			</c:otherwise>
     			</c:choose>
                	
                    <div class="mb-3">
                        <label for="inputPassword5" class="form-label required">Title</label>
                        <input type="text" class="form-control" value="${cms.title }" name="title" required>
                    </div>
                    <div class="mb-3">
                        <label for="inputPassword5" class="form-label required">Description</label>
                        <div class="ckeditor">
                            <div id="editor"></div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="inputPassword5" class="form-label required">Slug</label>
                        <input type="text" class="form-control" value="${cms.slug}" name="slug" required>
                    </div>
                    <div class="mb-3">
                        <label for="inputPassword5" class="form-label required">Status</label> 
                        <select class="form-control" name="status" required>
									<option value="ACTIVE" selected>ACTIVE</option>
									<option value="INACTIVE">INACTIVE</option>
						</select>
							</div>
                    <div class="mb-3 d-flex justify-content-end">
                    	<button class="btn AddButton d-flex flex-row flex-nowrap saveCmsPage"><span> Save CMS</span></button>
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
    <script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
    <script src="<c:url value="/js/ckeditor.js"></c:url>"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
     <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script>
    $(document).ready(function() {
  	  $("#myCmsAddForm").validate();
  		$('label.required').append('&nbsp;<strong>*</strong>&nbsp;');
  	});
    $(".saveCmsPage").click(function(e){
    	e.preventDefault();
    	
    	if($("#myCmsAddForm").valid()){ 
    		const form = document.getElementById("myCmsAddForm");
    		const formData = new FormData(form);
    		formData.append("description",myEditor.getData());
//     		Ajax Call to Save the Data
		$.ajax({
        url: "addcms",
        dataType: 'json',
        data:formData,
        type:"POST",
        contentType: false,
        processData: false,
        success: function(response){
        	    	if(response){
//         	    		put sweet alert
						swal("Thanks","Cms added successfully...","success");
// 						Clear The Form Data
						resetCmsPage();
						setTimeout(function () {
                    		window.location.href="cmspage";
                          }, 1000);
<%-- 						window.location.href = '<%=request.getContextPath()%>/admin/cmspage'; --%>
        	    	}
        }
		});
    	}
    });
    function resetCmsPage(){
    	$('form#myCmsAddForm').trigger("reset");
		myEditor.setData('');
		$(".cmsId").val('0');
    }
     <c:if test="${not empty cms}">
     	myEditor.setData('${cms.description }');
     </c:if> 
     
    </script>
</body>

</html>