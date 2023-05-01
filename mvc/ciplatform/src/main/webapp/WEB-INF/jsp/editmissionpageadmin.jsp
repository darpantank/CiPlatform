<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Mission</title>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"></c:url>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/rowreorder/1.3.2/css/rowReorder.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="<c:url value="/css/userpageAdmin.css"></c:url>">
      <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <style>
        #mission {
            background-color: white;
            color: #F88634;
        }
    </style>
</head>

<body>
    <jsp:include page="spinner.jsp" />
<fmt:formatDate value="${mission.startDate}" var="startDate" pattern="yyyy-MM-dd"/>
<fmt:formatDate value="${mission.endDate}" var="endDate" pattern="yyyy-MM-dd"/>
<fmt:formatDate value="${mission.deadline}" var="deadline" pattern="yyyy-MM-dd"/>
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
                        <p class="userText">Add/Edit Mission Data</p>
                    </div>
                    <hr>
                </div>
				<div class="userProfileEdit">
					<form id="missionEditForm">
					<div class="row">
					<c:choose>
						<c:when test="${not empty mission}">
							<input type="text" name="missionId" class="missionId" value="${mission.missionId}" hidden>
						</c:when>
						<c:otherwise>
							<input type="text" name="missionId" class="missionId" value="0" hidden>
						</c:otherwise>
					</c:choose>
						<div class="form-group col-sm-12 col-md-12">
                            <label class="form-label">Title</label>
                            <input type="text" class="form-control shortDescription" name="title" value="${mission.title}" placeholder="Enter Mission Short Description" required>
                        </div>
						<div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Short Description</label>
                            <input type="text" class="form-control shortDescription" name="shortDescription" value="${mission.shortDescription}" placeholder="Enter Mission Short Description" required>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Mission Type</label>
                            <select class="form-select missionType" name="missionType" required>
                            		<option disabled selected hidden>Select Mission Type</option>
									<option value="TIME">Time</option>
									<option value="GOAL">Goal</option>
							</select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Country Of Mission</label>
                            <select class="form-select" name="countryId" id="missionCountry" aria-label="Select your Country" required>
                                <option disabled selected hidden>Select your Country</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">City Of Mission</label>
                            <select class="form-select missionCity" name="cityId" aria-label="Select your City" required>
                                <option disabled selected hidden>Select your City</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Organization Name</label>
                            <input type="text" class="form-control organizationName" name="organizationName" value="${mission.organizationName}">
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Organization Details</label>
                            <input type="text" class="form-control organizationDetail" name="organizationDetail" value="${mission.organizationDetail}" >
                        </div>
                        
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Status</label>
                            <select class="form-select status" name="status" required>
									<option value="ACTIVE" selected="">ACTIVE</option>
									<option value="INACTIVE">INACTIVE</option>
							</select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Mission Documents</label>
                            <input type="file" name="missionDocuments" class="form-control missionDocuments" accept=".xlsx,.xls,.doc, .docx,.ppt, .pptx,.txt,.pdf"  multiple>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Start Date</label>
                            <input type="date" value="${startDate}" name="startDate" class="form-control startDate" required>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">End Date</label>
                            <input type="date" value="${endDate}" name="endDate" class="form-control endDate" required>
                        </div>
                        <div class="mb-3">
                        <label for="description" class="form-label">Description</label>
                        <div class="ckeditor">
                            <div id="editor"></div>
                        </div>
                    	</div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Total Seat</label>
                            <c:choose>
                            	<c:when test="${mission.missionType=='TIME'}">                    	
		                            <input type="number" value="${mission.totalSeat}" name="totalSeat" class="form-control totalSeat" required>
                            	</c:when>
                            	<c:otherwise>
                            		<input type="number" value="0" name="totalSeat" class="form-control totalSeat" disabled>
                            	</c:otherwise>
                            </c:choose>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">DeadLine</label>
                            <c:choose>
                            	<c:when test="${mission.missionType=='TIME'}">                    	
		                            <input type="date" value="${deadline}" name="deadline" class="form-control deadline" required>
                            	</c:when>
                            	<c:otherwise>
                            		<input type="date" value="${deadline}" name="deadline" class="form-control deadline" disabled>
                            	</c:otherwise>
                            </c:choose>
                            
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Goal Objective Text</label>
                            <c:choose>
                            	<c:when test="${mission.missionType=='GOAL'}">
                            		<input type="text" value="${mission.goalMission.goalObjectiveText}" name="goalObjectiveText" class="form-control goalObjectiveText">
                            	</c:when>
                            	<c:otherwise>
                            		<input type="text" value="" name="goalObjectiveText" class="form-control goalObjectiveText" disabled>
                            	</c:otherwise>
                            </c:choose>
                            
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Goal Action</label>
                            <c:choose>
                            	<c:when test="${mission.missionType=='GOAL'}">
                            		<input type="number" value="${mission.goalMission.goalValue}" name="goalValue" class="form-control goalValue">
                            	</c:when>
                            	<c:otherwise>
                            		<input type="number" value="0" name="goalValue" class="form-control goalValue" disabled>
                            	</c:otherwise>
                            </c:choose>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Theme Of Mission</label>
                            <select class="form-select" name="themeId" id="missiontheme" aria-label="Select your Theme" required>
                                <option disabled selected hidden>Select your Theme</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Mission Skill</label>
                            <select class="form-select skillsId" name="skillsId" multiple="multiple">
									
							</select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Availability</label>
                            <select class="form-select" name="availability" id="availability" aria-label="Select Mission Availability">
                                <option disabled selected hidden>Select Availability</option>
                                <option value="DAILY">DAILY</option>
                                <option value="WEEKLY">WEEKLY</option>
                                <option value="WEEKEND">WEEKEND</option>
                                <option value="MONTHLY">MONTHLY</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-12 col-md-6">
                            <label class="form-label">Mission Image</label>
                            <input type="file" name="missionImages" class="form-control missionImages" accept="image/*" multiple>
                        </div>
                       </div>
                       <div class="d-flex justify-content-end mt-4">
                    	<button type="submit" class="btn AddButton d-flex flex-row flex-nowrap saveMission"><span>Save Mission</span></button>
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
    <script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
    <script src="<c:url value="/js/ckeditor.js"></c:url>"></script>
    <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
    <script>
    let country=[];
    let city=[];
    let ThemeList=[];
    let SkillList=[];
    let missionSkillList=[];
    let countryOfMission="<c:out value='${mission.country.countryId}' />";
    let cityOfMission="<c:out value='${mission.city.cityId}' />";
    let missionType="<c:out value='${mission.missionType}' />";
    let missionStatus="<c:out value='${mission.status}' />";
    let themeOfMission="<c:out value='${mission.missionTheme.missionThemeId}' />";
    let missionAvailability="<c:out value='${mission.availability}' />";
    let incomingData='';
    	$(document).ready(function() {
    		$("#missionEditForm").validate();
    		var today = new Date();
    		$.ajax({
                url: "../loadListOfCountry",
                dataType: 'json',
                success: function(response){
                	country=response;
               	 	addCountryList();
                }
            });
    		$.ajax({
                url: "../loadListOfTheme",
                dataType: 'json',
                success: function(response){
               	 ThemeList=response;
               	addThemeList();
                }
            });
    		$.ajax({
                url: "../loadListOfSkill",
                dataType: 'json',
                success: function(response){
               	 SkillList=response;
               	 addSkillList();
                }
            });
    		if(missionStatus!=''){
    			$('.status option[value=' + missionStatus + ']').attr('selected', true);
    		}
    		if(missionAvailability!=''){
    			$('#availability option[value=' + missionAvailability + ']').attr('selected', true);
    		}
    		if(missionType!=''){    			
    			$('.missionType option[value=' + missionType + ']').attr('selected', true);   
    			$('.missionType').attr('disabled',true);
    		} 
    	}
    	);
    		    			
    	$(".saveMission").click(function(e){
    		e.preventDefault();
    		if($("#missionEditForm").valid()){
    			var form=document.getElementById("missionEditForm");
    			const formData = new FormData(form);
    			var editorText=myEditor.getData();
    			editorText=editorText.replaceAll('"', '');
    			formData.append("description",editorText);
    			$.ajax({
     	            url: "updatemission",
     	            dataType: 'json',
     	            data:formData,
     	           contentType: false,
     	            processData: false,
     	            type:"POST",
     	            success: function(response){
     	            	if(response){
     	            		swal("Thanks","Mission Update Successfully","success");
                    	//clean Form
                    	$("#missionEditForm").trigger("reset");
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
     		$("#missionCountry").append(data);
     		if(countryOfMission!=''){     			
     			$('#missionCountry option[value=' + countryOfMission + ']').attr('selected', true);
     			getCityList();
     		}
     	}
    	$('#missionCountry').on('change', function () {
    		countryOfMission = $(this).find("option:selected").val();
            getCityList();
       });
    	$(".missionType").on('change', function () {
    		console.log($(this).val());
    		if($(this).val()=='TIME'){
    			$(".totalSeat").attr('disabled',false).attr('required',true);
    			$(".deadline").attr('disabled',false).attr('required',true);
    			$(".goalObjectiveText").attr('disabled',true);
    			$(".goalValue").attr('disabled',true);
    		}
    		if($(this).val()=='GOAL'){
    			$(".totalSeat").attr('disabled',true);
    			$(".deadline").attr('disabled',true);
    			$(".goalObjectiveText").attr('disabled',false).attr('required',true);
    			$(".goalValue").attr('disabled',false).attr('required',true);
    		}
       });
        function getCityList(){
     		//get City List
     		$.ajax({
                url: "../loadListOfCity",
                dataType: 'json',
                data:{countryId: countryOfMission},
                type:"POST",
                success: function(response){
               	 	city=response;      	 	
               		addCityList();
                }
            });
     	}
    	function addCityList(){
     		$(".missionCity").empty();
     		var data="";
     		let status=0;
     		for(var i in city){
     			status=1;
     			data+='<option name="'+city[i].name+'" value="'+city[i].cityId+'"/> '+city[i].name+'<br>';

     		}
     		if(status==0){
     			data+="No City Found";
     		}
     		$(".missionCity").append(data);
     		if(cityOfMission!=''){     			
     			$('.missionCity option[value=' + cityOfMission + ']').attr('selected', true);
     		}
     	}
    	function addThemeList(){
     		$("#missiontheme").empty();
     		var data="";
     		let status=0;
     		for(var i in ThemeList){
     			status=1;
     			data+='<option name="'+ThemeList[i].title+'" value="'+ThemeList[i].missionThemeId+'"> '+ThemeList[i].title+'</option>';
     		}
     		if(status==0){
     			data+="No Theme Found";
     		}
     		$("#missiontheme").append(data);
     		if(themeOfMission!=''){     			
     			$('#missiontheme option[value=' + themeOfMission + ']').attr('selected', true);
     		}
     	}
    	function addSkillList(){
     		$(".skillsId").empty();
     		var data="";
     		let status=0;
     		for(var i in SkillList){
     			status=1;
     			data+='<option name="'+SkillList[i].skillName+'" value="'+SkillList[i].skillId+'"> '+SkillList[i].skillName+'</option>';
     		}
     		if(status==0){
     			data+="No Skill Found";
     		}
     		$(".skillsId").append(data);
     		findSelectedSkills();
     		selectDefaultSkills();
       	}
    	function findSelectedSkills(){
    		<c:forEach var="a" items="${mission.missionSkills}">
        		missionSkillList.push(${a.skills.skillId});
        	</c:forEach>
    	}
    	function selectDefaultSkills(){
    		for(var i in missionSkillList){
     			$('.skillsId option[value='+missionSkillList[i]+']').attr('selected', true);
     		}
    	}
    	<c:if test="${not empty mission}">
     	myEditor.setData('${mission.description }');
     	</c:if> 
    </script>
	<script src="<c:url value="/js/spinner.js"></c:url>"></script>
</body>

</html>