package JDBC;
import java.util.*;
import java.sql.*;
public class Insert2RowsUsingPreparedStatementGetConnWith1Param 
{

	public static void main(String[] args) throws SQLException 
	{

		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		
		String query = "insert into studentinfo values (5,'AKASH','akash@gmail.com',1234567890),(6,'KIRUBA','kiruba@gmail.com',1234567890)";
		
		PreparedStatement pst = conn.prepareStatement(query);
		
		int result = pst.executeUpdate();
		System.out.println(result+" Rows Affected!!");
		
		conn.close();

	}

}
