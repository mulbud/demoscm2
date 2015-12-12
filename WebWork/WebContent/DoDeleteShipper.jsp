<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.mulbud.webwork.dataobjects.*, com.mulbud.webwork.*"%>
	<%
	DbWriter.deleteShipper(Integer.parseInt(request.getParameter("id")));
	
	response.sendRedirect("ShowShippers.jsp");
	%>
