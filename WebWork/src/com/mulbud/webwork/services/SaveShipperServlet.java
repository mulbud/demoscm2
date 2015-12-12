package com.mulbud.webwork.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mulbud.webwork.DbWriter;
import com.mulbud.webwork.dataobjects.Shipper;

@WebServlet("/saveShipper")
public class SaveShipperServlet extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			Shipper s = new Shipper();
			s.setName(req.getParameter("companyName"));
			s.setPhone(req.getParameter("phone"));
			String id = req.getParameter("id");
			if (id.equals(""))
				id = "-1";
			s.setId(Integer.parseInt(id));

			DbWriter.saveShipper(s);
			
			//resp.sendRedirect("ShowShippers.jsp");
			getServletContext().getRequestDispatcher("/ShowShippers.jsp").forward(req, resp);
//			PrintWriter pw = resp.getWriter();
//			pw.println("<h1>Saved</h1>");
//			
//			pw.close();
		}
}
