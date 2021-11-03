package PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class Delete_records {

	@SuppressWarnings("resource")
	public static void main(String[] args)throws Exception
	{
	 try
	 {
		 Connection con=null;
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 System.out.println("Driver class loaded..");
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jfsd","jfsd");
		 System.out.println("connection established..");
		 
		
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("enter student sid which you want to delete..");
		 
		 int sid=sc.nextInt();
		 
		 String qry="Delete from student where sid=?";
		 PreparedStatement pstmt=con.prepareStatement(qry);
		 pstmt.setInt(1, sid);
		 
		 int n=pstmt.executeUpdate();
		
		 System.out.println(n+"Records(n) are deleted");
		 
		 
		 
		 
	 }
	 catch(Exception e)
	 {
		System.out.println(e); 
	 }

	}

}
