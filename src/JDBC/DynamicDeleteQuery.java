package JDBC;
import java.util.*;
import java.sql.*;
public class DynamicDeleteQuery 
{

	public static void main(String[] args) throws SQLException 
	{
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		String query = "delete from studentinfo where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID : "); int id = sc.nextInt();
		
		ps.setInt(1, id);
		
		int result = ps.executeUpdate();
		System.out.println(result);

	}

}
