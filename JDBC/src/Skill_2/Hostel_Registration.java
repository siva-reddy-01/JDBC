package Skill_2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;


public class Hostel_Registration
{
	 @SuppressWarnings("resource")
	public static void insert_details(Connection con)throws Exception
	{
		try
		{
			
			
			
			
			System.out.println("Fill THE DETAILS TO BOOK A ROOM IN HOSTEL...");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter id number");
			int id_number=sc.nextInt();
			
			System.out.println("enter First name");
			String first_name=sc.next();
			
			System.out.println("enter Second name");
			String second_name=sc.next();
			
			System.out.println("enter year of study");
			int year_of_study=sc.nextInt();
			
			System.out.println("enter gender");
			String gender=sc.next();
			
			System.out.println("enter department");
			String department=sc.next();
			
			System.out.println("enter mobile number");
			String mobile_number=sc.next();
			
			System.out.println("enter Date of birth");
			String data_of_birth=sc.next();
			
			System.out.println("enter parent name");
			String parent_name=sc.next();
			
			System.out.println("enter parent number");
			String parent_number=sc.next();
			
			System.out.println("enter Address ");
			String address=sc.next();
			
			
			
			
			String qry="insert into students values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			pstmt.setInt(1,id_number);
			pstmt.setString(2, first_name);
			pstmt.setString(3, second_name);
			pstmt.setInt(4,year_of_study);
			pstmt.setString(5,gender);
			pstmt.setString(6, department);
			pstmt.setString(7,mobile_number);
			pstmt.setString(8,data_of_birth);
			pstmt.setString(9,parent_name);
			pstmt.setString(10,parent_number);
			pstmt.setString(11,address);
			
			
			
			FileInputStream fin=new FileInputStream("C:\\Users\\Dell\\Downloads\\lord siva.jpg");  
			pstmt.setBinaryStream(12,fin,fin.available()); 
			
			File f=new File("C:\\Users\\Dell\\Downloads\\jfsd.txt");  
			FileReader fr=new FileReader(f);    
			pstmt.setCharacterStream(13,fr,(int)f.length());  
			
			int n= pstmt.executeUpdate();
			System.out.println(n+"Record is Inserted");
			System.out.println("YOUR REGISTRATION FOR HOSTEL ROOM BOOK IS SUCUESSFULLY COMPLETED...");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	public static void main(String[] args)throws Exception
	{
		try
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded..");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd","root","root");
			System.out.println("connection established..");
			
			Statement stmt=con.createStatement();
			
			String qry="create table if not exists students(id_number int primary key,first_name varchar(20),second_name varchar(20) NOT NULL,year_of_study int,gender varchar(20),department varchar(3),mobile_number varchar(20),date_of_birth Date,parent_name varchar(20),parent_mobilenumber varchar(30),address varchar(20),proof_image BLOB,payemet_recepit LONGTEXT)";   
			stmt.executeUpdate(qry);
			System.out.println("Table is created..");
			insert_details(con);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}


