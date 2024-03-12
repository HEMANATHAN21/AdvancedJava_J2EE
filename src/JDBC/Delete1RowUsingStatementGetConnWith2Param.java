package JDBC;

import java.util.*;
import java.sql.*;
import java.io.*;

public class Delete1RowUsingStatementGetConnWith2Param 
{

	public static void main(String[] args) throws SQLException, IOException
	{
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis = new FileInputStream("F:\\JSpider\\AdvancedJava_J2EE\\J2EE\\src\\JDBC\\xyz.properties");
		Properties p = new Properties();
		p.load(fis);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", p);
		
		Statement stmt = conn.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID : ");
		int id = sc.nextInt();
		String query = "delete from studentinfo where id = "+id+"";
		
		int result = stmt.executeUpdate(query);
		System.out.println(result+" Row Affected");
		
		conn.close();
		sc.close();
		
		
		

	}

}
