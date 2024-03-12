package JDBC;
import java.sql.*;
import java.util.*;
public class ExecuteQueryaddBatchMethodUsingPreparedStatement 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		
		String query = "insert into studentinfo values(?,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Count of AddingBatch : ");
		int count = sc.nextInt();
		
		for(int i=1;i<=count;i++)
		{
			System.out.print("Enter "+i+" Record ID : "); int id = sc.nextInt(); 
			pst.setInt(1, id);
			System.out.print("Enter "+i+" Record Name : "); String name = sc.next();
			pst.setString(2, name);
			System.out.print("Enter "+i+" Record Email : "); String email = sc.next();
			pst.setString(3, email);
			System.out.print("Enter "+i+" Record Contact No : "); long contact = sc.nextLong();
			pst.setLong(4, contact);
			
			pst.addBatch();
		}
		
		int[] arr = pst.executeBatch();
		
		for(int j=0;j<arr.length;j++)
		{
			System.out.println(arr[j]+" Row Affected..");
		}

	}

}
