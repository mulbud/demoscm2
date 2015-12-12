<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.mulbud.webwork.dataobjects.*, com.mulbud.webwork.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editing Shipper</title>
</head>
<body>
<%@ include file="/getShipperOrRedirect.jsp" %>

	<form action="saveShipper" method="post">
		<input type="hidden" name="id" value="${varName == null ? -1 : varName.id}" />
		<label>Company Name:</label>
		<input type="text" name="companyName" value="${varName.name}" /> <br />
		<label>Phone:</label>
		<input type="text" name="phone" value="${varName.phone}" /> <br />
		
		<input type="submit" value="Save changes" />
	</form>

</body>
</html>