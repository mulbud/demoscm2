package com.mulbud.webwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mulbud.webwork.dataobjects.Product;
import com.mulbud.webwork.dataobjects.Shipper;

public class DbReader {

	private static String connectionString = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Northwind;user=sa;password=slu";
	
	public static List<Product> getAllProducts()
	{
		return getAllTableObjects("SELECT * FROM Products ORDER BY ProductName", new ProductReader());
	}
	
	public static List<Product> getAllProductsOld()
	{
		List<Product> products = new ArrayList<Product>();
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String sql = "SELECT * FROM Products ORDER BY ProductName";
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				Product p = new Product();
				p.setId(rs.getInt("ProductId"));
				p.setName(rs.getString("ProductName"));
				p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
				p.setUnitPrice(rs.getBigDecimal("UnitPrice"));
				products.add(p);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return products;
	}
	
	public static List<Shipper> getAllShippers()
	{
		return getAllTableObjects("SELECT * FROM Shippers ORDER BY CompanyName", new ObjectReader<Shipper>() {

			@Override
			public Shipper readFromResultSet(ResultSet rs) throws Exception {

				Shipper s = new Shipper();
				s.setId(rs.getInt("ShipperId"));
				s.setName(rs.getString("CompanyName"));
				s.setPhone(rs.getString("Phone"));
				
				return s;
			}
			
		});
	}
	
	private static <T> List<T> getAllTableObjects(String sql, ObjectReader<T> reader)
	{
		List<T> items = new ArrayList<T>();
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection conn = DriverManager.getConnection(connectionString);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				T item = reader.readFromResultSet(rs);
				if (item != null)
					items.add(item);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return items;
	}
}
