package Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		 System.out.println("connection established..");
		 
		 Statement stmt=con.createStatement();
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("enter employee eid which you want to delete..");
		 
		 int eid=sc.nextInt();
		 
		 String qry="Delete from employee where eid="+eid+"";
		int n= stmt.executeUpdate(qry);
		 System.out.println(n+"Records(n) are deleted");
		 
		 
		 
		 
	 }
	 catch(Exception e)
	 {
		System.out.println(e); 
	 }

	}

}
