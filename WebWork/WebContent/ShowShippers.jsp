<%@page import="java.math.BigDecimal"%>
<%@page import="com.mulbud.webwork.*"%>
<%@page import="com.mulbud.webwork.dataobjects.Shipper, java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/WebWork/css/bootstrap.css" rel="stylesheet" /> 
<link href="/WebWork/css/bootstrap-theme.css" rel="stylesheet" /> 
<title>Insert title here</title>
</head>
<body>

	<div class="navbar navbar-inverse" role="navigation">
		<a class="navbar-brand" href="#">Web Work</a>
	</div>

<div class="row panel">

	<div class="col-xs-3">
		Sidebar
	</div>
	
	<div class="col-xs-8">
	<div>
	
	<%
		// Java Code
		int value = 27;
	
		List<Shipper> shippers = DbReader.getAllShippers();
		
		for(int index = 0; index < shippers.size(); index++)
		{
			Shipper p = shippers.get(index);
	%>
	<div class="well">
		<h3><strong><%=p.getName() %></strong>
		<span class="pull-right label label-primary"><%=p.getPhone()%></span>
		</h3>
	</div>
	<%
		}
	%>

	</div>
	</div>
</div>	
</body>
</html>