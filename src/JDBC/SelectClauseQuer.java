package JDBC;
import java.sql.*;
public class SelectClauseQuer 
{

	public static void main(String[] args) 
	{
		try 
		{
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
			Statement stmt = conn.createStatement();
			String query = "select * from studentinfo";
			//ResultSet rs = stmt.executeQuery(query);
			stmt.execute(query);
			ResultSet rs = stmt.getResultSet();
			while(rs.next())
			{
				int id = rs.getInt(1); 
				String name = rs.getString(2);
				String email = rs.getString(3);
				long contact = rs.getLong(4);
				
				System.out.println(id+" "+name+" "+email+" "+contact);
				
			}
			
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		

	}

}
