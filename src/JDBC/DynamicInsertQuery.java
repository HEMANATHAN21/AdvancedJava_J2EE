package JDBC;

import java.sql.*;
import java.util.*;

public class DynamicInsertQuery 
{

	public static void main(String[] args) throws SQLException 
	{

		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		String query = "insert into studentinfo values (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID : "); int id = sc.nextInt();
		System.out.print("Enter Name : "); String name = sc.next();
		System.out.print("Enter Email : "); String email = sc.next();
		System.out.print("Enter Contact No : "); long contact = sc.nextLong();
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setLong(4, contact);
		
		int result = ps.executeUpdate();
		System.out.println(result);

	}

}
