package Demo;
import java.sql.*;
public class DBconnection 
{
	public static void main(String[] args)throws Exception
	{
		try
		{
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","root");
			if(con!=null)
				System.out.println("connected");
			else
				System.out.println("Not connect");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
