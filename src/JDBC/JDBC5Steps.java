package JDBC;

import java.sql.*;

public class JDBC5Steps 
{

	public static void main(String[] args) throws SQLException 
	{
		// LOAD AND REGISTER DRIVER
		Driver driver = new com.mysql.cj.jdbc.Driver(); //LOAD
			
		DriverManager.registerDriver(driver); //REGISTER
		
		//ESTABLISH CONNECTION
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		//CREATE STATEMENT AND ISSUE QUERRY
		Statement stmt = conn.createStatement();
			
		String query = "insert into studentinfo values(11,'HEMANATHAN','abc@gmail.com','1234567890')";
		//PROCESS THE RESULT
		int result = stmt.executeUpdate(query);
			
		System.out.println(result);
			
		//conn = null;
		//CLOSE THE CONNECTION
		conn.close();
		
		

	}

}
