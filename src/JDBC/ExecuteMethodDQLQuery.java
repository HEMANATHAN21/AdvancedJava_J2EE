package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteMethodDQLQuery 
{

	public static void main(String[] args) throws SQLException 
	{
		Driver dr = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dr);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		Statement stmt = conn.createStatement();
		
		String query = "select * from studentinfo";
		
		boolean result = stmt.execute(query);
		System.out.println(result);
		
		ResultSet rs = stmt.getResultSet();
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String emailid = rs.getString("emailid");
			int mobileno = rs.getInt("mobileno");
			System.out.println("|  "+id+"  |  "+name+" |  "+emailid+" |  "+mobileno+"  |");
			
		}
		
		conn.close();

	}

}
