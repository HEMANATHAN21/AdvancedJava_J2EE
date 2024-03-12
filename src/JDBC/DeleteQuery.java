package JDBC;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;
public class DeleteQuery 
{

	public static void main(String[] args) throws SQLException
	{

		Driver dr = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dr);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		Statement stmt = conn.createStatement();
		int result = stmt.executeUpdate("delete from studentinfo where id = 3");
		System.out.println(result);
		conn.close();
	}

}
