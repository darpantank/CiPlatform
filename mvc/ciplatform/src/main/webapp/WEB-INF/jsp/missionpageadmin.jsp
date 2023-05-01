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
    <link rel="stylesheet" href="<c:url value="/css/userpageAdmin.css"></c:url>">
      
    <style>
        #mission {
            background-color: white;
            color: #F88634;
        }
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
                <c:if test="${message=='loginsuccess'}">	
				<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong>Thanks </strong> Admin Login Successfully... !
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>
					<c:remove var="message"/> 
					</c:if>
                <div class="UserTextDiv mt-4">
                    <div class="d-flex">
                        <p class="userText">User</p>
                    </div>
                    <hr>
                </div>

                <div class="d-flex justify-content-between mt-4">
                    <div class="d-flex justify-content-center align-items-center border">
                        <img src="<c:url value="/image/search.png"></c:url>" alt="" srcset="">
                        <input type="text" class="" id="searchFilter" placeholder="Search">
                    </div>
                    <div>
                        <a class="btn AddButton d-flex flex-row flex-nowrap" href="addmission"><i class="bi bi-plus"></i><span> Add</span></a>
                    </div>
                </div>

                <div class="tableDiv mt-4">
                    <table id="example" class="display nowrap" style="width:100%">
                        <thead>
                            <tr class="mt-1 mb-1">
                                <tr class="mt-1 mb-1">
                                    <th>Mission Title</th>
                                    <th>Mission Type</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>Action</th>
                                </tr>
                            </tr>
                        </thead>
                        <tbody>
                            


                        </tbody>
                    </table>

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
    <script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/rowreorder/1.3.2/js/dataTables.rowReorder.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.4.0/js/dataTables.responsive.min.js"></script>
    <script>
    let incomingData='';
    var t;
    	$(document).ready(function() {
    		
    	    
    	    t=$('#example').DataTable( {
    	        rowReorder: {
    	            selector: 'td:nth-child(2)'
    	        },
    	        responsive: true
    	    } );
    	    
    	    $('#searchFilter').on( 'keyup', function () {
    	   t.search( this.value ).draw();
    		} );
    	    $.ajax({
    	        url: "fetchmissions",
    	        dataType: 'json',
    	        type:"GET",
    	        success: function(response){
    	        	incomingData=response;
    	        	printDataintoRow();
    	        }
    	    });
    	} );
        function printDataintoRow(){
        	t.clear().draw();
        	for(var a in incomingData){ 
        		mission=incomingData[a];
        		let imgTags=`<a href="editmission?missionId=`+mission.missionId+`"><img src="<c:url value="/image/editing.png"></c:url>" alt="" srcset=""></a>`;
        	t.row.add( [
        		mission.missionTitle,
        		mission.missionType,
        		new Date(mission.startDate).toLocaleDateString(),
        		new Date(mission.endDate).toLocaleDateString(),
        		imgTags
            ] ).draw( false );
        	}
        
        }
    </script>
	<script src="<c:url value="/js/spinner.js"></c:url>"></script>
</body>

</html>