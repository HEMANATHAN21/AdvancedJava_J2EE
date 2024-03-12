package JDBC;
import java.sql.*;
public class OverloadedConnetonMethod {

	public static void main(String[] args) throws SQLException 
	{

		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");//Overlodaed 1 param method
		Connection con = DriverManager.getConnection("jdbc:mysql:///studentdata?user=root&password=solohema");// "localhost:3306" is optional
		
		Statement stmt = con.createStatement();
		String query = "delete from studentinfo where id = 1";
		
		int result = stmt.executeUpdate(query);
		System.out.println(result);
		
		con.close();

	}

}
