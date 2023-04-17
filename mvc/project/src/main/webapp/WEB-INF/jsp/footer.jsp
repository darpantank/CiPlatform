<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                        <div class="form-group mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" name="name"
                                placeholder="Enter Your Name" value="${user.first_name}" readonly>
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Email Address</label>
                            <input type="email" class="form-control" name="newPassWord"
                                placeholder="Enter Your Email Address" value="${user.email}" readonly>
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Subject</label>
                            <input type="text" class="form-control contactUsSubject" name="newPassWord1"
                                placeholder="Enter Your Subject">
                        </div>
                        <div class="form-group mb-3">
                            <label class="form-label">Message</label>
                            <textarea class="form-control contactUsMessage" id="exampleFormControlTextarea1" placeholder="Enter Your Message" rows="3"></textarea>
                        </div>
                        <div class="d-flex mt-3 justify-content-end buttonsOfModal">
                            <button class="btn" data-bs-dismiss="modal" aria-label="Close">Cancel</button>
                            <button class="btn saveContactUs">Save</button>
                        </div>
                    
                </div>
            </div>
        </div>
    </div>
	<div class="container d-flex">
            <div class="privacyPolicyTab">
                <a class="btn" href="privacy">Privacy Policy</a>
            </div>
            <div class="privacyPolicyTab">
                <a class="btn" data-bs-toggle="modal" data-bs-target="#ModalForContactUs">Contact Us</a>
            </div>
     </div>
     <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
     <script>
     	$(".saveContactUs").click(function(){
     		var subject=$(".contactUsSubject").val();
     		var message=$(".contactUsMessage").val();
     		if(subject==''||message==''){
     			alert("Subject and Message Is Required Field(*)");
     		}
     		else{
     			$.ajax({
     	            url: "contactUs",
     	            dataType: 'json',
     	            data:{subject:subject,
     	            	message:message},
     	            type:"POST",
     	            success: function(response){
     	            		if(response){
     	            			alert("Contact Us Request Saved...");
     	            			$('#ModalForContactUs').modal('hide');
     	            		}
     	            		else{
     	            			alert("Something Went Wrong!");
     	            		}
     	            },
     	    	});
     		}
     	});
     </script>