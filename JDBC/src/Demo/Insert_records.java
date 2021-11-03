package Demo;

import java.sql.*;
import java.util.*;

public class Insert_records
{
	
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		try
		{
			Connection con=null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class loaded");
			 con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","root");  
			System.out.println("connection established");
			
			
			Statement stmt = con.createStatement();
			
			int eid;
			String ename;
			double salary;
			String gender;
			
			Scanner sc = new Scanner(System.in);
			 
			System.out.println("Enter employee id");
			eid= sc.nextInt();
			
			System.out.println("Enter employee name");
			ename= sc.next();
			
			System.out.println("Enter employee Salary");
			salary= sc.nextDouble();
			
			System.out.println("Enter employee Gender");
			gender = sc.next();
			
			 String qry ="insert into employee values ( "+eid+" ,'"+ename+"' , "+salary+" , '"+gender+"')";
			stmt.executeUpdate(qry);
			System.out.println("Record is Inserted");
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
}