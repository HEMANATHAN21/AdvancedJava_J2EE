package JDBC;
import java.util.*;
import java.sql.*;
public class InsertNnoOfRowUsingDynamicQuery 
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
			String query = "insert into studentinfo values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			System.out.print("Enter "+i+" Record ID : "); int id = sc.nextInt();
			System.out.print("Enter "+i+" Record Name : "); String name = sc.next();
			System.out.print("Enter "+i+" Record Email : "); String email = sc.next();
			System.out.print("Enter "+i+" Record Contact No : "); long contact = sc.nextLong();
			
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setLong(4, contact);
			
			result += pst.executeUpdate();
			System.out.println(i+" Record Inserted...");
			
		}
		System.out.println(result+" Row Affected!!");

	}

}
