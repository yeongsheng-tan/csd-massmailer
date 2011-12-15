
function handleFileSelect(evt) {
	var files = evt.target.files; // FileList object
	var f = files[0];

	// Loop through the FileList and render image files as thumbnails.
		if (!f.type.match('text/*')) {
			alert("Please select 'text' file only");
			return;
		}

		var reader = makeFileReader();

		// Closure to capture the file information.
		reader.onload = (function(theFile) {
			return function(e) {
				document.getElementById('emailBody').value=e.target.result;
			};
		})(f);

		reader.readAsText(f);
}

function makeFileReader() {
	return new FileReader();
}
