$(document).ready(function() {
    var table = $('#example').DataTable( {
        rowReorder: {
            selector: 'td:nth-child(2)'
        },
        responsive: true
    } );
    $('#searchFilter').on( 'keyup', function () {
   table.search( this.value ).draw();
} );
} );