         let searchWord="";
         let missions="";
    	 let country="";
    	 let CheckedCountry="";
    	 let CheckedSortBy="";
    	 let CheckedCountryName="";
    	 let cityList="";
    	 let themeList=[];
    	 let skills=[];
    	 var CountryOfUser="";
		 var selectedCity = [];
		 var selectedTheme=[];
		 let selecttedCityString="";
		 let ThemeList="";
		 let AppliedFilterArray=[];
		 let SkillList="";
		 let currentPage=1;
		 let skillFilter=[];
		 let themeFilter=[];
		 let cityFilter=[];
		 $(document).ready(function(){
        	 CountryOfUser=$(".defaultCountry").val();
        	 updateMissionsOnChange();
        	 $.ajax({
                 url: "loadListOfCountry",
                 dataType: 'json',
                 success: function(response){
                	 country=response;
                	 addCountryList(country);
                 }
             });
        	 
        	 $.ajax({
                 url: "loadListOfTheme",
                 dataType: 'json',
                 success: function(response){
                	 ThemeList=response;
                	addThemeList(ThemeList);
                 }
             });
        	 $.ajax({
                 url: "loadListOfSkill",
                 dataType: 'json',
                 success: function(response){
                	 SkillList=response;
                	 addSkillList(SkillList);
                 }
             });

        	 
        	 /* Search Mission Logic */
             $('.search_field').keyup(function(){
				 currentPage=1;
            	 updateMissionsOnChange();
             });
             
             
             $('.countrySelect, .countrySelectSidebar').on('change', function () {
				 currentPage=1;
            	 CheckedCountry = $(this).find("option:selected").val();
            	 CheckedCountryName = $(this).find("option:selected");
                 getCityList(CheckedCountry);
                 updateMissionsOnChange();
            });
             $('.sortBy').on('change', function () {
           	 CheckedSortBy = $(this).find("option:selected").val();
           	 currentPage=1;
             updateMissionsOnChange();
        });
            
             
        });
		 function cityCheckedClickEvent(){
			 selectedCity=[];
			 cityFilter=[];
			 currentPage=1;
			 $('.citySelector input:checked , .citySelectorSidebar input:checked').each(function(){	
		        selectedCity.push($(this).attr('value'));	
		        cityFilter.push($(this).attr('name'));	        		
             });
			 updateMissionsOnChange();
		 }
		 function skillCheckedClickEvent(){
			 skills=[];
			 skillFilter=[];
			 currentPage=1;
			 $('.skillSelector input:checked , .skillSelectorSidebar input:checked').each(function(){	
				 skills.push($(this).attr('value'));	
				 skillFilter.push($(this).attr('name'));	        		
             });
			 updateMissionsOnChange();
		 }
		 function themeCheckedClickEvent(){
			 selectedTheme=[];
			 themeFilter=[];
			 currentPage=1;
			 $('.themeSelector input:checked , .themeSelectorSidebar input:checked').each(function(){
        		selectedTheme.push($(this).attr('value'));
        		themeFilter.push($(this).attr('name'));
             });
			 updateMissionsOnChange();
        	 
		 }
