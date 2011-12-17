<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Odd-e Mass Mailer File Upload</title>
		<!--<script type="text/javascript" src="js/FileUploadValidation.js"></script>-->
		<s:head />
	</head>
    <s:form action="fileUpload" method="POST" enctype="multipart/form-data" >
    <s:file name="emailFile" label="Text file for email body" />
    <s:submit  value="submit" name="submit"  />
    </s:form>
</html>
