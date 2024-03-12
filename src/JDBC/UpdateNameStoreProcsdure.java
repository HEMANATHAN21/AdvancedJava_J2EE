package JDBC;
import java.sql.*;
public class UpdateNameStoreProcsdure {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		String query = "call studentdata.update(?,?);";
		CallableStatement cst = con.prepareCall(query);
		
		cst.setInt(1, 3);
		cst.setString(2, "purushothaman");
		
		cst.execute();
		
	}

}
