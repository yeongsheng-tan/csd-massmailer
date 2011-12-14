<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
    <title>Email send failure</title>
    </head>

    <body>

        <h5>Email was NOT sent. Error encountered: /></h5>
        <s:property value="sendMailError" />
    </body>
</html>
