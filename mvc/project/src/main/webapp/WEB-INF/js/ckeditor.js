var myEditor;

ClassicEditor
.create( document.querySelector( '#editor' ) )
.then( editor => {
		myEditor=editor;
} )
.catch( error => {
        console.error( error );
} );