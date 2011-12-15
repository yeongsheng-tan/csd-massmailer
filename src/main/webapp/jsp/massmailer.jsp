<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Odd-e Mass Mailer</title>
		<script type="text/javascript" src="js/SubjectValidation.js"></script>
		<script type="text/javascript" src="js/EmailAddressValidation.js"></script>
		<script type="text/javascript" src="js/UploadFile.js"></script>
		<script type="text/javascript" src="js/FullEmailValidation.js"></script>
		<s:head />
	</head>
	<s:form onsubmit="return validate();" action="sendEmail" name="massmailerform" enctype="multipart/form-data" method="POST">
	
	<table>
		<TR>
			<td align="left"><s:textfield label="FROM Address:" id="fromAddress" name="fromAddress" size="40"/></td>
		</TR>
		<TR>
			<td align="left"><s:textfield label="TO Address:" id="toAddress" name="toAddress" size="40"/></td>
		</TR>
		<TR>
			<td align="left"><s:textfield label="Subject:" id="subject" name="subject" size="40"/></td>
		</TR>
		<TR>
			<td align="left" ><s:file label="File:" id="fileName" name="fileName"/></td>
		</TR>
		<TR>
			<td align="left"><s:textarea id="emailBody" name="emailBody" cols="60" rows="20"/></td>
		</TR>
		<TR>
			<td align="left"><s:submit name="send" value="Send"/></td>
		</TR>
		<TR>
			<td align="left"><s:reset name="cancel" value="Cancel"/></td>
		</TR>
	</table>
	</s:form>
	<script>
			document.getElementById('fileName').addEventListener('change', handleFileSelect, false);
	</script>
</html>
