package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteMethodDMLQuery 
{

	public static void main(String[] args) throws SQLException 
	{
		Driver dr = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dr);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		Statement stmt = conn.createStatement();
		
		String query ="delete from studentinfo where id = 10";
		
		boolean result = stmt.execute(query);
		System.out.println(result);
		
		int rowsAffected = stmt.getUpdateCount();
		System.out.println(rowsAffected);
		conn.close();

	}

}
