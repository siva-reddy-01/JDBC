package Demo;
import java.sql.*;
public class Retrieve 
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
			
			Statement stmt=con.createStatement();
			
			String qry="select * from employee";
			
			ResultSet rs=stmt.executeQuery(qry);
			
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
