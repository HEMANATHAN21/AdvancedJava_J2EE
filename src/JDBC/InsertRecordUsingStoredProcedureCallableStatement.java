package JDBC;
import java.sql.*;
public class InsertRecordUsingStoredProcedureCallableStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		
		String query ="call studentdata.insert(?,?,?,?)";
		CallableStatement cst = con.prepareCall(query);

		cst.setInt(1, 11);
		cst.setString(2, "shanthini");
		cst.setString(3, "shanthini@gmail.com");
		cst.setLong(4, 1234567890);
		
		boolean res = cst.execute();
		
		System.out.println(res);
		System.out.println(cst.getUpdateCount());
	}

}
