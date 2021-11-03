package PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class Update_records 
{

	@SuppressWarnings("resource")
	public static void main(String[] args)throws Exception
	{
		try
		{
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jfsd","jfsd");
			System.out.println("Connection establised..");
			
			
			Scanner sc=new Scanner(System.in);
			 System.out.println("Enter sid which you want to change the name");
			 int sid=sc.nextInt();
			 
			 System.out.println("Enter student name");
			 String sname=sc.next();
			 
			 String qry ="update student set sname=? where sid=?";
			 PreparedStatement pstmt=con.prepareStatement(qry);
			 pstmt.setString(1,sname);
			 pstmt.setInt(2, sid);
			
			int n=pstmt.executeUpdate();
				System.out.println(n+"Result(s) are updated");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
