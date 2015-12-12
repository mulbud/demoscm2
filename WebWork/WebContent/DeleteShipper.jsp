<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.mulbud.webwork.dataobjects.*, com.mulbud.webwork.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Delete</title>
</head>
<body>
<%@ include file="/getShipperOrRedirect.jsp" %>
	<%
	
		Shipper s = (Shipper)request.getAttribute("varName");
	
		if (s != null)
		{
	%>

	<form action="DoDeleteShipper.jsp" method="post">
		<input type="hidden" name="id" value="<%=s.getId()%>" />
		<label>Company Name: <%=s.getName() %></label> <br />
		<label>Phone: <%=s.getPhone() %></label> <br />
		
		<a href="ShowShippers.jsp">Cancel</a>
		<input type="submit" value="Delete" />
	</form>

	<%
		}
	%>
</body>
</html>