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
    <link rel="stylesheet" href="css/storylisting.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <title>Story - CiPlatform</title>
</head>

<body>
<jsp:include page="spinner.jsp" />
    	<div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container-fluid mainPhoto g-0">
        <div class="myDesc d-flex justify-content-center flex-column align-items-center w-100 h-100">
            <p class="imgDescriptor">Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis nobis cupiditate
                ad. Explicabo veritatis, dio, dolor modi nam.</p>
            <a class="btn shareStoryButton" href="createstory">Share Your Story <i class="bi bi-arrow-right"></i></a>
        </div>
        <img src="image/Grow-Trees-On-the-path-to-environment-sustainability - crop.png" alt="" srcset="">
    </div>
    <div class="container mt-4">
        <div class="row storyCards">
<!--             Story Card Fetched Here -->
        </div>
    </div>
    <div class="myPaginationTab d-flex justify-content-center text-danger">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
<!--                 pagination Created Here -->
            </ul>
          </nav>
    </div>
    <div class="container-fluid g-0 bg-light mt-2 position-sticky bottom-0 start-0" style="z-index:1111">
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
    <script src="js/sidebarJs.js"></script>
    <script src="js/add_navbar.js"></script>
    <script>
    let totalStory=0;
    let totalStoryPerPage=9;
    let totalPages=0;
    let currentPage=1;
    let stories="";
//     	Ajax Call to Fetch total Story to generate the pagination list 
    $(document).ready(function(){
    	$.ajax({
            url: "loadCountOfStory",
            dataType: 'json',
            success: function(response){
           	totalStory=response;
           	generatePagination();
           	loadStories();
            }
        });
    });
    
    			function loadStories(){
//     				ajax call to load stories of first page initially and change according to page number
    				$.ajax({
    	                url: "loadStoryByPageNo",
    	                dataType: 'json',
    	                data : {currentPage:currentPage},
    	                success: function(response){
    	                	stories=response;
    	                	generateStoryCard();
    	                }
    	            });
    				
    				
    				
    			}
             function generatePagination(){
            	 totalPages=totalStory/totalStoryPerPage;
            	 totalPages=Math.ceil(totalPages);
            	 $(".pagination").empty();
            	 if(totalPages==0){
            		 noStoryFound();
            	 }
            	 else{
            		 let pagination=`<li class="page-item goAtFirst">
                         <a class="page-link" href="#" aria-label="Next">
                         <span aria-hidden="true"><i class="bi bi-chevron-double-left"></i></span>
                     </a>
                   </li>
               <li class="page-item previousPagination">
                 <a class="page-link" href="#" aria-label="Next">
                     <span aria-hidden="true"><i class="bi bi-chevron-left"></i></span>
                 </a>
               </li>`;
               
               for(var a=1;a<=totalPages;a++){
            	   if(currentPage==a){            		   
            	   		pagination+=`<li class="page-item"><a class="page-link active" onclick="changePage(`+a+`)">`+a+`</a></li>`;
            	   }
            	   else{
            		   pagination+=`<li class="page-item"><a class="page-link" onclick="changePage(`+a+`)">`+a+`</a></li>`;
            	   }
               }
               
               pagination+=`<li class="page-item NextPagination">
                   <a class="page-link" href="#" aria-label="Next">
                   <span aria-hidden="true"><i class="bi bi-chevron-right"></i></span>
                 </a>
               </li>
               <li class="page-item goAtLast">
                 <a class="page-link" href="#" aria-label="Next">
                     <span aria-hidden="true"><i class="bi bi-chevron-double-right"></i></span>
                   </a>
               </li>`;
               
               $(".pagination").append(pagination);
            	 }
            	 
            	 $(".goAtLast").click(function(){
					  if(currentPage==totalPages){
						  swal("Sorry !","You are On Last Page already!","info");
					  }
					  else{						  
						  changePage(totalPages);
					  }
				  });
				  $(".goAtFirst").click(function(){
					  if(currentPage==1)
					  {						  
					  	swal("Sorry !","You are On First Page already!","info");
					  }
					  else{					  
						  changePage(1);
					  }
				  });
					  $(".NextPagination").click(function() {
						  if(currentPage<totalPages)
						  {
							  changePage(++currentPage);
						  }
						  else{
							  swal("Sorry !","You are On Last Page Already!","info");
						  }
					  });
					  $(".previousPagination").click(function() {
						  if(currentPage>1)
						  {
							  changePage(--currentPage);
						  }
						  else{
							  swal("Sorry !","You are On First Page Already!","info");
						  }
					  });
            	 
            	 
            	 
             }
             
             
    		function noStoryFound(){
    			$(".storyCards").empty().append("<h1>No story found...</h1>");
    		}
    		
    		function changePage(a){
    			currentPage=a;
    			generatePagination();
    			loadStories();
    			
    		}
    		function generateStoryCard(){    			
    			$(".storyCards").empty();
    			console.log(stories);
    			for(var storyIndex in stories){
    				var story=stories[storyIndex];
    				var storyId=story.storyId;
    				console.log(story);
    				var missionTheme=story.missionTheme;
    				if(missionTheme==null){
    					missionTheme="";
    				}
    				var storyDescription=story.storyDescription;
    				if(storyDescription==null){
    					storyDescription="";
    				}
    				var storyTitle=story.storyTitle;
    				if(storyTitle==null){
    					storyTitle="";
    				}
    				let userAvatar=story.userAvatar;
    				if(userAvatar==null||userAvatar==""){
    					userAvatar="image/user1.png";
    				}
    				else{    					
    				userAvatar=story.userAvatar;
    				}
    				var userName=story.userName;
    				if(userName==null){
    					userName="";
    				}
    				var mediaUrl=story.image.mediaUrl;
    				var mediaType=story.image.mediaType;
    				var imageUrl="";
    				if(mediaType==null||mediaUrl==null){
    					imageUrl="image/noimagefound.png";	
    				}
    				else{
    					if(mediaType=="IMAGE"){
    						imageUrl=mediaUrl;
    					}
    				}
    				
    				let card=`<div class="card col-lg-4 col-md-6 col-xs-12">
        	            <div class="imgDiv d-flex justify-content-center">
        	            <div class="d-flex justify-content-center missionCategoryDiv">
        	                <p class="missionTheme">`+missionTheme+`</p>
        	            </div>
        	            <div class="viewDetailsHoverButton h-100 w-100">
        	                <a class="btn" href="getDetailStory?storyId=`+storyId+`">View Details <i class="bi bi-arrow-right"></i></a>
        	            </div>
        	            <img src="`+imageUrl+`" class="storyCardImg card-img-top w-100" alt="...">

        	        </div>
        	        <div class="card-body">
        	            <h5 class="card-title">`+storyTitle+`</h5>
        	            <p class="card-text">`+storyDescription.substring(0,250)+`</p>
        	            <div class="d-flex align-items-center gap-2">
        	                <div><img class="profileImage" src="`+userAvatar+`" alt="" srcset=""></div>
        	                <div>`+userName+`</div>
        	            </div>
        	        </div>
        	    </div>`;
        	    $(".storyCards").append(card);	
    			}
    			
    		}
    	
    </script>
	<script src="js/spinner.js"></script>
</body>

</html>