/* 		 function cityListOfChecked(selectedCity){
	       		selecttedCityString=JSON.stringify(selectedCity);
	       		updateMissionsOnChange();     			
	       	}  */	
	       	function addCityList(cityList){
	     		$(".citySelector").empty();
	     		$(".citySelectorSidebar").empty();
	     		var data="";
	     		let status=0;
	     		for(var i in cityList){
	     			status=1;
	     			data+='<input type="checkbox" onChange="cityCheckedClickEvent()" name="'+cityList[i].name+'" value="'+cityList[i].cityId+'"/> '+cityList[i].name+'<br>';
	     		}
	     		if(status==0){
	     			data+="No City Found";
	     		}
	     		$(".citySelector").append(data);
	      		$(".citySelectorSidebar").append(data);
	     	}
	       	function addThemeList(ThemeList){
	     		$(".themeSelector").empty();
	     		$(".themeSelectorSidebar").empty();
	     		var data="";
	     		let status=0;
	     		for(var i in ThemeList){
	     			status=1;
	     			data+='<input type="checkbox" onChange="themeCheckedClickEvent()" name="'+ThemeList[i].title+'" value="'+ThemeList[i].missionThemeId+'"/> '+ThemeList[i].title+'<br>';
	     		}
	     		if(status==0){
	     			data+="No Theme Found";
	     		}
	     		$(".themeSelector").append(data);
	      		$(".themeSelectorSidebar").append(data);
	     	}
	       	function addSkillList(SkillList){
	     		$(".skillSelector").empty();
	     		$(".skillSelectorSidebar").empty();
	     		var data="";
	     		let status=0;
	     		for(var i in SkillList){
	     			status=1;
	     			data+='<input type="checkbox" onChange="skillCheckedClickEvent()" name="'+SkillList[i].skillName+'" value="'+SkillList[i].skillId+'"/> '+SkillList[i].skillName+'<br>';
	     		}
	     		if(status==0){
	     			data+="No Skill Found";
	     		}
	     		$(".skillSelector").append(data);
	      		$(".skillSelectorSidebar").append(data);
	       	}
	         function  updateMissionsOnChange(){
	        	 let searchWord=$('.search_field').val();
	        	 FilterObject={
	    				 keyword :searchWord ,
	    				 country_id : CheckedCountry,
	    				 cities: selectedCity,
	    				 themes: selectedTheme,
	    				 skills: skills,
	    				 currentPage: currentPage,
	    				 sortBy : CheckedSortBy
	    		 }
	             $.ajax({
	                 url: "searchMission",
	                 type: "POST",
	                 data:	{'FilterObject': JSON.stringify(FilterObject)},
	                 dataType: 'json',
	                 success: function(response){
	                	const obj=response;
						for(var b in obj){
							var a=b;
							missions=obj[b];
						}        		
						createPaginationList(a,currentPage);
						editUpdatedMission(a);
	                	printCardOnGrid(missions);
	                	printCardOnList(missions);
	                	addFiltersPill();
	                	if(a==0){
	                		if($(".noMissionFound").length===0){
	                			noMissionFound();
	                		}
	                	}
	                	else{
	                		$(".noMissionFound").remove();
	                	}
	                 }
	             });   
	         }
	         	function addFiltersPill(){
					 
					 $("#myList").empty();
					 if(CheckedCountryName[0]!=null){						
						addFilter(CheckedCountryName[0].innerText);		
						}
					 for(var a in cityFilter){
						 addFilter(cityFilter[a]);
					 }
					 for(var a in themeFilter){
						 addFilter(themeFilter[a]);
					 }
					 for(var a in skillFilter){
						 addFilter(skillFilter[a]);
					 }
					 $("#myList").append("<div class='col d-flex align-items-center justify-content-between clearAllFilter'><p>Clear all</p></div>");
					 $(".clearAllFilter").click(function(){
						 clearAllFilter();
					 });
				 }
				 
	         	function getCityList(CheckedCountry){
	         		//get City List
	         		$.ajax({
	                    url: "loadListOfCity",
	                    dataType: 'json',
	                    data:{countryId: CheckedCountry},
	                    type:"POST",
	                    success: function(response){
	                   	 cityList=response;
	                   	 console.log(response);
	                   	addCityList(cityList);
	                    }
	                });
	         	}
	         	
	         	function editUpdatedMission(a){
	         		$("#noOfMission").html(a);
	         	}
	         	function noMissionFound(){
	         		$(".gridListView").append('<h1 class="noMissionFound">No Mission Found</h1>');
	         		$(".pagination").empty();
	         	}
	         	function addCountryList(country){
	         		var data="";
	         		for(var i in country){
	         			if(CountryOfUser==country[i].countryId){
	         			}
	         			data+='<option value="'+country[i].countryId+'" name="'+country[i].name+'"> '+country[i].name+'</option>';
	         		}
	         		$(".countrySelect").append(data);
	         		$(".countrySelectSidebar").append(data);
	         	}
	         	function changeMyPage(b){
	         		currentPage=b;
	         		updateMissionsOnChange();
	         	}
