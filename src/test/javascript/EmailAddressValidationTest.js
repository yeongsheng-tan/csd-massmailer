describe("Email Address Validations", function() {
	var sandbox;
	
	beforeEach(function() {
		sandbox = document.createElement('div');
		document.body.appendChild(sandbox);
	});

	afterEach(function() {
		document.body.removeChild(document.body.lastChild);
	});	
	
	it("should pass if given only one valid email address", function() {
		sandbox.innerHTML = "<input type='text' id='fromAddress' value='pranam@me.com' />";
		expect(validateEmailList("fromAddress")).toEqual(true);
	});
	
	
	it("should fail if given only one invalid email address", function() {
		spyOn(window,'alert');
		sandbox.innerHTML = "<input type='text' id='fromAddress' value='chuin.how' />";
		expect(validateEmailList("fromAddress")).toEqual(false);
		expect(window.alert).toHaveBeenCalledWith('Invalid email address: chuin.how');
		
	});
	
	it("should pass if given mulitple valid email addresses", function() {
		sandbox.innerHTML = "<input type='text' id='fromAddress' value='pranam@me.com;chuin.how@mobile.com;bill.silzy@hotmail.com' />";
		expect(validateEmailList("fromAddress")).toEqual(true);
	});
	
	it("should fail if given atleast one invalid email address", function() {
		spyOn(window,'alert');
		sandbox.innerHTML = "<input type='text' id='fromAddress' value='pranam@me.com;chuin.how.com;bill.silzy@hotmail.com' />";
		expect(validateEmailList("fromAddress")).toEqual(false);
		expect(window.alert).toHaveBeenCalledWith('Invalid email address: chuin.how.com');
	});
	
	it("should fail if given empty string", function() {
		spyOn(window,'alert');
		sandbox.innerHTML = "<input type='text' id='fromAddress' value='' />";
		expect(validateEmailList("fromAddress")).toEqual(false);
		expect(window.alert).toHaveBeenCalledWith('Invalid email address: ');
	});

	

	
});