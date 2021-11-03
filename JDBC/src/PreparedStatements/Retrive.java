package PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@SuppressWarnings("unused")
public class Retrive 
{

	public static void main(String[] args)throws Exception
	{
		try
		{
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbd:oracle:thin:@localhost:1521:xe","jfsd","jfsd");
			System.out.println("connection established..");
			
			
			
			String qry="select * from student";
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				int sid=rs.getInt(1);
				
				String sname=rs.getString(2);
				
				double salary=rs.getDouble(3);
				
				String gender=rs.getString(4);
				
				System.out.println(""+sid+"  "+sname+"  "+salary+"  "+gender+"");
				
			
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
