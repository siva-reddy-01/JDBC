package PreparedStatements;
import java.sql.*;
import java.sql.PreparedStatement;

@SuppressWarnings("unused")
public class Dbmd
{
	public static void main(String args[])throws Exception
	{
		try
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("connection established..");
			
			DatabaseMetaData dbmd=con.getMetaData();
			
			System.out.println("DriverName:"+dbmd.getDriverName());
			System.out.println("DriverVersion:"+dbmd.getDriverVersion());
			System.out.println("ProductName:"+dbmd.getDatabaseProductName());
			System.out.println("Productversion:"+dbmd.getDatabaseProductVersion());
			System.out.println("UserName:"+dbmd.getUserName());
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
