package JDBC;
import java.sql.*;
public class DeleteRecordUsingStoredProcedureCallableStatement
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		
		String query ="call studentdata.delete(?)";
	
		CallableStatement cst = con.prepareCall(query);
		
		cst.setInt(1, 11);
		
		boolean res = cst.execute();
		
		System.out.println(res);
		
		System.out.println(cst.getUpdateCount());

	}

}
