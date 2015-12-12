package com.mulbud.webwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.mulbud.webwork.dataobjects.Shipper;

public class DbWriter {

	private static String connectionString = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Northwind;user=sa;password=slu";

	public static void saveShipper(Shipper shipper)
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionString);
			
			String sql = "UPDATE Shippers SET CompanyName= ?, Phone= ? WHERE ShipperID= ?";
			if (shipper.getId() < 0)
			{
				sql = "INSERT INTO Shippers(CompanyName, Phone) VALUES(?, ?)";
			}
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, shipper.getName());
			stmt.setString(2, shipper.getPhone());
			if (shipper.getId() > 0)
			{
				stmt.setInt(3, shipper.getId());
			}
			
			stmt.execute();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void deleteShipper(int id)
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionString);
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Shippers WHERE ShipperID = ?");
			stmt.setInt(1, id);
			
			stmt.execute();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
