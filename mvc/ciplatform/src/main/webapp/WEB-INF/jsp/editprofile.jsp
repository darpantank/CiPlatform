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
    <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
	<style type="text/css">
    	body{
    	min-height:100vh;
    	display:flex;
    	flex-direction:column;}
    </style>
</head>

<body>
<jsp:include page="spinner.jsp" />
    <!-- Modal For Change PassWord  -->
    <div class="modal fade" id="ModalForPassWordChange" tabindex="-1" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Change Password </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                        <div class="form-group mb-3">
                            <label class="form-label">Enter old password <strong>*</strong></label>
                            <input type="password" class="form-control oldPassWord" name="oldPassWord"
                                placeholder="Enter Your Old PassWord">
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Enter New Password <strong>*</strong></label>
                            <input type="password" class="form-control newPassWord" name="newPassWord"
                                placeholder="Enter Your New Password">
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Enter Confirm Password <strong>*</strong></label>
                            <input type="password" class="form-control confirmNewPassWord" name="confirmNewPassWord"
                                placeholder="Enter Your New Password">
                        </div>
                        <div class="resetPasswordMessage"></div>
                        <div class="d-flex mt-3 justify-content-end buttonsOfModal">
                            <button class="btn roundButton" data-bs-dismiss="modal" aria-label="Close">Cancel</button>
                            <button class="btn roundButton orangeButton resetMyPassword">Save</button>
                        </div>
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
                    <img src="${user.avatar }" class="profilePic" alt="Volunteer" srcset="">
                </c:when>
                <c:otherwise>
                	<img src="image/user1.png" class="profilePic" alt="Volunteer" srcset="">
                </c:otherwise>
                </c:choose>
                
                    <p class="nameOfuser">
                        ${user.firstName} ${user.lastName}
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
                    <form id="myForm" method="post">
                    <div class="InputFields row">
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Name <strong>*</strong></label>
                            <input type="text" class="form-control firstName" name="firstName" value="${user.firstName }" placeholder="Enter Your Name">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Surname <strong>*</strong></label>
                            <input type="text" class="form-control lastName" name="lastName" value="${user.lastName }" placeholder="Enter Your Surname">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Employee Id</label>
                            <input type="text" class="form-control" name="employeeId"
                                placeholder="Enter Your Employee Id" value="${user.employeeId }">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Manager</label>
                            <input type="text" class="form-control" name="manager" placeholder="Enter Your Manager">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Title</label>
                            <input type="text" class="form-control" name="title" value="${user.title }" placeholder="Enter Your Title">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Department</label>
                            <input type="text" class="form-control" name="department"
                                placeholder="Enter Your Department" value="${user.department}">
                        </div>
                        <div class="form-group col-12">
                            <label class="form-label">My Profile</label>
                            <textarea class="form-control" name="myProfile" placeholder="Enter Your comment ..." id="floatingTextarea2"
                                style="height: 100px">${user.profileText}</textarea>
                        </div>
                        <div class="form-group col-12">
                            <label class="form-label">Why I Volunteer ?</label>
                            <textarea class="form-control" name="whyIVolunteer" placeholder="Enter Your comment ..." id="floatingTextarea3"
                                style="height: 100px">${user.whyIVolunteer}</textarea>
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
                            <select class="form-select" name="countryId" id="userCountry" aria-label="Select your Country">
                                <option disabled selected hidden>Select your Country</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">City</label>
                            <select class="form-select userCity" name="cityId" aria-label="Select your City">
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
                            <select class="form-select" name="availability" id="userAvailability" aria-label="Select your Country">
                                <option disabled selected hidden>Select your Availability</option>
                                <option value="DAILY">DAILY</option>
                                <option value="WEEKLY">WEEKLY</option>
                                <option value="WEEKEND">WEEKEND</option>
                                <option value="MONTHLY">MONTHLY</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">LinkedIn</label>
                            <input type="text" class="form-control" value="${user.linkedInUrl }" name="linkedIn" placeholder="Enter Your LinkedIn">
                        </div>
                    </div>
                    <div class="d-flex basicInfoTag mt-4">
                        <p class="basicInfoTagText">
                            My Skills
                        </p>
                    </div>
                    <div class="form-group col-12">
                        <div class="textAreaofsKILLS mt-4">
                            <select class="mainSkillBox" name="skills" multiple="multiple" id="lstBoxMain">
