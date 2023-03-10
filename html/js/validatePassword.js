$("form").submit(function( event ) {
    if ($('#password').val() == $('#confirm_password').val()) {
      return;
    }
    event.preventDefault();
    alert("PassWord and Confirm Password Not Matched !");
  });