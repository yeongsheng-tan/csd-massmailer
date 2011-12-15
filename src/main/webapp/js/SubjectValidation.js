function validateSubject(){
	var subjectLine = document.getElementById("subject").value;
	var isValid = validateSubjectLine(subjectLine);
	if (!isValid){
		alert("Subject line cannot be empty");
	}
	return isValid;
}

function validateSubjectLine(subjectLine)
{
	return subjectLine.length != 0;
}