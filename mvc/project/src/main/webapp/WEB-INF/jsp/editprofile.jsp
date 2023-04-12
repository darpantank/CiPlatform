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
    <title>Edit Profile</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/editProfile.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>

<body>
    <!-- Modal For Change PassWord  -->
    <div class="modal fade" id="ModalForPassWordChange" tabindex="-1" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Change Password</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                        <div class="form-group mb-3">
                            <label class="form-label">Enter old password</label>
                            <input type="password" class="form-control" name="oldPassWord"
                                placeholder="Enter Your Old PassWord">
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Enter New Password</label>
                            <input type="password" class="form-control" name="newPassWord"
                                placeholder="Enter Your New Password">
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Enter Confirm Password</label>
                            <input type="password" class="form-control" name="newPassWord1"
                                placeholder="Enter Your New Password">
                        </div>
                        <div class="d-flex mt-3 justify-content-end buttonsOfModal">
                            <button class="btn roundButton">Cancel</button>
                            <button class="btn roundButton orangeButton">Save</button>
                        </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal For Contact Us Page  -->

    <div class="modal fade" id="ModalForContactUs" tabindex="-1" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Contact Us</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="" method="post" id="">
                        <div class="form-group mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" name="oldPassWord"
                                placeholder="Enter Your Old PassWord">
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Email Address</label>
                            <input type="email" class="form-control" name="newPassWord"
                                placeholder="Enter Your New Password">
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Subject</label>
                            <input type="password" class="form-control" name="newPassWord1"
                                placeholder="Enter Your Subject">
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Message</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Enter Your Message" rows="3"></textarea>
                        </div>
                        <div class="d-flex mt-3 justify-content-end buttonsOfModal">
                            <button class="btn AddSkillButton">Cancel</button>
                            <button class="btn AddSkillButton orangeButton">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Add Skill Modal  -->

    <div class="modal fade" id="ModalForAddSkills" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modalDialogForSkills">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add Your Skills</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="TotalItems">
                        <div class="row g-0 d-flex justify-content-center gap-1">
                            <div class="col-xs-11 col-sm-5">
                                <select class="listboxes" multiple="multiple" id='lstBox1'>
<!--                                   	Total Skills Load Here -->
                                </select>
                            </div>
                            <div class="col-xs-11 col-sm-1 leftRightButton d-flex justify-content-center flex-column">
                                <button class="btn" id="btnRight"><img src="image/right-arrow1.png" alt=""
                                        srcset=""></button>
                                <button class="btn" id="btnLeft"><img src="image/left.png" alt="" srcset=""></button>
                            </div>
                            <div class="col-xs-11 col-sm-5">
                                <select class="listboxes" multiple="multiple" id='lstBox2'>

                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="SaveSkills"
                                data-bs-dismiss="modal">Save</button>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-12 col-lg-3">
                <div class="profileEditTag mt-5">
                <c:choose>                
                <c:when test="${not empty user.avatar}">                	
                    <img src="image/${user.avatar }" class="profilePic" alt="Volunteer" srcset="">
                </c:when>
                <c:otherwise>
                	<img src="image/user1.png" class="profilePic" alt="Volunteer" srcset="">
                </c:otherwise>
                </c:choose>
                
                    <p class="nameOfuser">
                        ${user.first_name} ${user.last_name}
                    </p>
                    <button class="btn" data-bs-toggle="modal" data-bs-target="#ModalForPassWordChange">Change
                        Password</button>
                </div>
            </div>
            <div class="col-sm-12 col-md-12 col-lg-9">
                <div class="ProfileEditTag mt-5">
                    <div class="d-flex basicInfoTag">
                        <p class="basicInfoTagText">
                            Basic Information
                        </p>
                    </div>
                    <div class="InputFields row">
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" name="nameOfUser" value="${user.first_name }" placeholder="Enter Your Name">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Surname</label>
                            <input type="text" class="form-control" name="nameOfUser" value="${user.last_name }" placeholder="Enter Your Surname">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Employee Id</label>
                            <input type="text" class="form-control" name="nameOfUser"
                                placeholder="Enter Your Employee Id" value="${user.employee_id }">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Manager</label>
                            <input type="text" class="form-control" name="nameOfUser" placeholder="Enter Your Manager">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Title</label>
                            <input type="text" class="form-control" name="nameOfUser" value="${user.title }" placeholder="Enter Your Title">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Department</label>
                            <input type="text" class="form-control" name="nameOfUser"
                                placeholder="Enter Your Department" value="${user.department}">
                        </div>
                        <div class="form-group col-12">
                            <label class="form-label">My Profile</label>
                            <textarea class="form-control" placeholder="Enter Your comment ..." id="floatingTextarea2"
                                style="height: 100px">${user.profile_text}</textarea>
                        </div>
                        <div class="form-group col-12">
                            <label class="form-label">Why I Volunteer ?</label>
                            <textarea class="form-control" placeholder="Enter Your comment ..." id="floatingTextarea3"
                                style="height: 100px">${user.why_i_volunteer}</textarea>
                        </div>

                    </div>

                    <div class="d-flex basicInfoTag mt-4">
                        <p class="basicInfoTagText">
                            Address Information
                        </p>
                    </div>
                    <div class="InputFields row">
                       
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Country</label>
                            <select class="form-select" id="userCountry" aria-label="Select your Country">
                                <option disabled selected hidden>Select your Country</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">City</label>
                            <select class="form-select userCity" aria-label="Select your City">
                                <option disabled selected hidden>Select your City</option>
                            </select>
                        </div>
                    </div>
                    <div class="d-flex basicInfoTag mt-4">
                        <p class="basicInfoTagText">
                            Professional Information
                        </p>
                    </div>
                    <div class="InputFields row">
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Availability</label>
                            <select class="form-select" id="userAvailability" aria-label="Select your Country">
                                <option disabled selected hidden>Select your Availability</option>
                                <option value="1">Weekly</option>
                                <option value="2">Monthly</option>
                                <option value="3">Yearly</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">LinkedIn</label>
                            <input type="text" class="form-control" name="country" placeholder="Enter Your LinkedIn">
                        </div>
                    </div>
                    <div class="d-flex basicInfoTag mt-4">
                        <p class="basicInfoTagText">
                            My Skills
                        </p>
                    </div>
                    <div class="form-group col-12">
                        <div class="textAreaofsKILLS mt-4">
                            <select class="mainSkillBox" multiple="multiple" id="lstBoxMain">
