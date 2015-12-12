package com.mulbud.webwork.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mulbud.webwork.DbWriter;

@WebServlet("/deleteShipper")
public class DeleteShipperServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DbWriter.deleteShipper(Integer.parseInt(req.getParameter("id")));
		
		resp.sendRedirect("ShowShippers.jsp");
	}
}
