package JDBC;

import java.sql.*;
public class SelectClauseQueryEx1 
{

	public static void main(String[] args) throws SQLException 
	{

		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		Statement stmt = conn.createStatement();
		String query ="select emailid,id,mobileno from studentinfo";
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next())
		{
			int id = rs.getInt(2);
			String email = rs.getString(1);
			long contact = rs.getLong(3);
			
			System.out.println(id+" "+email+" "+contact);
		}

	}

}
