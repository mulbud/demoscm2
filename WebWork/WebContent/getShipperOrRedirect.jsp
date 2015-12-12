<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.mulbud.webwork.dataobjects.*, com.mulbud.webwork.*"%>

	<%
		String st = request.getParameter("id");
	
		Object obj = request.getParameter("new"); // Null means redirect. Not null means not redirect
	
		// If null & redirect is requested...
		if (st == null)
		{
			if (obj == null)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				//Shipper s = new Shipper();
				//s.setId(-1);
				//request.setAttribute("varName", s);
			}
		}
		else
		{
			Shipper s = DbReader.getShipper(Integer.parseInt(st));
			request.setAttribute("varName", s);
		}
		
	%>