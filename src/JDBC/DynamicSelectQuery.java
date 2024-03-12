package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicSelectQuery 
{

	public static void main(String[] args) throws SQLException 
	{

		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","solohema");
		String query = "select * from studentinfo where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID : "); int id = sc.nextInt();
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		int stuid = rs.getInt(1);
		String name = rs.getString(2);
		String email = rs.getString(3);
		long contact = rs.getLong(4);
		
		System.out.println("|  "+stuid+"  |  "+name+" |  "+email+" |  "+contact+"  |");

	}

}
