describe("handleFileSelect", function() {
	var sandbox;
	
	beforeEach(function() {
		sandbox = document.createElement('div');
		document.body.appendChild(sandbox);
	});

	afterEach(function() {
		document.body.removeChild(document.body.lastChild);
	});
	
	it("should show alert for an invalid file type", function() {
		spyOn(window, 'alert');
		
		var file = {type: 'some other content'};
		var evt = {target: {files: [file]}};
		
		handleFileSelect(evt);
		
		expect(window.alert).toHaveBeenCalledWith("Please select 'text' file only");
	});

	
	it("should call FileReader.readAsText for a valid file", function() {
		var file = {type: 'text/plain', result: 'hello'};
		var evt = {target: {files: [file]}};
		
		var mockedReadAsTextFunction = jasmine.createSpy();
		
		makeFileReader = function() {
			return {readAsText: mockedReadAsTextFunction};
		};
		
		handleFileSelect(evt);

		expect(mockedReadAsTextFunction).toHaveBeenCalledWith(file);
		
	});

	
});