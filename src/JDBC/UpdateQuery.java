package JDBC;
import java.sql.*;
public class UpdateQuery 
{

	public static void main(String[] args) throws SQLException 
	{
		Driver dr = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(dr);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		
		Statement stmt = conn.createStatement();
		
		String query = "update studentinfo set emailid='hema@gmail.com' where id = 2";
		
		int result = stmt.executeUpdate(query);
		
		System.out.println(result);
		
		conn.close();
	}

}
