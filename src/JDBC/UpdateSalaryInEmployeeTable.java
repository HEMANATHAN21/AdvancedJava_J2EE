package JDBC;
import java.sql.*;
import java.util.*;
public class UpdateSalaryInEmployeeTable 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		
		String query = "update employee set salary = ? where id = ?";
		
		PreparedStatement pst = con.prepareStatement(query);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter New Salary : "); double salary = sc.nextDouble();
		System.out.print("Enter Id of Changing Record : "); int id = sc.nextInt();
		
		pst.setDouble(1, salary);
		pst.setInt(2, id);
		
		boolean res = pst.execute();
		
		System.out.println(res);
		System.out.println(pst.getUpdateCount());

	}

}
