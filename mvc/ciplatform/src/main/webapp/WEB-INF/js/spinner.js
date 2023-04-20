	var $loading = $('.spinner').hide();
    //Attach the event handler to any element
    $(document)
      .ajaxStart(function () {
         //ajax request went so show the loading image
          $loading.show();
      })
    .ajaxStop(function () {
        //got response so hide the loading image
         $loading.hide();
     });