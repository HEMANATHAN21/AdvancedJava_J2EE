package JDBC;
import java.util.*;
import java.sql.*;
import java.io.*;
public class LoadAndRegisterAnotherWay 
{

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException 
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		FileInputStream fis = new FileInputStream("F:\\JSpider\\AdvancedJava_J2EE\\J2EE\\src\\JDBC\\xyz.properties");
		Properties p = new Properties();
		p.load(fis);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata",p);
		
		String query = "select * from studentinfo";
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			String name = rs.getString(2); // (or) String name = rs.getString("name");
			long contact = rs.getLong(4); // (or) long contact = rs.getLong("mobileno");
			
			System.out.println(name+"        "+contact);
		}
		con.close();

	}

}
