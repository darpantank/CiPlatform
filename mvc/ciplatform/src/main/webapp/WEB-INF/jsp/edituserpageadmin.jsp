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
      <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <style>
        #user {
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
                <div class="UserTextDiv mt-4 mb-4">
                    <div class="d-flex">
                        <p class="userText">Add/Edit User Data</p>
                    </div>
                    <hr>
                </div>
				<div class="userProfileEdit">
					<form id="userEditProfileForm">
					<div class="row">
					<c:choose>
						<c:when test="${not empty selectedUser}">
							<input type="text" name="userId" class="userId" value="${selectedUser.userId}" hidden>
						</c:when>
						<c:otherwise>
							<input type="text" name="userId" class="userId" value="0" hidden>
						</c:otherwise>
					</c:choose>
					
						<div class="form-group col-sm-12 col-md-6">
                            <label class="form-label required">First Name</label>
                            <input type="text" class="form-control firstName" name="firstName" value="${selectedUser.firstName}" placeholder="Enter Your First Name" required>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label required">Last Name</label>
                            <input type="text" class="form-control lastName" name="lastName" value="${selectedUser.lastName}" placeholder="Enter Your Last Name" required>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label required">Email</label>
                            <c:choose>
                            	<c:when test="${not empty selectedUser.email}">
                            		<input type="text" class="form-control email" name="email" value="${selectedUser.email}" placeholder="Enter Your Email" disabled>
                            	</c:when>
                            	<c:otherwise>
                            		<input type="text" class="form-control email" name="email" value="" placeholder="Enter Your Email" required>
                            	</c:otherwise>
                            </c:choose>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label required">Password</label>
                            <input type="text" class="form-control password" minlength="8" name="password" value="${selectedUser.password}" placeholder="Enter Your Password" required>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Employee Id</label>
                            <input type="text" class="form-control employeeId" name="employeeId" value="${selectedUser.employeeId}" placeholder="Enter Your Employee Id">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Department</label>
                            <input type="text" class="form-control department" name="department" value="${selectedUser.department}" placeholder="Enter Your Department">
                        </div>
                        <div class="form-group col-12">
                            <label class="form-label">My Profile</label>
                            <textarea class="form-control profileText" name="profileText" placeholder="Enter Your Profile text ..." id="floatingTextarea2" style="height: 100px">${selectedUser.profileText}</textarea>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label required">Country</label>
                            <select class="form-select" name="countryId" id="userCountry" aria-label="Select your Country" required>
                                <option disabled selected hidden>Select your Country</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label required">City</label>
                            <select class="form-select userCity" name="cityId" aria-label="Select your City" required>
                                <option disabled selected hidden>Select your City</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Status</label>
                            <select class="form-select" name="status" required>
									<option value="ACTIVE" selected="">ACTIVE</option>
									<option value="INACTIVE">INACTIVE</option>
							</select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Avatar</label>
                            <input type="file" name="avatar" class="form-control avatar">
                        </div>
                       </div>
                       <div class="d-flex justify-content-end mt-4">
                    	<button type="submit" class="btn AddButton d-flex flex-row flex-nowrap saveUser"><span>Save User</span></button>
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
    <script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/rowreorder/1.3.2/js/dataTables.rowReorder.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.4.0/js/dataTables.responsive.min.js"></script>
    <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
    <script>
    let country=[];
    let city=[];
    let countryOfUser="<c:out value='${selectedUser.country.countryId}' />";
    let cityOfUser="<c:out value='${selectedUser.city.cityId}' />";
    let incomingData='';
    	$(document).ready(function() {
    		$("#userEditProfileForm").validate();
    		$.ajax({
                url: "../loadListOfCountry",
                dataType: 'json',
                success: function(response){
                	country=response;
               	 	addCountryList();
                }
            });
    		
    		$('label.required').append('&nbsp;<strong>*</strong>&nbsp;');
    		
    	} );
    	$(".saveUser").click(function(e){
    		e.preventDefault();
    		if($("#userEditProfileForm").valid()){
    			var form=document.getElementById("userEditProfileForm");
    			const formData = new FormData(form);
    			$.ajax({
     	            url: "updateuserprofile",
     	            dataType: 'json',
     	            data:formData,
     	           contentType: false,
     	            processData: false,
     	            type:"POST",
     	            success: function(response){
     	            	if(response){
     	            		swal("Thanks","User Profile Update Successfully","success");
                    	//clean Form
                    	$("#userEditProfileForm").trigger("reset");
                    	setTimeout(function () {
                    		window.location.href="users";
                          }, 1000);
     	            	}
     	            },
     	    	});
    		}
    	});
    	function addCountryList(){
     		var data="";
     		for(var i in country){				
     			data+='<option value="'+country[i].countryId+'" name="'+country[i].name+'"> '+country[i].name+'</option>';
     		}
     		$("#userCountry").append(data);
     		if(countryOfUser!=''){     			
     			$('#userCountry option[value=' + countryOfUser + ']').attr('selected', true);
     			getCityList();
     		}
     		
     	}
    	$('#userCountry').on('change', function () {
        	countryOfUser = $(this).find("option:selected").val();
            getCityList();
       });
        function getCityList(){
     		//get City List
     		$.ajax({
                url: "../loadListOfCity",
                dataType: 'json',
                data:{countryId: countryOfUser},
                type:"POST",
                success: function(response){
               	 	city=response;      	 	
               		addCityList();
                }
            });
     	}
    	function addCityList(){
     		$(".userCity").empty();
     		var data="";
     		let status=0;
     		for(var i in city){
     			status=1;
     			if(cityOfUser==city[i].city_id){			
    	 			data+='<option name="'+city[i].name+'" value="'+city[i].cityId+'"/> '+city[i].name+'<br>';
     			}
     			else{
     				data+='<option name="'+city[i].name+'" value="'+city[i].cityId+'"/> '+city[i].name+'<br>';
     			}
     		}
     		if(status==0){
     			data+="No City Found";
     		}
     		$(".userCity").append(data);
     		if(cityOfUser!=''){     			
     			$('.userCity option[value=' + cityOfUser + ']').attr('selected', true);
     		}
     	}
    </script>
	<script src="<c:url value="/js/spinner.js"></c:url>"></script>
</body>

</html>