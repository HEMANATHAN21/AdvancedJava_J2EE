package JDBC;
import java.sql.*;
public class SelectQuery 
{

	public static void main(String[] args) throws SQLException 
	{
		Driver dr = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dr);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from studentinfo");
		//System.out.println("-----------------------------------------");
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
