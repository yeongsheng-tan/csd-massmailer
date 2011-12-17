<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
    <title>Email file uploaded successfully</title>
    </head>

    <body>
        You have uploaded the following file.
        <hr>
        File Name : ${emailFileName} <br>
        File Content Type : ${emailFileContentType} <br>
        Email Body Preview : ${emailTextFromFile}
    </body>
</html>
