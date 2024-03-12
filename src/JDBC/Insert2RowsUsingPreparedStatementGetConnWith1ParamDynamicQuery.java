package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert2RowsUsingPreparedStatementGetConnWith1ParamDynamicQuery 
{

	public static void main(String[] args) throws SQLException
	{
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		
		String query = "insert into studentinfo values (?,?,?,?),(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID 1 : "); int id1 = sc.nextInt();
		System.out.print("Enter Name 1 : "); String name1 = sc.next();
		System.out.print("Enter Email 1 : "); String email1 = sc.next();
		System.out.print("Enter Contact No 1 : "); long contact1 = sc.nextLong();
		
		pst.setInt(1, id1);
		pst.setString(2, name1);
		pst.setString(3, email1);
		pst.setLong(4, contact1);
		
		System.out.print("Enter ID 2 : "); int id2 = sc.nextInt();
		System.out.print("Enter Name 2 : "); String name2 = sc.next();
		System.out.print("Enter Email 2 : "); String email2 = sc.next();
		System.out.print("Enter Contact No 2 : "); long contact2 = sc.nextLong();
		
		pst.setInt(5, id2);
		pst.setString(6, name2);
		pst.setString(7, email2);
		pst.setLong(8, contact2);
		
		int result = pst.executeUpdate();
		System.out.println(result+" Rows Affected!!");
		
		conn.close();

	}

}
