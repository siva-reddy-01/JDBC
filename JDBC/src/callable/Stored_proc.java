package callable;
import java.sql.*;
import java.util.Scanner;
public class Stored_proc 
{
	@SuppressWarnings("resource")
	public static void main(String ags[])throws Exception
	{
		try
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("connection established..");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter name");
			String name=sc.next();
			
			
			CallableStatement cstmt=con.prepareCall("{call users1(?,?)}");
			cstmt.setInt(1,id);
			cstmt.setString(2,name);
			cstmt.execute();
			System.out.println("sucess");
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
