<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Odd-e Mass Mailer</title>
		<script type="text/javascript" src="js/SubjectValidation.js"></script>
		<s:head />
	</head>
	<s:form onsubmit="return validate();" action="massmailer">
	
	<table width="100%">
		<TR>
			<td align="left"><s:textfield label="FROM Address:" name="fromAddress" size="40"/></td>
		</TR>
		<TR>
			<td align="left"><s:textfield label="TO Address:" name="toAddress" size="40"/></td>
		</TR>
		<TR>
			<td>Subject:</td>
			<td colspan="2"><s:textfield name="subject" size="40" id="subject"/></td>
		</TR>
		<TR>
			<td align="left" ><s:file label="File:" name="fileName"/></td>
			<!--<td><input type="button" name="upload" value="Upload"/></td> -->
		</TR>
		<!--
		<TR colspan="3">
			<td></td>
			<td><s:textarea name="emailBody" cols="40" rows="40" id="emailBody"></s:textarea>
			</td>
		</TR>
		 -->
		<TR>
			<td align="left"><s:reset name="cancel" value="Cancel"/><s:submit name="send" value="Send"/></td>
		</TR>
	</table>
	</s:form>
</html>
