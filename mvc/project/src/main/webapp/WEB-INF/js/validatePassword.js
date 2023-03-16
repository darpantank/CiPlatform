$("form").submit(function( event ) {
    if ($('#password').val() == $('#confirm_password').val()) {
      return;
    }
    event.preventDefault();
    alert("Password and Confirm Password Not Matched !");
  });