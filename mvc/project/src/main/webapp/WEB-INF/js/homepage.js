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
            	 updateMissionsOnChange();
             });
             $('.countrySelect, .countrySelectSidebar').on('change', function () {
				 currentPage=1;
            	 CheckedCountry = $(this).find("option:selected").val();
            	 CheckedCountryName = $(this).find("option:selected");
            	 addFilter(CheckedCountryName[0].innerText);
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
			 currentPage=1;
			 $('.citySelector input:checked , .citySelectorSidebar input:checked').each(function(){	
		        selectedCity.push($(this).attr('value'));		        		
             });
			 updateMissionsOnChange();
		 }
		 function skillCheckedClickEvent(){
			 skills=[];
			 currentPage=1;
			 $('.skillSelector input:checked , .skillSelectorSidebar input:checked').each(function(){	
				 skills.push($(this).attr('value'));		        		
             });
			 updateMissionsOnChange();
		 }
		 function themeCheckedClickEvent(){
			 selectedTheme=[];
			 currentPage=1;
			 $('.themeSelector input:checked , .themeSelectorSidebar input:checked').each(function(){
        		selectedTheme.push($(this).attr('value'));
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
	     			data+='<input type="checkbox" onChange="cityCheckedClickEvent()" name="'+cityList[i].name+'" value="'+cityList[i].city_id+'"/> '+cityList[i].name+'<br>';
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
	     			data+='<input type="checkbox" onChange="themeCheckedClickEvent()" name="'+ThemeList[i].title+'" value="'+ThemeList[i].mission_theme_id+'"/> '+ThemeList[i].title+'<br>';
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
	     			data+='<input type="checkbox" onChange="skillCheckedClickEvent()" name="'+SkillList[i].skill_name+'" value="'+SkillList[i].skill_id+'"/> '+SkillList[i].skill_name+'<br>';
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
						console.log(missions);     		
						createPaginationList(a,currentPage);
						editUpdatedMission(a);
	                	printCardOnGrid(missions);
	                	printCardOnList(missions);
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
	         			if(CountryOfUser==country[i].country_id){
	         			}
	         			data+='<option value="'+country[i].country_id+'" name="'+country[i].name+'"> '+country[i].name+'</option>';
	         		}
	         		$(".countrySelect").append(data);
	         		$(".countrySelectSidebar").append(data);
	         	}
	         	function changeMyPage(b){
	         		currentPage=b;
	         		updateMissionsOnChange();
	         	}

	         	function createPaginationList(totalCount,currentPage){
	         		$(".pagination").empty();
	         		let data = `<li class="page-item">
	                    <a class="page-link" href="#" aria-label="Next">
	                        <span aria-hidden="true"><i class="bi bi-chevron-double-left"></i></span>
	                    </a>
	                  </li>
	              <li class="page-item">
	                <a class="page-link" href="#" aria-label="Next">
	                    <span aria-hidden="true"><i class="bi bi-chevron-left"></i></span>
	                </a>
	              </li>`;
	              let perPageMission=3;
	              let totalPages=totalCount/perPageMission;
	              if(totalCount!=0){
	            	  if(totalPages==0){	            		  
	            	  totalPages=1;
	            	  }
	              }
	              if(totalCount%perPageMission!=0)
	            	  {
	            	  totalPages++;
	            	  }
	            	  
	              for(var a=1;a<=totalPages;a++){
	            	  	if(a==currentPage)
	            		{	            		  
	            	  		data+=`<li class="page-item active"><a class="page-link" onclick="changeMyPage(`+a+`)">`+a+`</a></li>`;
	            		}
	            	  	else{
	            	  		data+=`<li class="page-item"><a class="page-link" onclick="changeMyPage(`+a+`)">`+a+`</a></li>`;
	            	  	}
	              }
	              
	              data+=`<li class="page-item">
	                <a class="page-link" href="#" aria-label="Next">
	                  <span aria-hidden="true"><i class="bi bi-chevron-right"></i></span>
	                </a>
	              </li>
	              <li class="page-item">
	                <a class="page-link" href="#" aria-label="Next">
	                    <span aria-hidden="true"><i class="bi bi-chevron-double-right"></i></span>
	                  </a>
	              </li>`;
	              $(".pagination").append(data);
	         	}
	         	function printCardOnList(missions){
	         		$(".ListViewDisplay").empty();
	         		for(var i in missions){
					let mission=missions[i].mission;
					let isFavourite=missions[i].favourited;
					let ratingCount=Math.ceil(missions[i].rating);
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
						let LikeTag=`<i class="LikeButtonList bi bi-heart" id="`+mission.mission_id+`"></i>`;
						if(isFavourite){
							LikeTag=`<i class="LikeButtonList bi bi-heart-fill" id="`+mission.mission_id+`"></i>`;
						}

	         		let list=`<div class="row ListViewCard">
	                    <div class="card">
	                    <div class="row g-0">
	                        <div class="col-md-3 missionImg">
	                            <p class="missionCityListView"><i class="bi bi-geo-alt"></i>`+mission.city.name+`</p>
	                            <p class="missionAppliedListView"> Applied</p>
	                            <div class="missionLikeListView d-flex flex-column">
	                            	`+LikeTag+`
	                            	<i class="bi bi-person-plus recommandButtonList" data-bs-toggle="modal" data-bs-target="#recommendModal"></i>
	                            </div>
	                            <div class="d-flex justify-content-center missionCategoryListView"><p>`+mission.mission_theme.title+`</p></div>
	                            <img src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png" class="img-fluid rounded-start" alt="...">
	                        </div>
	                        <div class="col-md-9">
	                            <div class="card-body">
	                                <div class="row w-100 d-flex ">
	                                    <div class="col">
	                                        <div class="row d-flex justify-content-start firstInfoContainerListView">
	                                            <div class="col d-flex"><i class="bi bi-geo-alt"> </i><p>`+mission.country.name+`</p></div>
	                                            <div class="col d-flex"><i class="bi bi-globe"> </i><p> `+mission.mission_theme.title+`</p></div>
	                                            <div class="col d-flex"><i class="bi bi-people"> </i> <p>`+mission.organization_name+`</p></div>
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
	                                <p class="card-text">`+mission.short_description+`</p>
	                                <div class="row">
	                                    <div class="col d-flex">
	                                        <div class="col d-flex">
	                                            <div class="col d-flex align-items-center"><img src="image/Seats-left.png" alt="" srcset=""></div>
	                                            <div class="col">
	                                                <div class="row">2</div>
	                                                <div class="row">Seats</div>
	                                            </div>
	                                        </div>
	                                        <div class="col d-flex">
	                                            <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
	                                            <div class="col">
	                                                <div class="row">2</div>
	                                                <div class="row">Seats</div>
	                                            </div>
	                                        </div>
	                                        <div class="col d-flex">
	                                            <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
	                                            <div class="col">
	                                                <div class="row">2</div>
	                                                <div class="row">Seats</div>
	                                            </div>
	                                        </div>
	                                        <div class="col d-flex">
	                                            <div class="col d-flex align-items-center"><img src="image/achieved.png" alt="" srcset=""></div>
	                                            <div class="col">
	                                                <div class="row">2</div>
	                                                <div class="row">Seats</div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="col d-flex justify-content-end">
	                                        <a href="getMyMission?mission_id=`+mission.mission_id+`" class="applyButtonGridView">View Details <i class="bi bi-arrow-right"></i></a>
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
						let LikeTag=`<i class="LikeButton bi bi-heart" id="`+mission.mission_id+`"></i>`;
						if(isFavourite){
							LikeTag=`<i class="LikeButton bi bi-heart-fill" id="`+mission.mission_id+`"></i>`;
						}
						let card=`<div class="card col-lg-4 col-md-6 col-xs-12">
							<div class="d-flex flex-column appliedCloseButtons">
							<button class="btn btn-success">applied</button>
							<button class="btn btn-danger">closed</button>
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
							src="image/Grow-Trees-On-the-path-to-environment-sustainability-1.png"
							class="card-img-top missionImgGridView" alt="...">
						<div class="card-body">
							<div class="d-flex justify-content-center missionCategoryDiv">
								<p class="missionCategoryGridView">`+mission.mission_theme.title+`</p>
							</div>
							<h5 class="card-title">`+mission.title+`</h5>
							<p class="card-text">`+mission.short_description+`</p>
							<div class="row ratingDivGridView">
								<div class="col">`+mission.organization_name+`</div>
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
									<p>Ongoing Oppurtunity</p>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<div class="row">
										<div class="col">
											<img src="image/Seats-left.png" alt="" srcset="">
										</div>
										<div class="col">
											<div class="row">10</div>
											<div class="row">Seats Left</div>
										</div>
									</div>

								</div>
								<div class="col">
									<div class="row">
										<div class="col">
											<img src="image/deadline.png" alt="" srcset="">
										</div>
										<div class="col">
											<div class="row">09/01/2019</div>
											<div class="row">Deadline</div>
										</div>
									</div>

								</div>
							</div>
							<div class="hrLine"></div>
							<div class="d-flex justify-content-center">
								<a href="getMyMission?mission_id=`+mission.mission_id+`" class="applyButtonGridView">Apply <i
									class="bi bi-arrow-right"></i></a>
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