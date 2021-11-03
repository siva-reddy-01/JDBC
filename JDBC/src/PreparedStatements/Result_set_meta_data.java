package PreparedStatements;
import java.sql.*;
import java.sql.PreparedStatement;

public class Result_set_meta_data 
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
			
			String qry="select * from student_details";
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			ResultSet rs=pstmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			
			System.out.println("Total columns:"+rsmd.getColumnCount());
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
