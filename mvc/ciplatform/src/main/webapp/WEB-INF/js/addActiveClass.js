$(document).ready(function () {
    $('#list-example a').click(function(e) {

        $('#list-example a').removeClass('activeComponent');

        var $this = $(this);
        if (!$this.hasClass('activeComponent')) {
            $this.addClass('activeComponent');
        }
        //e.preventDefault();
    });
});