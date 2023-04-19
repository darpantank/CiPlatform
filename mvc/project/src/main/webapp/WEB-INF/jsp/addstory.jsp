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

</html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add/Edit Story</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/addStory.css">
    <link rel="stylesheet" href="css/upload_drag_drop.css">
    <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>

<body>
<jsp:include page="spinner.jsp" />
<div class="container-fluid g-0">
		<jsp:include page="fheader.jsp" />
	</div>
    <div class="container">
        <p class="titleOfStory">
            Share Your Story
        </p>
        
		<input type="hidden" class="AlereadyPresentStoryId" value="0" >
        <div class="row mt-5">
            <div class="col-md-12 col-lg-4">
                <div class="form-group">
                    <div class="rightArrow"><i class="bi bi-chevron-down"></i></div>
                    <label for="storytitle">Select Mission</label>
                    <select class="form-control missionSelect" name="missionSelect" placeholder="Select Your Mission">
                        <option value="" disabled selected hidden>Select Your Mission</option>
                        <c:forEach var="a" items="${missions}">
                        	<option value="${a.missionId }">${a.missionName }</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-12 col-lg-4">
                <div class="form-group">
                    <label for="storytitle">My Story Title</label>
                    <input type="text" class="form-control titleOfTheStory" name="titleOfStory" placeholder="Enter Story Title">
                </div>
            </div>
            <div class="col-md-12 col-lg-4">
                <div class="form-group">
                    <label for="storytitle">Date</label>
                    <input type="date" class="form-control dateOfStory" name="dateOfStory" placeholder="Select Date">
                </div>
            </div>
        </div>
        <div class="ckeditor mt-4">
            <p>My Story</p>
            <div id="editor">Sample CkEditor</div>
        </div>
        <div class="videoUrls mt-4">
            <div class="form-group">
                <label for="storytitle">Enter Video URL</label>
                <input type="text" class="form-control videoUrl" name="videoUrl"placeholder="Enter Story Title">
            </div>
        </div>
        <div class="upload__box">
            <p>Upload Your Photos</p>
            <div class="upload__btn-box">
                <label class="upload__btn">
                    <input type="file" multiple="multiple" id="upload__inputfile" accept="image/*" data-max_length="20" class="upload__inputfile">
                    <i class="bi bi-plus-lg plusIcon"></i>
                    <p class="UploadTextMsg">drag and drop picture and video here</p>
                </label>
            </div>
            <div class="upload__img-wrap mt-3"></div>
        </div>
        <div class="d-flex justify-content-between">
            <div><button class="btn">cancel</button></div>
            <div class="d-flex rightButtons">
                <button class="btn saveButton">Save</button>
                <button class="btn submitButton" disabled>Submit</button>
            </div>
        </div>
    </div>

	<script>
		var imgArray = [];
    	const input = document.getElementById("upload__inputfile");
      	let container = new DataTransfer();
      	let imgTempArray=[];
	</script>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
        <script src=
        "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
            </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="js/sidebarJs.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
    <script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
    <script src="js/imageUploader.js"></script>
    <script src="js/ckeditor.js"></script>
    <script src="js/add_navbar.js"></script>
    <script>
    let draftStory="";
    $(".missionSelect").change(function(){
//     	generateFileObjectFromUrl();
//     	Checked For Draft
		$('.missionSelect').attr('disabled', 'disabled');
		var missionId=$(".missionSelect").val();
        $.ajax({
            url: "getdraftstory",
            dataType: 'json',
            data:{missionId:missionId},
            type:"GET",
            success: function(response){
            		draftStory=response;  
            		fillStoryDetails();	
            },
    	});
    });
    $(".submitButton").click(function(){
    	var storyId=$(".AlereadyPresentStoryId").val();
    	if(storyId==0){
    		swal("Sorry","First get Drafted Story","info");
    	}
    	else{    		
	    	$.ajax({
	            url: "submitdraftstory",
	            dataType: 'json',
	            data:{storyId:storyId},
	            type:"GET",
	            success: function(response){
	            		if(response){
	            			swal("Thanks...","Successfully Story Submitted...Once Admin Approve Story it will Display On Story Listing Page","success");
	            		}
	            }
	            ,complete: function(){
	            	resetFormData();
	            }
	    	});
    	}
    });
    $(".saveButton").click(function(){
    	var title= $(".titleOfTheStory").val();
    	var mission=$(".missionSelect").val();
    	var date=new Date($(".dateOfStory").val());
    	let originalUrl=$(".videoUrl").val();
    	let videoUrl="";
    	if(originalUrl!=''){    
    		var regExForYoutube=RegExp("^(https?\:\/\/)?(www\.youtube\.com|youtu\.be)\/.+$");
    		if(regExForYoutube.test(originalUrl)){
	    		videoUrl='https://www.youtube.com/embed/'+getId(originalUrl);
    		}
    		else{
    			swal("Sorry","You Enter Non Youtube URL","error");
    			
    		}
    	}
    	var story=myEditor.getData();
    	var storyId=$(".AlereadyPresentStoryId").val();
    	if(title!=""&&mission!=null&&date!=null&&story!="")
    	{
    		var data = new FormData();
			data.append("missionId",mission);
			data.append("title",title);
			data.append("date",date);
			data.append("videoUrl",videoUrl);
			data.append("story",story);
			data.append("storyId",storyId);
			for(var a in imgArray){
				data.append("images",imgArray[a]);
			}
			$(".upload__inputfile").val("");
    		
    		saveMyDataInDb(data);
    	}
    	else{
    		swal("Sorry !","Some Field is Empty Fill All the Required Fill","warning");
    	}
    });
    function fillStoryDetails(){
    	imgArray=[];
    	let videoUrl="";
    	$(".upload__img-wrap").empty();
    	$(".titleOfTheStory").val(draftStory.storyTitle);
    	$(".dateOfStory").val(getFormattedDate(draftStory.date));
    	
    	$(".AlereadyPresentStoryId").val(draftStory.storyId);
    	$(".submitButton").removeAttr("disabled");
    	if(draftStory.storyId!=0){    		
    		$(".previewButton").remove();
    		var previewButton="<a href='getDetailStory?storyId="+draftStory.storyId+"' class='btn previewButton' target='_blank'>Preview</a>";
    		$(".rightButtons").prepend(previewButton);
    	}
    	if(draftStory.story==""||draftStory.story==null){    		
    		myEditor.setData("");
    	}
    	else{
    	myEditor.setData(draftStory.story);
    	}
    		
    	for(var a in draftStory.images){
    		if(draftStory.images[a].mediaType=="IMAGE"){
    			generateFileObjectFromUrl(draftStory.images[a].mediaUrl,draftStory.images[a].mediaUrl.replace(/^.*[\\\/]/, ''));
    		}
    		if(draftStory.images[a].mediaType=="VIDEO"){
    			videoUrl=draftStory.images[a].mediaUrl;
    		}
    	}
    	$(".videoUrl").val(videoUrl);
setTimeout(function() {
	input.files = container.files;
	imgArray=imgTempArray;
	$(".upload__img-wrap").empty();
	for(var x in imgTempArray){		
		var html = "<div class='upload__img-box'><div style='background-image: url(uploadFiles/" + imgTempArray[x].name + ")' data-number='" + $(".upload__img-close").length + "' data-file='" + imgTempArray[x].name + "' class='img-bg'><div class='upload__img-close'><i class='bi bi-x'></i></div></div></div>";
	    $(".upload__img-wrap").append(html);
	}
}, 2500);
		
    	
    }
    function getFormattedDate(date) {
			date=new Date(date);
    	  const year  = date.getFullYear(),
    	        month = ('0' + (date.getMonth() + 1)).slice(-2),
    	        day   = ('0' + date.getDate()).slice(-2)

    	  return [year, month, day].join('-')
    }
    
    function saveMyDataInDb(data){
    	
    $.ajax({
        url: "savestory",
        dataType: 'json',
        data:data,
        type:"POST",
        contentType: false,
        processData: false,
        success: function(response){
        	    	
        },
    	complete:function(){
    		resetFormData();
    		swal("Thanks","Story Added Successfully...","success")
    		imgArray=[];
    		$(".missionSelect").removeAttr("disabled");
    	}
	});
    }
    function resetFormData(){
    	
    	$("input").val('');
    	$(".missionSelect").prop("selectedIndex", 0);
    	imgArray=[];
    	imgTempArray=[];
    	$(".upload__img-wrap").empty();
    	myEditor.setData( '' );
    }
    async function generateFileObjectFromUrl(url,name){
    	async function getFileFromUrl(url, name, defaultType = 'image/jpeg'){
    		  const response = await fetch(url);
    		  const data = await response.blob();
    		  return new File([data], name, {
    		    type: data.type || defaultType,
    		  });
    		}

    		// `await` can only be used in an async body, but showing it here for simplicity.
    		const file=await getFileFromUrl(url, name);
    		container.items.add(file);
    		imgTempArray.push(file);
    }
    function getId(url) {
        const regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|&v=)([^#&?]*).*/;
        const match = url.match(regExp);

        return (match && match[2].length === 11)
          ? match[2]
          : null;
    }
    </script>
	<script src="js/spinner.js"></script>
</body>

</html>