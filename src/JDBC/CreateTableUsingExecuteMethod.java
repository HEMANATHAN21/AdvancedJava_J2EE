package JDBC;
import java.sql.*;
public class CreateTableUsingExecuteMethod 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		Statement stmt = con.createStatement();
		
		String query = "create table studentdata.employee(id int primary key,name varchar(50),gender char(10),emailid varchar(50), salary double)";
		boolean result = stmt.execute(query);
		
		System.out.println(result);
		
		int count = stmt.getUpdateCount();
		System.out.println(count+" Table created");
		
		con.close();

	}

}