//				
				function clearAllFilter(){
						$('.themeSelector input , .themeSelectorSidebar input').prop('checked', false);
	    				 selectedTheme=[];
	    				 themeFilter=[];
	    				 
	    				 $('.skillSelector input , .skillSelectorSidebar input').prop('checked', false);
	    				 skills=[];
	    				 skillFilter=[];
	    				 
	    				  $('.citySelector input , .citySelectorSidebar input').prop('checked', false);
	    				 selectedCity=[];
	    				 cityFilter=[];
	    				 
	    				 searchWord='';
	    				 
	    				 CheckedCountry='';
	    				 $(".countrySelect option[value='country']").prop('selected',true);
	    				 CheckedCountryName='';
	    				 
	    				 currentPage=1;
	    				 CheckedSortBy=0;
	    				 updateMissionsOnChange();
				}
	         	function createPaginationList(totalCount,currentPage){
	         		$(".pagination").empty();
	         		let data = `<li class="page-item goAtFirst">
					                 <a class="page-link" aria-label="Next">
					                  <span aria-hidden="true"><i class="bi bi-chevron-double-left"></i></span>
					                 </a>
					             </li>
					              <li class="page-item previousPagination">
					                <a class="page-link" aria-label="Next">
					                    <span aria-hidden="true"><i class="bi bi-chevron-left"></i></span>
					                </a>
					              </li>`;
	              let perPageMission=9;
	              let totalPages=totalCount/perPageMission;
	              totalPages=Math.ceil(totalPages);
	              for(var a=1;a<=totalPages;a++){
	            	  	if(a==currentPage)
	            		{	            		  
	            	  		data+=`<li class="page-item active"><a class="page-link" onclick="changeMyPage(`+a+`)">`+a+`</a></li>`;
	            		}
	            	  	else{
	            	  		data+=`<li class="page-item"><a class="page-link" onclick="changeMyPage(`+a+`)">`+a+`</a></li>`;
	            	  	}
	              }
	              data+=`<li class="page-item NextPagination">
	                <a class="page-link" aria-label="Next">
	                  <span aria-hidden="true"><i class="bi bi-chevron-right"></i></span>
	                </a>
	              </li>
	              <li class="page-item goAtLast">
	                <a class="page-link" aria-label="Next">
	                    <span aria-hidden="true"><i class="bi bi-chevron-double-right"></i></span>
	                  </a>
	              </li>`;
	              $(".pagination").append(data);
	              $(".active>.page-link").css("background-color","#F88634");
	              $(".goAtLast").click(function(){
					  if(currentPage==totalPages){
						  swal("Sorry !","You are On Last Page already!","info");
					  }
					  else{						  
					  	changeMyPage(totalPages);
					  }
				  });
				  $(".goAtFirst").click(function(){
					  if(currentPage==1)
					  {						  
					  	swal("Sorry !","You are On First Page already!","info");
					  }
					  else{					  
					  changeMyPage(1);
					  }
				  });
					  $(".NextPagination").click(function() {
						  if(currentPage<totalPages)
						  {
							  changeMyPage(++currentPage);
						  }
						  else{
							  swal("Sorry !","You are On Last Page Already!","info");
						  }
					  });
					  $(".previousPagination").click(function() {
						  if(currentPage>1)
						  {
							  changeMyPage(--currentPage);
						  }
						  else{
							  swal("Sorry !","You are On First Page Already!","info");
						  }
					  });
	         	}
	         	function printCardOnList(missions){
	         		$(".ListViewDisplay").empty();
	         		for(var i in missions){
					let mission=missions[i].mission;
					let isFavourite=missions[i].favourited;
					let ratingCount=Math.ceil(missions[i].rating);
					let image=missions[i].image;
					let isApplied=missions[i].appliedForMission;
					let appliedTag="";
					let seatTag="";
					let timeOrGoalTag='';
					var seatLeft=mission.totalSeat-missions[i].noOfApplicatioin;
					var noOfApplication=missions[i].noOfApplicatioin;
					var goalAchieved=missions[i].goalAchieved;
					var applyTag="";
					
					if(isApplied){
						applyTag=`<a href="getMyMission?mission_id=`+mission.missionId+`" class="applyButtonGridView">View Details <i class="bi bi-arrow-right"></i></a>`;
					}
					else{
						applyTag=`<a href="getMyMission?mission_id=`+mission.missionId+`" class="applyButtonGridView">Apply <i class="bi bi-arrow-right"></i></a>`;
					}
					if(mission.totalSeat!=0){
						seatTag=`<div class="col">
						<div class="row align-items-center">
	                                            <div class="col-auto"><img src="image/Seats-left.png" alt="" srcset=""></div>
	                                            <div class="col">
	                                                <div class="row">`+seatLeft+`</div>
	                                                <div class="row userCount">Seat Left</div>
	                                            </div>
	                                            </div>
	                                        </div>`;
					}
					else{
						seatTag=`<div class="col">
						<div class="row align-items-center">
	                                            <div class="col-auto"><img src="image/Already-volunteered.png" alt="" srcset=""></div>
	                                            <div class="col">
	                                                <div class="row">`+noOfApplication+`</div>
	                                                <div class="row userCount">Aleready Volunteered</div>
	                                            </div>
	                                            </div>
	                                        </div>`;
					}
					timeOrGoalTag=`<div class="col">
									<div class="row align-items-center">
										<div class="col-auto">
											<img src="image/deadline.png" alt="" srcset="">
										</div>
										<div class="col">
											<div class="row">Deadline</div>
											<div class="row">`+new Date(mission.deadline).toLocaleDateString()+`</div>
										</div>
									</div></div>
								`;
								if(mission.missionType=='GOAL'){
									let totalGoal=mission.goalMission.goalValue;
							if(goalAchieved>totalGoal){
								goalAchieved=totalGoal;
								closedTag='<button class="btn btn-danger">closed</button>';
								applyButton=`<a class="applyButtonGridView" disabled>Closed <i
									class="bi bi-arrow-right"></i></a>`;
							}
							let percentageCompleted=Math.round((goalAchieved / totalGoal) * 100);
									timeOrGoalTag=`<div class="col">
									<div class="row align-items-end">
										<div class="col-auto">
											<img src="image/achieved.png" alt="" srcset="">
										</div>
										<div class="col">
											<div class="row">
												<div class="progress p-0" style="height: 10px;">
  													<div class="progress-bar" role="progressbar" style="width: `+percentageCompleted+`%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
											<div class="row">`+goalAchieved+` Achieved</div>
										</div>
									</div>
								</div>`;
								}
					if(isApplied){
						appliedTag='<p class="missionAppliedListView"> Applied</p>';
					}
						if(image==""){
							image="image/noimagefound.png";
						}
						let generatedRatingStar="";
						
						for(var a=1;a<=5;a++){
							if(ratingCount>0){
								generatedRatingStar+=`<div class="col">
											<img src="image/selected-star.png" alt="" srcset="">
										</div>`;
								ratingCount--;
							}
							else{
								generatedRatingStar+=`<div class="col">
											<img src="image/star.png" alt="" srcset="">
										</div>`;
							}
						}
						let LikeTag=`<i class="LikeButtonList bi bi-heart" id="`+mission.missionId+`"></i>`;
						if(isFavourite){
							LikeTag=`<i class="LikeButtonList bi bi-heart-fill" id="`+mission.missionId+`"></i>`;
						}

	         		let list=`<div class="row ListViewCard">
	                    <div class="card">
	                    <div class="row g-0">
	                        <div class="col-md-3 missionImg">
	                            <p class="missionCityListView"><i class="bi bi-geo-alt"></i>`+mission.city.name+`</p>
	                            `+appliedTag+`
	                            <div class="missionLikeListView d-flex flex-column">
	                            	`+LikeTag+`
	                            	<i class="bi bi-person-plus recommandButtonList" data-bs-toggle="modal" data-bs-target="#recommendModal"></i>
	                            </div>
	                            <div class="d-flex justify-content-center missionCategoryListView"><p>`+mission.missionTheme.title+`</p></div>
	                            <img src="`+image+`" class="img-fluid rounded-start" alt="...">
	                        </div>
	                        <div class="col-md-9">
	                            <div class="card-body">
	                                <div class="row w-100 d-flex ">
	                                    <div class="col">
	                                        <div class="row d-flex justify-content-start firstInfoContainerListView">
	                                            <div class="col d-flex gap-1"><i class="bi bi-geo-alt"> </i><p>`+mission.country.name+`</p></div>
	                                            <div class="col d-flex gap-1"><i class="bi bi-globe"> </i><p> `+mission.missionTheme.title+`</p></div>
	                                            <div class="col d-flex gap-1"><i class="bi bi-people"> </i> <p>`+mission.organizationName+`</p></div>
	                                        </div>
	                                    </div>
	                                    <div class="col d-flex justify-content-end">
	                                        <div class="row ratingDivGridView">
	                                            <div class="col">
	                                                <div class="row d-flex flex-row ratingStar flex-nowrap">
	                                                    `+generatedRatingStar+`
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                                <h5 class="card-title">`+mission.title+`</h5>
	                                <p class="card-text">`+mission.shortDescription+`</p>
	                                <div class="row">
	                                    <div class="col">
	                                    	<div class="row">
	                                        `+seatTag+timeOrGoalTag+`
	                                        
	                                        <div class="col">
	                                        	<div class="row align-items-center">
	                                            <div class="col-auto"><img src="image/calender.png" alt="" srcset=""></div>
	                                            <div class="col">
	                                                <div class="row">From`+ new Date(mission.startDate).toLocaleDateString()+` </div>
	                                                <div class="row">Untill `+ new Date(mission.endDate).toLocaleDateString()+`</div>
	                                            </div>
	                                            </div>
	                                        </div>
	                                        </div>
	                                    </div>
	                                    <div class="col-auto d-flex justify-content-end">
											`+applyTag+`	
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                
	            </div>`;
	         			$(".ListViewDisplay").append(list);
	         		}
	         		$(".LikeButtonList").click(function(){
						var missionId=$(this).attr("id");
						let res="";
					 	$.ajax({
	                    url: "addToMyFavourite",
	                    dataType: 'json',
	                    data:{missionId:missionId},
	                    type:"POST",
	                    success: function(response){
							res=JSON.parse(response);
	                    }
	                });
	                if($(this).is(".bi-heart")){						
					$(this).removeClass("bi-heart");
					$(this).addClass("bi-heart-fill LikedMission");
					}
					else{
						$(this).removeClass("bi-heart-fill LikedMission");
						$(this).addClass("bi-heart");
					}
						});
						$(".recommandButtonList").click(function() {
							$("#missionId").attr("value", $(this).siblings(".LikeButtonList").attr("id"));
						});
	         	}
	         	function printCardOnGrid(missions){
	         		$(".GridViewDisplay").empty();
	         		
					for(var i in missions){
						let mission=missions[i].mission;
						let isFavourite=missions[i].favourited;
						let ratingCount=Math.ceil(missions[i].rating);
						let generatedRatingStar="";
						let image=missions[i].image;
						let isApplied=missions[i].appliedForMission;
						let appliedTag="";
						let seatTag="";
						var seatLeft=mission.totalSeat-missions[i].noOfApplicatioin;
						var noOfApplication=missions[i].noOfApplicatioin;
						var goalAchieved=missions[i].goalAchieved;
						let timeOrGoalTag='';
						let dateGoalPills='';
						let closedTag='';
						let applyButton=`<a href="getMyMission?mission_id=`+mission.missionId+`" class="applyButtonGridView">Apply <i
									class="bi bi-arrow-right"></i></a>`;
						
						if(image==""){
							image="image/noimagefound.png";
						}
						if(isApplied){
							appliedTag='<button class="btn btn-success">applied</button>';
							applyButton=`<a href="getMyMission?mission_id=`+mission.missionId+`" class="applyButtonGridView">View Detail <i
									class="bi bi-arrow-right"></i></a>`;
						}
						if(mission.deadline!=null){
							var currentTimeDate=new Date(mission.deadline);
							var deadlineDate=new Date();
							if(deadlineDate>currentTimeDate){
								closedTag='<button class="btn btn-danger">closed</button>';
								applyButton=`<a class="applyButtonGridView" disabled>Closed <i
									class="bi bi-arrow-right"></i></a>`;
							}
						}
						if(mission.missionType=='GOAL'){
							let totalGoal=mission.goalMission.goalValue;
							if(goalAchieved>totalGoal){
								goalAchieved=totalGoal;
								closedTag='<button class="btn btn-danger">closed</button>';
								applyButton=`<a class="applyButtonGridView" disabled>Closed <i
									class="bi bi-arrow-right"></i></a>`;
							}
							let percentageCompleted=Math.round((goalAchieved / totalGoal) * 100);
							timeOrGoalTag=`<div class="col">
									<div class="row align-items-center">
										<div class="col-auto">
											<img src="image/achieved.png" alt="" srcset="">
										</div>
										<div class="col">
											<div class="row">
												<div class="progress p-0" style="height: 10px;">
  													<div class="progress-bar" role="progressbar" style="width: `+percentageCompleted+`%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
											<div class="row">`+goalAchieved+` Achieved</div>
										</div>
									</div>
								</div>`;
								dateGoalPills=`<p>`+mission.goalMission.goalObjectiveText+`</p>`;
						}
						else{
							let deadline="not available";
							if(mission.deadline!=null){
								deadline=new Date(mission.deadline).toLocaleDateString();
							}
							timeOrGoalTag=`<div class="col">
									<div class="row align-items-center">
										<div class="col-auto">
											<img src="image/deadline.png" alt="" srcset="">
										</div>
										<div class="col">
											<div class="row">Deadline</div>
											<div class="row">`+deadline+`</div>
										</div>
									</div>
								</div>`;
								if(mission.startDate==null||mission.endDate==null){									
									dateGoalPills=`<p>Ongoing Oppurtunities</p>`;
								}
								else{
									dateGoalPills=`<p>From `+deadline+` Untill `+new Date(mission.endDate).toLocaleDateString()+`</p>`;
								}
						}
						if(mission.totalSeat!=0){
//							show Seat Left 
							seatTag=`<div class="col">
									<div class="row align-items-center">
										<div class="col-auto">
											<img src="image/Seats-left.png" alt="" srcset="">
										</div>
										<div class="col">
											<div class="row">`+seatLeft+`</div>
											<div class="row volunteeredCount">Seats Left</div>
										</div>
									</div>

								</div>`;
						}
						else{
								seatTag=`<div class="col">
									<div class="row align-items-center">
										<div class="col-auto">
											<img src="image/Already-volunteered.png" alt="" srcset="">
										</div>
										<div class="col">
											<div class="row">`+noOfApplication+`</div>
											<div class="row volunteeredCount">Already Volunteered</div>
										</div>
									</div>

								</div>`;
						}
						for(var a=1;a<=5;a++){
							if(ratingCount>0){
								generatedRatingStar+=`<div class="col">
											<img src="image/selected-star.png" alt="" srcset="">
										</div>`;
								ratingCount--;
							}
							else{
								generatedRatingStar+=`<div class="col">
											<img src="image/star.png" alt="" srcset="">
										</div>`;
							}
						}
						let LikeTag=`<i class="LikeButton bi bi-heart" id="`+mission.missionId+`"></i>`;
						if(isFavourite){
							LikeTag=`<i class="LikeButton bi bi-heart-fill" id="`+mission.missionId+`"></i>`;
						}
						let card=`<div class="card col-lg-4 col-md-6 col-xs-12">
							<div class="d-flex flex-column appliedCloseButtons">
							`+appliedTag+`
							`+closedTag+`
						</div>
						<p class="missionCityGridView">
							<i class="bi bi-geo-alt"></i>`+mission.city.name+`
						</p>
						<div class="missionLikeGridView d-flex flex-column">`+
						LikeTag
						+`
							<i class="bi bi-person-plus recommandButton" data-bs-toggle="modal" data-bs-target="#recommendModal"></i>
						</div>
						<img
							src="`+image+`"
							class="card-img-top missionImgGridView" alt="...">
						<div class="card-body">
							<div class="d-flex justify-content-center missionCategoryDiv">
								<p class="missionCategoryGridView">`+mission.missionTheme.title+`</p>
							</div>
							<h5 class="card-title">`+mission.title+`</h5>
							<p class="card-text">`+mission.shortDescription+`</p>
							<div class="row ratingDivGridView">
								<div class="col">`+mission.organizationName+`</div>
								<div class="col">
									<div class="row d-flex flex-row ratingStar flex-nowrap">
										`+generatedRatingStar+`
									</div>
								</div>
							</div>
							<br>
							<div class="hrLine hrLineOverrided"></div>
							<div class="row missionDatesGridView">
								<div class="col d-flex justify-content-center">
									`+dateGoalPills+`
								</div>
							</div>
							<div class="row">
								`+seatTag+` 
								`+timeOrGoalTag+`
								 
							</div>
							<div class="hrLine"></div>
							<div class="d-flex justify-content-center">
							`+applyButton+`
								
							</div>

						</div>
					</div>`;
						$(".GridViewDisplay").append(card);
					}
					
					$(".LikeButton").click(function(){
						var missionId=$(this).attr("id");
						let res="";
					 	$.ajax({
	                    url: "addToMyFavourite",
	                    dataType: 'json',
	                    data:{missionId:missionId},
	                    type:"POST",
	                    success: function(response){
							res=JSON.parse(response);
	                    }
	                }); 
	                if($(this).is(".bi-heart")){						
					$(this).removeClass("bi-heart");
					$(this).addClass("bi-heart-fill LikedMission");
					}
					else{
						$(this).removeClass("bi-heart-fill LikedMission");
						$(this).addClass("bi-heart");
					}
						});
						$(".recommandButton").click(function() {
							$("#missionId").attr("value", $(this).siblings(".LikeButton").attr("id"));
						});
	         	}