function validate()
{
	var isValidSubject = validateSubject();
	var isValidAddress = validateEmailList('toAddress');
	return isValidSubject && isValidAddress;
}