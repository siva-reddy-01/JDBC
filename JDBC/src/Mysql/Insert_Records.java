package Mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

public class Insert_Records 
{
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		try
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j","root","root");
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
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}