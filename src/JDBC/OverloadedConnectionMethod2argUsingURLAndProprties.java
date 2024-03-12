package JDBC;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
public class OverloadedConnectionMethod2argUsingURLAndProprties 
{

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException 
	{
		//Driver dr = new com.mysql.cj.jdbc.Driver();
		//DriverManager.registerDriver(dr);
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		FileInputStream fis = new FileInputStream("F:\\JSpider\\AdvancedJava_J2EE\\J2EE\\src\\JDBC\\xyz.properties");
		Properties p = new Properties();
		p.load(fis);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata",p);
		
		PreparedStatement ps = conn.prepareStatement("insert into studentinfo values(?,?,?,?)");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the id : ");
		int id = sc.nextInt();
		ps.setInt(1, id);
		
		System.out.println("Enter the name : ");
		String name = sc.next();
		ps.setString(2, name);
		
		System.out.println("Enter the email : ");
		String email = sc.next();
		ps.setString(3, email);
		
		System.out.println("Enter The contact : ");
		long contact = sc.nextLong();
		ps.setLong(4, contact);
		
		int result = ps.executeUpdate();
		System.out.println(result+" Row Affected !!");
		
		conn.close();

	}

}