<!--                                	Skill Add Here Which you want to Save -->
							<c:forEach var="a" items="${user.userSkills}">
								<option name="${a.skill.skillName}" value="${a.skill.skillId}"> ${a.skill.skillName}<br></option>
							</c:forEach>
                            </select>
                        </div>
                        
                        <div class="d-flex mt-3">
                            <button class="btn roundButton" data-bs-toggle="modal"
                                data-bs-target="#ModalForAddSkills" id="AddSkills">Add Skills</button>
                        </div>
                    </div>
                    <input type="file" accept="image/*" name="avatar"  class="profilePictureInput" hidden>
                    </form>
                    <div class="d-flex mt-3 justify-content-end">
                        <button class="btn roundButton orangeButton submitButton">Save</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="container-fluid g-0 bg-light z-index-1111 position-sticky bottom-0 start-0" style="z-index:1111">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
        <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script src="js/add_skill.js"></script>
    
    <script>
    let country=[];
    let city=[];
    let skills=[];
    let countryOfUser="<c:out value='${user.country.countryId}' />";
    let cityOfUser="<c:out value='${user.city.cityId}' />";
    let userSkillsObject="";
    let userSkills=[];
    $(document).ready(function(){
    	$.ajax({
            url: "loadListOfCountry",
            dataType: 'json',
            success: function(response){
            	country=response;
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
    $("#myForm").submit(function(e){
    	  e.preventDefault();
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
 				data+='<option selected value="'+country[i].countryId+'" name="'+country[i].name+'">'+country[i].name+'</option>';
 			}
 			else{ 				
 			data+='<option value="'+country[i].countryId+'" name="'+country[i].name+'"> '+country[i].name+'</option>';
 			}
 		}
 		$("#userCountry").append(data);
 		if(countryOfUser!=''){     			
 			$('#userCountry option[value=' + countryOfUser + ']').attr('selected', true);
 			getCityList();
 		}
 		
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
	 			data+='<option type="checkbox" selected name="'+city[i].name+'" value="'+city[i].cityId+'"/> '+city[i].name+'<br>';
 			}
 			else{
 				data+='<option type="checkbox" name="'+city[i].name+'" value="'+city[i].cityId+'"/> '+city[i].name+'<br>';
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
	function addSkillList(){
 		$("#lstBox1").empty();
 		var data="";
 		let status=0;
 		for(var i in skills){
 			status=1;
 			data+='<option name="'+skills[i].skillName+'" value="'+skills[i].skillId+'"/> '+skills[i].skillName+'<br>';
 		}
 		if(status==0){
 			data+="No City Found";
 		}
 		$("#lstBox1").append(data);
 	}
	$(".profilePic").click(function(){		
		$(".profilePictureInput").click();
		
	});
	$(".profilePictureInput").change(function() {
        swal("Notes","Save Form to Change Profile Picture","info");
        profileImage=$('.profilePictureInput').prop('files')[0];
        
        var reader  = new FileReader();
        // it's onload event and you forgot (parameters)
        reader.onload = function(e)  {
            var image = document.createElement("img");
            // the result image data
            $(".profilePic").remove();
            image.className = 'profilePic';
            image.src = e.target.result;
            document.body.appendChild(image);
            $(".profileEditTag").prepend(image);
         }
         // you have to declare the file loading
         reader.readAsDataURL(profileImage);
    });
	$(".submitButton").click(function(){
		if($(".firstName").val()==''||$(".lastName").val()==''){
			swal("Please Read Instructions","FirstName and Last Name is Compulsory Fields","warning");
		}
		else{			
			var formData = new FormData(document.querySelector('form'));
			userSkills=[];
			$.each($(".mainSkillBox option"), function(){
				userSkills.push($(this).val());            
	        });
			formData.append("skills", userSkills);
			
	// 		Ajax call to Save Data
			updateUserProfile(formData);
		}
	});
	$(".resetMyPassword").click(function(){
		$(".resetPasswordMessage").empty();
		oldPassWord=$(".oldPassWord").val();
		newPassWord=$(".newPassWord").val();
		confirmNewPassWord=$(".confirmNewPassWord").val();
		if(confirmNewPassWord==''||newPassWord==''||oldPassWord==''){
			$(".resetPasswordMessage").append("<p class='text-danger'>Some Field is Empty</p>");
		}
		else if(confirmNewPassWord!=newPassWord){
			$(".resetPasswordMessage").append("<p class='text-danger'>Confirm Password and password not Matched!</p>");
		}
		else if(confirmNewPassWord==oldPassWord){
			$(".resetPasswordMessage").append("<p class='text-primary'>New Password and Old password Matched!</p>");
		}
		else if(confirmNewPassWord.length<8){
			$(".resetPasswordMessage").append("<p class='text-info'>New Password Must be 8 digit</p>");
		}
		else{
			data={
					oldPassWord:oldPassWord,
					newPassWord:newPassWord,
					confirmNewPassWord:confirmNewPassWord
			}
			ChangePassWord(data);
		}
	}); 
	function ChangePassWord(data){
		$(".resetPasswordMessage").empty();
		$.ajax({
            url: "changeMyPassword",
            data:data,
            type:"POST",
            success: function(response){
            	if(response=="success"){
            		$(".resetPasswordMessage").append("<p class='text-success'>Password Updated Successfully</p>");
            		
            	}
            	else if(response=="servererror"){
            		$(".resetPasswordMessage").append("<p class='text-danger'>Something Went Wrong!</p>");
            	}
            	else if(response=="passwordcriterianotmatched"){
            		$(".resetPasswordMessage").append("<p class='text-danger'>Password Criteria Not Matched (New Password Not should 8digit or Not same with confirm password)!</p>");
            	}
            	else if(response=="oldpassnotmatched"){
            		$(".resetPasswordMessage").append("<p class='text-warning'>Old Password Not Matched With our Record</p>");
            	}
            	else{
            		$(".resetPasswordMessage").append("<p class='text-danger'>Something Went Wrong!</p>");
            	}
            	resetPasswordForm();
            }
        });
	}
	function resetPasswordForm(){
		$(".oldPassWord").val('');
		$(".newPassWord").val('');
		$(".confirmNewPassWord").val('');
	}
	function updateUserProfile(formData){
		$.ajax({
            url: "editprofile",
            data:formData,
            type:"POST",
            contentType: false,
            processData: false,
            success: function(response){
           	 	if(response){
           	 		swal("Thank You","Profile Updated Successfully","success");
           	 		location.reload();
           	 	}
           	 	else{
           	 		swal("Sorry","Profile Not Updated","warning");
           	 	}
            }
        });
	}
    </script>
	<script src="js/spinner.js"></script>
</body>

</html>