package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert5RowinEmployeeUsingExecuteMethod 
{

	static Connection db()
	{
		
		try 
		{
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
			return con;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Inserting Record Count : ");
		int count = sc.nextInt();
		
		int result =0;
		
		for(int i=1;i<=count;i++)
		{
			Connection con = db();
			String query = "insert into employee values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			System.out.print("Enter "+i+" Record ID : "); int id = sc.nextInt();
			System.out.print("Enter "+i+" Record Name : "); String name = sc.next();
			System.out.print("Enter "+i+" Record Gender : "); String gender = sc.next();
			System.out.print("Enter "+i+" Record Email : "); String email = sc.next();
			System.out.print("Enter "+i+" Record Salary : "); double salary = sc.nextDouble();
			
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, gender);
			pst.setString(4, email);
			pst.setDouble(5, salary);
			
			
			boolean res =pst.execute();
			System.out.println("Res Value is "+res);
			result++;
			System.out.println(i+" Record Inserted...");
			
		}
		System.out.println(result+" Row Affected!!");

}
}
