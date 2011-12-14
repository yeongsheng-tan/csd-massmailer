function validate(){
	var subjectLine = document.getElementById("subject").value;
	var isValid = validateSubject(subjectLine);
	if (!isValid){
		alert("Subject line cannot be empty");
	}
	return isValid;
}

function validateSubject(subjectLine)
{
	return subjectLine.length != 0;
}