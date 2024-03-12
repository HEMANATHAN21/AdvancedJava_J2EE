package JDBC;

import java.sql.*;
public class PurusTask {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		Statement stmt = conn.createStatement();
		String query = "select name from studentinfo";
		ResultSet rs = stmt.executeQuery(query);
		
		String name1 = "HEMANATHAN";
		
		while(rs.next())
		{
			String name2 = rs.getString("name");
			
			if(name2.equals(name1))
			{
				System.out.println("Same name");
			}
			else
			{
				System.out.println("diffrent name");
			}
		}
	}

}
