function validateEmailList(emailAddressesElement){
	
	var regexExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	var emailAddress=document.getElementById(emailAddressesElement).value;

	var tokenizedEmailAddresses=emailAddress.split(';');
	
	var isValid=false;
	
	for(var i=0; i<tokenizedEmailAddresses.length; i++) {
		 
		 isValid=regexExp.test(tokenizedEmailAddresses[i]);
		 if(!isValid){
				alert('Invalid email: '+tokenizedEmailAddresses[i]);
				return isValid;
		}
		 
	}
	
	return isValid;
}

