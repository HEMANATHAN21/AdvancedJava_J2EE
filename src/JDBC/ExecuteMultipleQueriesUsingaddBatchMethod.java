package JDBC;
import java.sql.*;
public class ExecuteMultipleQueriesUsingaddBatchMethod 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		Statement stmt = con.createStatement();
		
		stmt.addBatch("insert into studentinfo values(11,'pathu','pathu@gmail.com',123456789)");
		stmt.addBatch("insert into studentinfo values(12,'bala','bala@gmail.com',123456789)");
		stmt.addBatch("delete from studentinfo where id >7");
		stmt.addBatch("update studentinfo set name ='jeyavarshan' where id = 4");
		
		int[] arr = stmt.executeBatch();
		
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.println(arr[i]);
			
		}

	}

}
