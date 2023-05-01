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
    <title>Volunteering Timesheet</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/timesheet.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
</head>

<body>
	<jsp:include page="spinner.jsp" />
	<script>
		let userId="${user.userId}";
	</script>
    <!-- Modal For Time BAsed Mission  -->
    <div class="modal fade" id="ModalForTimeBased" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Please input below Volunteering Hours</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                <form id="timeBasedMissionForm">
                
                <input id="timesheetIdTimeBased" name="timesheetId" value="0" type="hidden" required>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Mission</label>
                        
                        <select class="form-control SelectedMissionTimeBased" name="missionId" required>
                        	<option value="" disabled selected hidden>Select Mission</option>
                        	<c:forEach var="a" items="${missions }">
                        		<c:if test="${a.missionType=='TIME'}">
                        			<option value="${a.missionId}">${a.missionName}</option>
                        		</c:if>
                        	</c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Date Volunteerd</label>
                        <input type="date" class="form-control dateVolunteerTimeModal" name="dateVolunteered" required>
                    </div>
                    <div class="d-flex row ">

                        <div class="mb-3 col-6">
                            <label for="exampleInputEmail1" class="form-label">Hours</label>
                            <input type="text" class="form-control hoursTimeBased"
                                placeholder="Enter Spent Hour" name="hours" required max="23" min="0"> 
                        </div>
                        <div class="mb-3 col-6">
                            <label for="exampleInputEmail1" class="form-label">Minutes</label>
                            <input type="Minutes" class="form-control minutesTimeBased"
                                placeholder="Enter Spent Minute" name="minutes" required max="59" min="0">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Message</label>
                        <textarea class="form-control" placeholder="Enter Your Message" id="notesTimeBased"
                            style="height: 100px" name="message" required></textarea>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary submitTimeBasedTimeSheet">Save changes</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Modal For Goal BAsed Mission  -->
    <div class="modal fade" id="ModalForGoalBased" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Please input below Volunteering Goal</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form id="goalBasedMissionForm">
                
                <input id="timesheetIdGoalBased" value="0" name="timesheetId" type="hidden" required>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Mission</label>
                        <select class="form-control SelectedMissionGoalBased" name="missionId" required>
                        	<option value="" disabled selected hidden>Select Mission</option>
                        	<c:forEach var="a" items="${missions }">
                        		<c:if test="${a.missionType=='GOAL'}">
                        			<option value="${a.missionId}">${a.missionName}</option>
                        		</c:if>
                        	</c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Actions</label>
                        <input type="number" class="form-control actionGoalBasedModal" name="action" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Date Volunteerd</label>
                        <input type="date" class="form-control dateVolunteerGoalModal" name="dateVolunteered" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Message</label>
                        <textarea class="form-control" placeholder="Enter Your Message" id="notesGoalBased"
                            style="height: 100px" name="message" required></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary submitGoalTimeSheet">Save changes</button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container mt-5" id="mainDiv">
        <p class="headerOfTimeSheet">Volunteering Timesheet</p>
        <div class="row">
            <div class="mainCardBody col-md-12 col-lg-6 mb-3">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title mb-3">Volunteering Hours</h5>
						<div class="d-flex justify-content-end">
							<div class="addTimeSheetButton" data-bs-toggle="modal" data-bs-target="#ModalForTimeBased">Add <i class="bi bi-plus-lg"></i></div>
						</div>
						<table class="table table-borderless w-100 gap-1">
                            <thead>
                                <tr>
                                    <th scope="col">Mission</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Hour</th>
                                    <th scope="col">Minute</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody class="TimeBasedTableBody">
<!--                                 Time Based Timesheets Fetched Here -->
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
            <div class="mainCardBody col-md-12 col-lg-6 mb-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title mb-3">Volunteering Goals</h5>
						<div class="d-flex justify-content-end">
							<div class="addTimeSheetButton" data-bs-toggle="modal" data-bs-target="#ModalForGoalBased">Add <i class="bi bi-plus-lg"></i></div>
						</div>
                        <table class="table table-borderless w-100 gap-1">
							<colgroup>
								<col span="0" style="visibility: collapse">
							</colgroup>
							<thead>
                                <tr>
                                	<th scope="col">MissionId</th>
                                    <th scope="col">Mission</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Action</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody class="GoalBasedTableBody">