<!--                                	Skill Add Here Which you want to Save -->
                            </select>
                        </div>
                        <div class="d-flex mt-3">
                            <button class="btn roundButton" data-bs-toggle="modal"
                                data-bs-target="#ModalForAddSkills" id="AddSkills">Add Skills</button>
                        </div>
                    </div>
                    <div class="d-flex mt-3 justify-content-end">
                        <button type="submit" class="btn roundButton orangeButton">Save</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="container-fluid g-0 footer mt-4">
        <div class="container d-flex">
            <div class="privacyPolicyTab">
                <a class="btn">Privacy Policy</a>
            </div>
            <div class="privacyPolicyTab">
                <a class="btn" data-bs-toggle="modal" data-bs-target="#ModalForContactUs">Contact Us</a>
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
    <script src="js/add_navbar.js"></script>
    <script src="js/add_skill.js"></script>
    
    <script>
    let country=[];
    let city=[];
    let skills=[];
    let countryOfUser="<c:out value='${user.country.country_id}' />";
    let cityOfUser="<c:out value='${user.city.city_id}' />";
    let userSkillsObject="";
    $(document).ready(function(){
    	$.ajax({
            url: "loadListOfCountry",
            dataType: 'json',
            success: function(response){
            	country=response;
            	console.log(response);
           	 	addCountryList();
            }
        });
    	$.ajax({
            url: "loadListOfSkill",
            dataType: 'json',
            success: function(response){
           	 skills=response;
           		addSkillList();
            }
        });
    	
    });
    $('#userCountry').on('change', function () {
    	countryOfUser = $(this).find("option:selected").val();
        getCityList();
   });
//     function addUserSkills(){
//     	$(".mainSkillBox").empty();
//     	var data="";
//     	for(var i in userSkills){				
//  			data+='<option value="'+userSkills[i]+'" name="'+skills[userSkills[i]]+'"> '+skills[userSkills[i]]+'</option>';
//  		}
//     	$(".mainSkillBox").append(data);
//     }
    function addCountryList(){
 		var data="";
 		for(var i in country){
 			if(countryOfUser==country[i].country_id){
 				data+='<option selected value="'+country[i].country_id+'" name="'+country[i].name+'">'+country[i].name+'</option>';
 			}
 			else{ 				
 			data+='<option value="'+country[i].country_id+'" name="'+country[i].name+'"> '+country[i].name+'</option>';
 			}
 		}
 		$("#userCountry").append(data);
 	}
    function getCityList(){
 		//get City List
 		$.ajax({
            url: "loadListOfCity",
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
	 			data+='<option type="checkbox" selected name="'+city[i].name+'" value="'+city[i].city_id+'"/> '+city[i].name+'<br>';
 			}
 			else{
 				data+='<option type="checkbox" name="'+city[i].name+'" value="'+city[i].city_id+'"/> '+city[i].name+'<br>';
 			}
 		}
 		if(status==0){
 			data+="No City Found";
 		}
 		$(".userCity").append(data);
 	}
	function addSkillList(){
 		$("#lstBox1").empty();
 		var data="";
 		let status=0;
 		for(var i in skills){
 			status=1;
 			data+='<option name="'+skills[i].skill_name+'" value="'+skills[i].skill_id+'"/> '+skills[i].skill_name+'<br>';
 		}
 		if(status==0){
 			data+="No City Found";
 		}
 		$("#lstBox1").append(data);
 	}
	$('#myForm').submit(function(e) {
		e.preventDefault();
	    // Get all the forms elements and their values in one step
	    var values = $(this).serialize();
	    console.log(values);

	});
    </script>
</body>

</html>