<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/rowreorder/1.3.2/css/rowReorder.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="css/userpageAdmin.css">
    <style>
        #user {
            background-color: white;
            color: #F88634;
        }
    </style>
</head>

<body>
    <!-- Modal For The Delete  -->

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <h5>Confirm Delete</h5>
                    <h4>Are You Sure you want to delete <span id="deleteRowDetail"></span></h5>
                        <div class="d-flex justify-content-center gap-2">
                            <button class="btn myButon" data-bs-dismiss="modal">
                                Cancel
                            </button>
                            <button class="btn myButon orangeButton">
                                Delete
                            </button>
                        </div>
                </div>
            </div>
        </div>
    </div>
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
                <div class="UserTextDiv mt-4">
                    <div class="d-flex">
                        <p class="userText">User</p>
                    </div>
                    <hr>
                </div>

                <div class="d-flex justify-content-between mt-4">
                    <div class="d-flex justify-content-center align-items-center border">
                        <img src="image/search.png" alt="" srcset="">
                        <input type="text" class="" id="searchFilter" placeholder="Search">
                    </div>
                    <div>
                        <button class="btn AddButton d-flex flex-row flex-nowrap"><i class="bi bi-plus"></i><span> Add</span></button>
                    </div>
                </div>

                <div class="tableDiv mt-4">
                    <table id="example" class="display nowrap" style="width:100%">
                        <thead>
                            <tr class="mt-1 mb-1">
                                <th>firstName</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Employee Id</th>
                                <th>Department</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
<!--                         <tbody> -->
                            
<!--                             <tr> -->
<!--                                 <td id="fname">Adam</td> -->
<!--                                 <td>Baldwin</td> -->
<!--                                 <td>adam123@gmail.com</td> -->
<!--                                 <td id="empid">614537</td> -->
<!--                                 <td>HR</td> -->
<!--                                 <td> -->
<!--                                     <p class="activeStatus">Active</p> -->
<!--                                 </td> -->
<!--                                 <td> -->
<!--                                     <img src="image/editing.png" alt="" srcset=""> -->
<!--                                     <img src="image/delete.png" alt="" srcset="" class="delteThisRow" data-bs-toggle="modal" -->
<!--                                     data-bs-target="#exampleModal">  -->
<!--                                 </td> -->
<!--                             </tr> -->
                            


<!--                         </tbody> -->
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
    $(document).ready(function() {
    	$(document).ready(function() {
    		let incomingData='';
    	    $.ajax({
    	        url: "fetchusers",
    	        dataType: 'json',
    	        type:"GET",
    	        success: function(response){
    	        	incomingData=response;
    	        }
    	    });
    	    $('#example').DataTable( {
    	    	"data": JSON.stringify(incomingData) ,
    	        "columns": [
    	          { "data": "lastName" },
    	          { "data": "lastName" },
    	          { "data": "firstName" },
    	          { "data": "lastName" },
    	          { "data": "firstName" },
    	          { "data": "lastName" },
    	          { "data": "lastName" }
    	        ],
    	        rowReorder: {
    	            selector: 'td:nth-child(2)'
    	        },
    	        responsive: true
    	    } );
    	    $('#searchFilter').on( 'keyup', function () {
    	   table.search( this.value ).draw();
    	} );
    	} );
    } );
        $(".activeStatus").click(
            function(){
                if($(this).html().match("Active")){
                    $(this).css("color","red");
                    $(this).html("Deactive");
                    alert($(this).parent().siblings("#empid").html()+" is now Disabled");
                }
                else if($(this).html().match("Deactive")){
                    $(this).css("color","#14C506");
                    $(this).html("Active");
                    alert($(this).parent().siblings("#empid").html()+" is now Active");
                }
            }
        );
        $(".delteThisRow").click(function(){
            var a="#empid";
            var b="#fname";
            a=$(this).parent().siblings(a).html();
            b=$(this).parent().siblings(b).html();
            $("#deleteRowDetail").html(a+"-"+b);
        });
        
    </script>
</body>

</html>