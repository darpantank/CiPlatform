var myEditor;

ClassicEditor
.create( document.querySelector( '#editor' ) )
.then( editor => {
		myEditor=editor;
        console.log( editor );
} )
.catch( error => {
        console.error( error );
} );