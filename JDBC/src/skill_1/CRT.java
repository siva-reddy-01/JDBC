package skill_1;
import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;


public class CRT
{
	
	
	public static void insert_details(Connection con)throws Exception
	{
		try
		{
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			int sid_number;
			String sname;
			String gender;
			int year_of_study;
			String department;
			String kl_mail;
			Float cgpa;
			int no_of_backlogs;
			
			System.out.println("enter student id number");
			sid_number=sc.nextInt();
			System.out.println("enter student name");
			sname=sc.next();
			System.out.println("enter stuent gender");
			gender=sc.next();
			System.out.println("enter year of study");
			year_of_study=sc.nextInt();
			System.out.println("enter student departent");
			department=sc.next();
			System.out.println("enter student kl mail");
			kl_mail=sc.next();
			System.out.println("enter student cgpa");
			cgpa=sc.nextFloat();
			System.out.println("enter student back logs");
			no_of_backlogs=sc.nextInt();
			String qry="insert into student_details values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(qry);
			pstmt.setInt(1,sid_number);
			pstmt.setString(2,sname);
			pstmt.setString(3,gender);
			pstmt.setInt(4,year_of_study);
			pstmt.setString(5,department);
			pstmt.setString(6,kl_mail);
			pstmt.setDouble(7,cgpa);
			pstmt.setInt(8,no_of_backlogs);
		    pstmt.executeUpdate();
			System.out.println("insert details sucuessfully");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public static void update_details(Connection con)throws Exception
	{
		try
		{
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter student id number");
			int sid_number=sc.nextInt();
			
			System.out.println("Enter no of backlogs");
			int no_of_backlogs=sc.nextInt();
			
			System.out.println("Enter the cgpa");
			Float cgpa=sc.nextFloat();
			
			String qry2="update student_details set cgpa=?,no_of_backlogs=? where sid_number=?";
			PreparedStatement pstmt=con.prepareStatement(qry2);
			pstmt.setFloat(1, cgpa);
			pstmt.setInt(2, no_of_backlogs);
			pstmt.setInt(3, sid_number);
			pstmt.executeUpdate();
			System.out.println("update student details sucuessfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void eligible_students(Connection con)throws Exception
	{
		try
		{
			Statement stmt=con.createStatement();
			String qry3="select * from student_details"+" where cgpa>7.5";
			ResultSet rs=stmt.executeQuery(qry3);
			
			if(rs!=null)
			{
				
			
				while(rs.next())
				{
					int sid_number=rs.getInt(1);
					String sname=rs.getString(2);
					String gender=rs.getString(3);
					int year_of_study=rs.getInt(4);
					String department=rs.getString(5);
					String kl_mail=rs.getString(6);
					Float cgpa=rs.getFloat(7);
					int no_of_backlogs=rs.getInt(8);
					System.out.println(""+sid_number+"  "+sname+"  "+gender+"  "+year_of_study+"  "+department+"  "+kl_mail+"  "+cgpa+"  "+no_of_backlogs+"");
				
					
					
				}
			}
				System.out.println("print qualified students sucussesfully");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void delete_non_qualified_students(Connection con)throws Exception
	{
		try
		{
			Statement stmt=con.createStatement();
			String qry4="delete from student_details where cgpa<7.5";
			stmt.executeUpdate(qry4);
			System.out.println("Delete unqualified students sucessfully");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void print_all_students_data(Connection con)throws Exception
	{
		try
		{
			Statement stmt=con.createStatement();
			String qry5="Select * from student_details";
			ResultSet rs=stmt.executeQuery(qry5);
			if(rs!=null)
			{
				
			
			
				while(rs.next())
				{
					int sid_number=rs.getInt(1);
					String sname=rs.getString(2);
					String gender=rs.getString(3);
					int year_of_study=rs.getInt(4);
					String department=rs.getString(5);
					String kl_mail=rs.getString(6);
					Float cgpa=rs.getFloat(7);
					int no_of_backlogs=rs.getInt(8);
				
					System.out.println(""+sid_number+"  "+sname+"  "+gender+"  "+year_of_study+"  "+department+"  "+kl_mail+"  "+cgpa+"  "+no_of_backlogs+"");
		
				}
				System.out.println("veiw the students details");
			}
			
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	



 @SuppressWarnings("resource")
public static void main(String args[])throws Exception
 {
	 

		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded...");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
		System.out.println("connection established..");  
		Statement stmt=con.createStatement();
		String qry="create table if not exists student_details("+"sid_number int primary key,"+"sname varchar(30),"+"gender varchar(30),"+"year_of_study int,"+"department varchar(20),"+"kl_mail varchar(30),"+"cgpa float,"+"no_of_backlogs int"+");";       
		stmt.executeUpdate(qry);
		System.out.println("Table created..");
	    
	     Scanner sc=new Scanner(System.in);
	     boolean exit=false;
	while(!exit)
	{
		System.out.println("1.insert the student details");
		System.out.println("2.update student details");
		System.out.println("3.veiw qualified students");
		System.out.println("4.Delet unqualified students");
		System.out.println("5.print all students data");
		System.out.println("6.exit");
		
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			insert_details(con);
			break;
		case 2:
			update_details(con);
			break;
		case 3:
			eligible_students(con);
			break;
		case 4:
			delete_non_qualified_students(con);
			break;
		case 5:
			print_all_students_data(con);
			break;
		case 6:
			exit=true;
			break;
		default:
			System.out.println("please try again");
			break;
		}
		
	}
	
	
}
}