<!-- 								Goal Based Mission Fetched Here                                 -->
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>


        </div>
    </div>
    <div class="container-fluid g-0 bg-light z-index-1111 position-fixed bottom-0 start-0" style="z-index:1111">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js" type="text/javascript"></script>
        <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script src="js/fetchMission.js"></script>
    <script src="js/spinner.js"></script>
    <script>		  
    let timesheets='';
    	$( document ).ready(function() {
    		updateTimeSheetsData();
    		$("#timeBasedMissionForm").validate();
    		$("#goalBasedMissionForm").validate();
		});
    	$("#timeBasedMissionForm").submit(function(e){
    				e.preventDefault();
    				if($("#timeBasedMissionForm").valid()){    					
    					var data=$("#timeBasedMissionForm").serialize();
    					saveTimeSheetTimeBased(data);
    				}
    	});
    	$("#goalBasedMissionForm").submit(function(e){
			e.preventDefault();
			if($("#goalBasedMissionForm").valid()){    					
				var data=$("#goalBasedMissionForm").serialize();
				saveTimeSheetGoalBased(data);
			}
		});
    	function printGoalBasedMissionTimeSheet(){
    		$(".GoalBasedTableBody").empty();
    		if(Object.keys(timesheets).length>0){
    			for(var i in timesheets){
    				timesheet=timesheets[i];
    				if(timesheet.missionType=='GOAL'){
//     					dateOfvolunteer=new Date(timesheet.volunteeredDate).toLocaleDateString('en-GB');
    					dateOfvolunteer=new Date(timesheet.volunteeredDate).toISOString().slice(0, 10);
    					let row=`<tr>
    						<input type="hidden" class="timesheetIdGoalBased" value="`+timesheet.timesheetId+`">
    						<input type="hidden" class="missionIdGoalBased" value="`+timesheet.missionId+`">
    						<input type="hidden" class="notesGoalBased" value="`+timesheet.notes+`">
                            <td class="missionnameGoalBased">`+timesheet.missionId+`</td>
                            <td class="missionnameGoalBased">`+timesheet.missionName+`</td>
                            <td class="volunteerDateGoalBased">`+dateOfvolunteer+`</td>
                            <td class="missionActionGoalBased">`+timesheet.action+`</td>
                            <td class="d-flex gap-2">
                                <img src="image/editing.png" alt="" srcset="" data-bs-toggle="modal" data-bs-target="#ModalForGoalBased" class="EditDataGoalBased">
                                <img src="image/delete.png" class="deleteDataGoalBased" alt="" srcset="" >
                            </td>
                        </tr>`;
    					$(".GoalBasedTableBody").append(row);
                        console.log(timesheet);
    				}
    			}
    		}
    		$(".EditDataGoalBased").click(function () {
    			var missionId=$(this).parent().siblings(".missionIdGoalBased").val();
			    $('.SelectedMissionGoalBased option[value="'+missionId+'"]').attr("selected", "selected");
			    $('.SelectedMissionGoalBased').attr('disabled', 'disabled');
			    $("#timesheetIdGoalBased").val($(this).parent().siblings(".timesheetIdGoalBased").val());
			    $(".actionGoalBasedModal").val($(this).parent().siblings(".missionActionGoalBased").html());
			    $(".dateVolunteerGoalModal").val(($(this).parent().siblings(".volunteerDateGoalBased").html()));
			    $("#notesGoalBased").val(($(this).parent().siblings(".notesGoalBased").val()));
    		});
    		$(".deleteDataGoalBased").click(function(){
				var timesheetId=$(this).parent().siblings(".timesheetIdGoalBased").val();
				if(timesheetId==undefined||timesheetId==null||timesheetId==0){
					swal("Not Found");
				}
				else{
					confirmDeleteTimeSheet(timesheetId);
				}
			});
    	}
    	function printTimeBasedMissionTimeSheet(){
    		$(".TimeBasedTableBody").empty();
    		if(Object.keys(timesheets).length>0){
    			for(var i in timesheets){
    				timesheet=timesheets[i];
    				if(timesheet.missionType=='TIME'){
//     					dateOfvolunteer=new Date(timesheet.volunteeredDate).toLocaleDateString('en-GB');
    					dateOfvolunteer=new Date(timesheet.volunteeredDate).toISOString().slice(0, 10);
    					let hours="0";
    					let minutes="0";
    					let timeArr=[];
    					timeArr=timesheet.time;
    					for(let i in timeArr){
    						if(i==0){
    							hours=timeArr[i];
    						}
    						if(i==1){
    							minutes=timeArr[i];
    						}
    					}
//     					console.log(timesheet.time.at[0]);
    					let row=`<tr>
    						<input type="hidden" class="timesheetIdTimeBased" value="`+timesheet.timesheetId+`">
    						<input type="hidden" class="missionIdTimeBased" value="`+timesheet.missionId+`">
    						<input type="hidden" class="notesTimeBased" value="`+timesheet.notes+`">
                            <td class="missionnameTimeBased">`+timesheet.missionName+`</td>
                            <td class="volunteerDateTimeBased">`+dateOfvolunteer+`</td>
                            <td class="hoursVolunteered">`+hours+`</td>
                            <td class="minutesVolunteered">`+minutes+`</td>
                            <td class="d-flex gap-2">
                                <img src="image/editing.png" class="EditDataTimeBased" alt="" srcset="" data-bs-toggle="modal" data-bs-target="#ModalForTimeBased">
                                <img src="image/delete.png" class="deleteDataTimeBased" alt="" srcset="">
                            </td>
                        </tr>`;
                        $(".TimeBasedTableBody").append(row);
                        console.log(timesheet);
    				}
    			}
    			$(".deleteDataTimeBased").click(function(){
    				var timesheetId=$(this).parent().siblings(".timesheetIdTimeBased").val();
    				if(timesheetId==undefined||timesheetId==null||timesheetId==0){
    					console.log("Not Found");
    				}
    				else{
    					confirmDeleteTimeSheet(timesheetId);
    				}
    			});
    			$(".EditDataTimeBased").click(function () {
    				var missionId=$(this).parent().siblings(".missionIdTimeBased").val();
//     			    $("#MissionNameTimeBasedModal").val($(this).parent().siblings(".missionnameTimeBased").val());
    			    $('.SelectedMissionTimeBased option[value="'+missionId+'"]').attr("selected", "selected");
    			    $('.SelectedMissionTimeBased').attr('disabled', 'disabled');
    			    $(".hoursTimeBased").val($(this).parent().siblings(".hoursVolunteered").html());
    			    $(".minutesTimeBased").val($(this).parent().siblings(".minutesVolunteered").html());
    			    $("#timesheetIdTimeBased").val($(this).parent().siblings(".timesheetIdTimeBased").val());
    			    $(".dateVolunteerTimeModal").val(($(this).parent().siblings(".volunteerDateTimeBased").html()));
    			    $("#notesTimeBased").val(($(this).parent().siblings(".notesTimeBased").val()));
    			});
    		}
    	}
    	function saveTimeSheetTimeBased(data){
    		$.ajax({
                url: "savetimebasedsheet",
                data: data,
                dataType : "json",
                type:"POST",
                success: function(response){
                	if(response){         
                		$(".modal .btn-close").click();
                		swal("Thanks","Timesheet Added Successfully","success");
                	}
                	//clean Modal
                	$("#timeBasedMissionForm").trigger("reset");
                	$(".SelectedMissionTimeBased").removeAttr("disabled").removeAttr("selected");
                	$(".dateVolunteerTimeModal").val('');
                	
                	//update the Missions once crud operation performed
                	
                	updateTimeSheetsData();
                }
            });
    	}
    	function saveTimeSheetGoalBased(data){
    		$.ajax({
                url: "savegoalbasedsheet",
                data: data,
                dataType : "json",
                type:"POST",
                success: function(response){
                	if(response){         
                	$(".modal .btn-close").click();
                	swal("Thanks","Timesheet Added Successfully","success");
                	}
                	//clean Modal
                	$("#goalBasedMissionForm").trigger("reset");
                	$(".SelectedMissionGoalBased").removeAttr("disabled").removeAttr("selected");
                	$(".dateVolunteerGoalModal").val('');
                	updateTimeSheetsData();
                }
            });
    	}
