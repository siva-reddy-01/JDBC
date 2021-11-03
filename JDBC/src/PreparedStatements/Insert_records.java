package PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class Insert_records {
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		try
		{
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded");
			con=DriverManager.getConnection("jdbx:oracle:thin:@localhost:1521:xe","jfsd","jfsd");
			System.out.println("connection established");
			
			
			
			
			int sid;
			String sname;
			double salary;
			String gender;
			
			Scanner sc = new Scanner(System.in);
			 
			System.out.println("Enter student id");
			sid= sc.nextInt();
			
			System.out.println("Enter student  name");
			sname= sc.next();
			
			System.out.println("Enter student Salary");
			salary= sc.nextDouble();
			
			System.out.println("Enter student Gender");
			gender = sc.next();
			
			
			 
			 String qry ="insert into student values (?,?,?,?)";
			 PreparedStatement pstmt=con.prepareStatement(qry);
			 pstmt.setInt(1,sid);
			 pstmt.setString(2, sname);
			 pstmt.setDouble(3, salary);
			 pstmt.setString(4, gender);
				
			int n= pstmt.executeUpdate();
				System.out.println(n+"Records is Inserted");
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}

	