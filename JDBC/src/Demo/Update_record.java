package Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Statement;
public class Update_record 
{

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args)throws Exception
	{
		try
		{
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jfsd","jfsd");
			System.out.println("Connection establised..");
			
			Statement stmt=con.createStatement();
			Scanner sc=new Scanner(System.in);
			 System.out.println("Enter eid which you want to change the name");
			 int eid=sc.nextInt();
			 
			 System.out.println("Enter employee name");
			 String ename=sc.next();
			 System.out.println("Enter employee salary");
			 double salary=sc.nextDouble();
			 
			 System.out.println("enter employee gender");
			 String gender=sc.next();
			 
			 String qry ="update employee set ename = '"+ename+"' , salary = "+salary+" where eid = "+eid+" ";
				int  n = stmt.executeUpdate(qry);
				System.out.println(n+"  Result(s) are updated");
			
					 
			 
			 
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