//     	$(".submitTimeBasedTimeSheet").click(function(){
//     		console.log($("#timeBasedMissionForm").serialize());
//     	});
    	function updateTimeSheetsData(){
    		$.ajax({
                url: "loadtimesheets",
                dataType : "json",
                type:"GET",
                success: function(response){
                	timesheets=response;
                	printGoalBasedMissionTimeSheet();
                	printTimeBasedMissionTimeSheet();
                }
            });
    	}
    	function confirmDeleteTimeSheet(timesheetId) {
    	    swal({
    	        title: "Are you sure?",
    	        text: "You will not be able to recover timesheet!",
    	        type: "warning",
    	        showCancelButton: true,
    	        confirmButtonColor: "#DD6B55",
    	        confirmButtonText: "Yes, delete it!",
    	        closeOnConfirm: false
    	    }, function (isConfirm) {
    	        if (!isConfirm) return;
    	        $.ajax({
    	            url: "deletetimesheet",
    	            type: "GET",
    	            data: {
    	                'timesheetId':timesheetId 
    	            },
    	            dataType: "JSON",
    	            success: function () {
    	                swal("Done!", "It was succesfully deleted!", "success");
    	                updateTimeSheetsData();
    	            },
    	            error: function (xhr, ajaxOptions, thrownError) {
    	                swal("Error deleting!", "Please try again", "error");
    	            }
    	        });
    	    });
    	}
    	$(".addTimeSheetButton").click(
        		function(){
        			console.log("hello");
        			$("#timeBasedMissionForm").trigger("reset");
                	$(".SelectedMissionTimeBased").removeAttr("disabled").removeAttr("selected");
                	$(".dateVolunteerTimeModal").val('');
                	$("#goalBasedMissionForm").trigger("reset");
                	$(".SelectedMissionGoalBased").removeAttr("disabled").removeAttr("selected");
                	$(".dateVolunteerGoalModal").val('');
                	$("#timesheetIdGoalBased").val('0');
                	$("#timesheetIdTimeBased").val('0');
        	}
        		);
    	
    </script>
    
</body>

</html>