package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery 
{

	public static void main(String[] args) throws SQLException 
	{
		Driver driver = new com.mysql.cj.jdbc.Driver(); 
					
		DriverManager.registerDriver(driver); 
				

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");

		Statement stmt = conn.createStatement();
					
		String query = "insert into studentinfo values(11,'HEMANATHAN','abc@gmail.com','1234567890')";

		int result = stmt.executeUpdate(query);
					
		System.out.println(result);
					
		//conn = null;
		conn.close();

	}

}
