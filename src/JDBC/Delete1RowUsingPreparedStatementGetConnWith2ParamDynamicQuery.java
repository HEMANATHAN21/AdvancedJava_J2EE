package JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Delete1RowUsingPreparedStatementGetConnWith2ParamDynamicQuery {

	public static void main(String[] args) throws SQLException, IOException {
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis = new FileInputStream("F:\\JSpider\\AdvancedJava_J2EE\\J2EE\\src\\JDBC\\xyz.properties");
		Properties p = new Properties();
		p.load(fis);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", p);
		String query = "delete from studentinfo where id = ?";
		PreparedStatement pst = conn.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID : ");
		int id = sc.nextInt();
		pst.setInt(1, id);
		
		int result = pst.executeUpdate();
		System.out.println(result+" Row Affected");
		
		conn.close();
		sc.close();
		fis.close();

	}

}
