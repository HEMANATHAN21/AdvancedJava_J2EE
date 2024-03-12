	package JDBC;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
public class InsertImageInDb 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=solohema");
		
		String query = "insert into imagedata values(?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		
		File f = new File("D:\\MEDIA\\1683561183739.jpg");
		
		FileInputStream fis = new FileInputStream(f);
		int id = 1;
		pst.setInt(1, id);
		pst.setBlob(2, fis);
		
		int res = pst.executeUpdate();
		
		System.out.println(res);

	}

}
