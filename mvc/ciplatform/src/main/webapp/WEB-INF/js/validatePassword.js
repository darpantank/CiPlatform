$("form").submit(function( event ) {
    if ($('#password').val() == $('#confirm_password').val()) {
      return;
    }
    event.preventDefault();
    alertMsg=`<div class="alert alert-warning alert-dismissible fade show"
						role="alert">
						<strong>Sorry </strong> Password and Confirm Password Not Mathched!
						
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
					</div>`;
	$(".messageBox").html(alertMsg);
  });