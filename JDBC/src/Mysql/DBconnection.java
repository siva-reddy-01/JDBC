package Mysql;
import java.sql.*;
public class DBconnection
{

	@SuppressWarnings("unused")
	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub
		
		try
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j","root","root");
			System.out.println("connection established..");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
