describe("Subject Validations", function() {
	var sandbox;
	
	beforeEach(function() {
		sandbox = document.createElement('div');
		document.body.appendChild(sandbox);
	});

	afterEach(function() {
		document.body.removeChild(document.body.lastChild);
	});
	
	it("should accept valid string", function() {
		sandbox.innerHTML = "<input type='text' id='subject' value='This is a valid subject' />";
		expect(validate()).toEqual(true);
	});

	
	it("should not be blank", function() {
		spyOn(window,'alert');
		sandbox.innerHTML = "<input type='text' id='subject' value='' />";
		expect(validate()).toEqual(false);
		expect(window.alert).toHaveBeenCalledWith('Subject line cannot be empty');
	});

	
});