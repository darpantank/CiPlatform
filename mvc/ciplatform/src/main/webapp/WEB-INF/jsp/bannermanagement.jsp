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
    <title>skill Page</title>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"></c:url>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/rowreorder/1.3.2/css/rowReorder.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <link rel="stylesheet" href="<c:url value="/css/userpageAdmin.css"></c:url>">
    <style>
        #banner {
            background-color: white;
            color: #F88634;
        }
        .imageOfBanner{
        width:150px;
        height:100px;}
    </style>
</head>

<body>
    <jsp:include page="spinner.jsp" />
    <div class="container-fluid g-0">
        <div class="row flex-nowrap g-0">
            <div class="col-auto col-md-3 col-xl-2 MySidebar g-0">
                <!-- For Fetching Sidebar  -->
                <jsp:include page="adminsidebar.jsp"></jsp:include>
            </div>
            <div class="col g-0">
                <div class="myTopHeadbar w-100">
                    <!-- Fetching Top Header  -->
                    <jsp:include page="adminheader.jsp"></jsp:include>
                </div>
                <div class="container">
                    <div class="UserTextDiv mt-4">
                        <div class="d-flex">
                            <p class="userText">Skill Page</p>
                        </div>
                        <hr>
                    </div>

                    <div class="d-flex justify-content-between mt-4">
                        <div class="d-flex justify-content-center align-items-center border">
                            <img src="<c:url value="/image/search.png"></c:url>" alt="" srcset="">
                            <input type="text" class="ps-2" id="searchFilter" placeholder="Search">
                        </div>
                        <div>
                            <a class="btn AddButton d-flex flex-nowrap" href="addbanner"><i class="bi bi-plus"></i>
                                <span>Add</span></a>
                        </div>
                    </div>

                    <div class="tableDiv mt-4">
                        <table id="example" class="display nowrap" style="width:100%">
                            <thead>
                                <tr class="mt-1 mb-1">
                                    <th>Banner Text</th>
                                    <th>Image</th>
                                    <th>Sort Order</th>
                                    <th>Action</th>
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
    <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script>
    let incomingData='';
    var t;
    $(document).ready(function() {
        t = $('#example').DataTable( {
            rowReorder: {
                selector: 'td:nth-child(2)'
            },
            responsive: true
        } );
        $('#searchFilter').on( 'keyup', function () {
       t.search( this.value ).draw();
    } );
        fetchBannerList();
    } );
    function fetchBannerList(){
    	$.ajax({
	        url: "fetchbanners",
	        dataType: 'json',
	        type:"GET",
	        success: function(response){
	        	incomingData=response;
	        	printDataintoRow();
	        }
	    });
    }
    function printDataintoRow(){
    	t.clear().draw();
    	for(var a in incomingData){ 
    		banner=incomingData[a];
    		let imgTags=`<a href="editbanner?banner_id=`+banner.bannerId+`"><img src="<c:url value="/image/editing.png"></c:url>" alt="" srcset=""></a>
    		<a><img src="<c:url value="/image/delete.png"></c:url>" id="`+banner.bannerId+`" alt="" srcset="" class="delteThisRow"></a>`;
    		let image=`<img src="../`+banner.image+`" class="imageOfBanner">`;
    		t.row.add( [
    		banner.text,
    		image,
    		banner.sortBy,
    		imgTags
        ] ).draw( false );
    	}
    	$(".delteThisRow").click(function(){
          	 deleteSkill($(this).attr("id"));
           });
    }
    
    function deleteSkill(bannerId){
    	swal({
	        title: "Are you sure?",
	        text: "You will not be able to recover Banner!",
	        type: "warning",
	        showCancelButton: true,
	        confirmButtonColor: "#DD6B55",
	        confirmButtonText: "Yes, delete it!",
	        closeOnConfirm: false
	    }, function (isConfirm) {
	        if (!isConfirm) return;
	        $.ajax({
	            url: "deletebanner",
	            type: "GET",
	            data: {
	                'bannerId':bannerId 
	            },
	            dataType: "JSON",
	            success: function () {
	                swal("Done!", "It was succesfully deleted!", "success");
	                fetchBannerList();
	            },
	            error: function (xhr, ajaxOptions, thrownError) {
	                swal("Error deleting!", "Please try again", "error");
	            }
	        });
	    });
    }
    </script>
	<script src="<c:url value="/js/spinner.js"></c:url>"></script>
</body>

</html>