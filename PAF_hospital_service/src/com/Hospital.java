package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hospital {

	//A common method to connect to the DB
	private Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf-practical?useTimezone=true&serverTimezone=UTC", "root", "");
		}
		catch (Exception e)
		{e.printStackTrace();}
		return con;
	} 
	

	// reading an items -------------------------
	public String readDoctor()
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>DoctorName</th> <th>Email</th><th>Specialization</th>"+ "<th>Password</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from doctordetails";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next())
			{
				String DID = Integer.toString(rs.getInt("DID"));
				String DoctorName = rs.getString("DoctorName");
				String Email = rs.getString("Email");
				String Specialization = rs.getString("Specialization");
				String Password = rs.getString("Password"); 

				// Add into the html table
				output += "<tr><td><input id='hidDoctorIDUpdate'name='hidDoctorIDUpdate' type='hidden'value='" + DID + "'>" + DoctorName + "</td>";
				output += "<td>" +Email + "</td>";
				output += "<td>" + Specialization + "</td>";
				output += "<td>" + Password + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button'"+ "value='Update'"+"class='btnUpdate btn btn-secondary'></td>"+"<td><input name='btnRemove' type='button'"+" value='Remove'"+"class='btnRemove btn btn-danger' data-did='"+ DID + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		}
		catch (Exception e)
		{
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	//inserting---------------------
		public String insertDoctor(String DoctorName, String Email,String Specialization, String Password)
		{
			String output = "";
			try
			{
				
				Connection con = connect();
				if (con == null)
				{
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = " insert into doctordetails(`DoctorName`,`Email`,`Specialization`,`Password`)"+ " values (?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				
				preparedStmt.setString(1, DoctorName);
				preparedStmt.setString(2, Email);
				preparedStmt.setString(3,Specialization );
				preparedStmt.setString(4, Password);
				// execute the statement
				preparedStmt.execute();
				
				 System.out.print("successfuly inserted");
				 
				con.close();
				String newDocters =readDoctor();
				output = "{\"status\":\"success\", \"data\": \"" + newDocters + "\"}";
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\":\"Error while inserting the doctor.\"}";
				System.err.println(e.getMessage());
			}
			return output;
		}
		//update Doctor
		public String updateDoctor(String DID, String DoctorName, String  Email,String Specialization, String Password)
		{
			String output = "";
			try
			{
				
				System.out.println(DoctorName + ", " + Email + ", " + Specialization + ", " + Password);
				Connection con = connect();
				if (con == null)
				{
					return "Error while connecting to the database for updating.";
				}
				// create a prepared statement
				String query = "UPDATE doctordetails SET DoctorName=?,Email=?,Specialization=?,Password=? WHERE DID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, DoctorName);
				preparedStmt.setString(2, Email);
				preparedStmt.setString(3, Specialization);
				preparedStmt.setString(4,Password);
				preparedStmt.setInt(5, Integer.parseInt(DID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				String newDocters =readDoctor();
				output = "{\"status\":\"success\", \"data\": \"" + newDocters + "\"}";
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\":\"Error while updating the doctor.\"}";
				System.err.println(e.getMessage());
			}
			return output;
		}
		//delete doctor------------------------
		public String deleteDoctor(String DID) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from doctordetails where DID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(DID));
				// execute the statement
				preparedStmt.execute();
				con.close();
				//output = "Deleted successfully";
				String newDocters =readDoctor();
				output = "{\"status\":\"success\", \"data\": \"" + newDocters + "\"}";
			} catch (Exception e) {
				//output = "Error while deleting the item.";
				output = "{\"status\":\"error\", \"data\":\"Error while deleting the doctor.\"}";
				
				System.err.println(e.getMessage());
			}
			return output;
		}
		 
}